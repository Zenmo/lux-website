package energy.lux.prerender

import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import energy.lux.prerender.impl.PlaywrightInstaller
import energy.lux.prerender.persistence.PagePersistence
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Nested
import org.http4k.core.Uri
import org.http4k.core.relative
import org.jsoup.Jsoup

/**
 * This is mostly copied from KobwebExportTask
 */
abstract class PreRenderTask: DefaultTask() {
    @get:Input
    val entryPointUrl: Property<String> = project.objects.property(String::class.java)

    @get:OutputDirectory
    val outputDir: DirectoryProperty = project.objects.directoryProperty()

    @get:Nested
    val persistence: Property<PagePersistence> = project.objects.property(PagePersistence::class.java)

    /** Initialize in action() as per Gradle best practices */
    private lateinit var pagesDone: MutableSet<Uri>

    @TaskAction
    fun action() {
        pagesDone = mutableSetOf()
        PlaywrightInstaller().install()
        Playwright.create(
            Playwright.CreateOptions().setEnv(
                mapOf(
                    // Should have been downloaded above
                    "PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD" to "1"
                )
            )
        )
            // Use Firefox because running inlineProgrammaticStyles()
            // in Chromium produces @scope styles which are not supported in Firefox
            .firefox()
            .launch()
            .use { browser ->
                browser.newContext().use { context ->
                    context.setDefaultTimeout(10_000.0)
                    val page = context.newPage()
                    page.onPageError {
                        logger.error("Error while pre-rendering ${page.url()}. Probably something is wrong with the page. Details: $it")
                    }
                    page.navigate(entryPointUrl.get())
                    takeSnapshot(page, Uri.of(entryPointUrl.get()))
                }
            }
    }

    private fun takeSnapshot(page: Page, url: Uri) {
        page.waitForLoadState()
        if (pagesDone.contains(url)) {
            return
        }

        logger.info("Pre-rendering $url")

        inlineProgrammaticStyles(page)
        val parsedHtml = Jsoup.parse(page.content())
        val prettyHtml = parsedHtml.toString()
        persistence.get().save(url, prettyHtml)
        pagesDone.add(url)

        val links = parsedHtml.select("a[href]")
            .map {
                val href = it.attr("href")
                url.relative(href)
                    .fragment("")
                    .query("")
            }
            .distinct()

        links.forEach { link ->
            if (link.shouldFollowLink(url) && !pagesDone.contains(link)) {
                logger.info("Following $link from $url")
                page.navigate(link.query("_kobwebIsExporting=true&_kobwebColorModeStrategy=BOTH").toString())
                // recurse
                takeSnapshot(page, link)
            } else {
                logger.info("Skipping $link because it's not eligible ")
            }
        }
    }

    /**
     * Compose HTML creates empty style nodes and then adds styles to them programmatically.
     * These nodes would render as empty without this intervention.
     */
    private fun inlineProgrammaticStyles(page: Page) {
        // language=javascript
        page.evaluate(
            """
                for (let s = 0; s < document.styleSheets.length; s++) {
                    var stylesheet = document.styleSheets[s]
                    stylesheet = stylesheet instanceof CSSStyleSheet ? stylesheet : null;

                    // Trying to peek at external stylesheets causes a security exception so step over them
                    if (stylesheet != null && stylesheet.href == null) {
                        var styleNode = stylesheet.ownerNode
                        styleNode = styleNode instanceof Element ? styleNode : null
                        if (styleNode != null && styleNode.innerHTML == '') {
                            const rules = []
                            for (let r = 0; r < stylesheet.cssRules.length; ++r) {
                                rules.push(stylesheet.cssRules[r].cssText.replace(/(\n)/gm, ''))
                            }
                            styleNode.innerHTML = rules.join('')
                        }
                    }
                }
            """.trimIndent()
        )
    }

    private fun Uri.shouldFollowLink(originPage: Uri): Boolean {
        if (this == originPage) {
            return false
        }

        // Ignore download links
        if (hasFileExtension()) {
            return false
        }

        // Ignore mailto links etc
        if (originPage.scheme != scheme) {
            return false
        }

        if (originPage.host == host) {
            return true
        }

        if (isSubdomain(originPage)) {
            return true
        }

        return false
    }

    private fun Uri.hasFileExtension(): Boolean =
        path.substringAfterLast('/').contains('.')

    private fun Uri.isSubdomain(origin: Uri) =
        host.endsWith(origin.host)
}
