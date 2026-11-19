package energy.lux.prerender

import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Playwright
import energy.lux.prerender.impl.PlaywrightInstaller
import energy.lux.prerender.persistence.PagePersistence
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.http4k.core.Uri

/**
 * Renders pages in a headless browser and saves the resulting HTML.
 *
 * 1. Render the [startUrls].
 * 2. Ask the open page for the full list of pages ([pageListModuleUrl]).
 * 3. Render every page in that list. A page that fails is skipped and reported, the run goes on.
 *
 * The site picks the (sub)domain to show from `window.location.host`,
 * so pages are visited under their real host name.
 * When the build output is configured ([staticDir], [jsDir], [jsBaseUrl]),
 * [BuildOutputServer] answers those requests, so no web server or backend has to run.
 */
abstract class PreRenderTask: DefaultTask() {
    /** Pages to render first, e.g. `http://lux.localhost:8080/nl/`. */
    @get:Input
    val startUrls: ListProperty<String> = project.objects.listProperty(String::class.java)

    /**
     * URL of a JavaScript module that exports `prerenderUrls()`, which returns the full URLs of all pages.
     * It is loaded in the browser after the start URLs have rendered, because it needs the running app.
     */
    @get:Optional
    @get:Input
    val pageListModuleUrl: Property<String> = project.objects.property(String::class.java)

    /** Built static site (index.html and assets). */
    @get:Optional
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val staticDir: DirectoryProperty = project.objects.directoryProperty()

    /** Built JavaScript (the Rollup output), normally served by the backend. */
    @get:Optional
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val jsDir: DirectoryProperty = project.objects.directoryProperty()

    /** The URL the site loads its JavaScript from, i.e. BACKEND_URL. */
    @get:Optional
    @get:Input
    val jsBaseUrl: Property<String> = project.objects.property(String::class.java)

    /** Max milliseconds to wait for one page to finish rendering. */
    @get:Input
    val renderTimeoutMillis: Property<Long> = project.objects.property(Long::class.java).convention(20_000L)

    @get:OutputDirectory
    val outputDir: DirectoryProperty = project.objects.directoryProperty()

    @get:Nested
    val persistence: Property<PagePersistence> = project.objects.property(PagePersistence::class.java)

    @TaskAction
    fun action() {
        val startPages = startUrls.get().map { Uri.of(it).withSlash() }
        require(startPages.isNotEmpty()) { "No startUrls configured for $name" }
        val buildOutput = buildOutputServer()
        buildOutput?.addSiteHosts(startPages.map { it.host })
        val run = RenderRun()

        withBrowserContext { context ->
            buildOutput?.installOn(context)
            val tab = context.newPage()
            tab.onPageError { logger.warn("JavaScript error on ${tab.url()}: $it") }
            val renderer = PageRenderer(tab)

            startPages.forEach { renderAndSave(renderer, it, run) }

            if (pageListModuleUrl.isPresent) {
                val listedPages = renderer.loadPageList(pageListModuleUrl.get())
                logger.lifecycle("${pageListModuleUrl.get()} lists ${listedPages.size} page(s)")
                buildOutput?.addSiteHosts(listedPages.map { it.host })
                listedPages.forEach { renderAndSave(renderer, it, run) }
            }
        }

        report(run)
    }

    /** Render one page and save it, or remember why it failed. */
    private fun renderAndSave(renderer: PageRenderer, url: Uri, run: RenderRun) {
        if (!run.visited.add(url)) {
            return
        }
        logger.info("Pre-rendering $url")
        try {
            val rendered = renderer.render(url)
            if (rendered.url != url) {
                logger.info("$url redirected to ${rendered.url}")
                // Already saved under its final URL
                if (!run.visited.add(rendered.url)) return
            }
            persistence.get().save(rendered.url, rendered.html)
            run.saved += rendered.url
        } catch (e: Exception) {
            val reason = e.shortReason()
            logger.warn("Could not pre-render $url: $reason")
            run.skipped[url] = reason
        }
    }

    private fun report(run: RenderRun) {
        logger.lifecycle("Pre-rendered ${run.saved.size} page(s) into ${outputDir.get().asFile}")
        if (run.skipped.isNotEmpty()) {
            logger.warn(
                "Skipped ${run.skipped.size} page(s) that failed to render. The browser renders them as before:\n" +
                    run.skipped.entries.joinToString("\n") { (url, reason) -> "  $url: $reason" }
            )
        }
    }

    /** Null when the build output is not configured: then the pages come from a running server. */
    private fun buildOutputServer(): BuildOutputServer? {
        val settings = listOf(staticDir, jsDir, jsBaseUrl)
        if (settings.none { it.isPresent }) {
            return null
        }
        require(settings.all { it.isPresent }) { "Set all of staticDir, jsDir and jsBaseUrl, or none of them" }
        return BuildOutputServer(
            staticDir = staticDir.get().asFile,
            jsDir = jsDir.get().asFile,
            jsBaseUrl = jsBaseUrl.get(),
            log = { logger.info(it) },
        )
    }

    private fun withBrowserContext(block: (BrowserContext) -> Unit) {
        PlaywrightInstaller().install()
        // The browser was downloaded by the installer above
        val options = Playwright.CreateOptions().setEnv(mapOf("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD" to "1"))
        Playwright.create(options).use { playwright ->
            // Firefox, because inlining styles in Chromium produces @scope rules that Firefox does not support
            playwright.firefox().launch().use { browser ->
                browser.newContext().use { context ->
                    context.setDefaultTimeout(renderTimeoutMillis.get().toDouble())
                    block(context)
                }
            }
        }
    }
}

/** What happened to the pages in one run of the task. */
private class RenderRun {
    /** Pages that were requested or redirected to, so each is rendered once. */
    val visited = mutableSetOf<Uri>()
    val saved = mutableListOf<Uri>()
    val skipped = linkedMapOf<Uri, String>()
}

/** Playwright errors start with "Error {", the useful part is on the "message=" line. */
private fun Exception.shortReason(): String {
    val lines = message?.lines().orEmpty()
    val line = lines.firstOrNull { "message=" in it } ?: lines.firstOrNull() ?: toString()
    return line.trim().removePrefix("message=")
}
