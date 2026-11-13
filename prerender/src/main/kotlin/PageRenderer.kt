package energy.lux.prerender

import com.microsoft.playwright.Page
import com.microsoft.playwright.options.LoadState
import org.http4k.core.Uri
import org.jsoup.Jsoup

/** A rendered page. [url] is where the page ended up, after client-side redirects like `/` -> `/nl/`. */
data class RenderedPage(val url: Uri, val html: String)

/**
 * Renders pages of the site in one browser tab.
 * Parts of this are copied from Kobweb's KobwebExportTask.
 */
class PageRenderer(private val page: Page) {
    fun render(url: Uri): RenderedPage {
        page.navigate(url.query(KOBWEB_EXPORT_QUERY).toString())
        waitUntilRendered()
        inlineProgrammaticStyles()

        val finalUrl = Uri.of(page.url()).query("").fragment("").withSlash()
        val html = Jsoup.parse(page.content()).toString()
        return RenderedPage(finalUrl, html)
    }

    /**
     * Import a JavaScript module in the open tab and call its `prerenderUrls()`.
     * It runs in the tab because the site's code needs a running app (window, Kobweb's AppGlobals).
     */
    fun loadPageList(moduleUrl: String): List<Uri> {
        // language=javascript
        val result = page.evaluate("url => import(url).then(module => module.$PAGE_LIST_FUNCTION())", moduleUrl)
        require(result is List<*>) { "$PAGE_LIST_FUNCTION() in $moduleUrl should return an array, got $result" }
        return result.map { Uri.of(it as String).withSlash() }
    }

    /**
     * Wait until the page's code has loaded and rendered.
     * The code is loaded lazily, so the load event fires too early.
     *
     * Only the page-level spinner (LazyModule) is waited for. Other spinners stay in the HTML,
     * like a model that loads its data from the backend, which is not available here.
     */
    private fun waitUntilRendered() {
        page.waitForLoadState(LoadState.NETWORKIDLE)
        // language=javascript
        page.waitForFunction(
            """
                pendingSelector => {
                    const root = document.getElementById("_kobweb-root")
                    // A page without a Kobweb root (like the test page) is rendered as soon as it loads
                    if (root == null) return true
                    return root.childElementCount > 0 && root.querySelector(pendingSelector) == null
                }
            """.trimIndent(),
            PENDING_MODULE_SELECTOR,
        )
        // Let requests started by the rendered content finish
        page.waitForLoadState(LoadState.NETWORKIDLE)
    }

    /**
     * Compose HTML creates empty style nodes and then adds styles to them programmatically.
     * Copy those styles into the nodes, or the saved HTML would have no styles.
     */
    private fun inlineProgrammaticStyles() {
        // language=javascript
        page.evaluate(
            """
                for (const stylesheet of document.styleSheets) {
                    // Reading an external stylesheet throws a security error, and it isn't empty anyway
                    if (!(stylesheet instanceof CSSStyleSheet) || stylesheet.href != null) continue
                    const styleNode = stylesheet.ownerNode
                    if (!(styleNode instanceof Element) || styleNode.innerHTML != '') continue
                    styleNode.innerHTML = Array.from(stylesheet.cssRules)
                        .map(rule => rule.cssText.replace(/\n/g, ''))
                        .join('')
                }
            """.trimIndent()
        )
    }

    companion object {
        /** Tells Kobweb the page is being exported, like Kobweb's own export does. */
        const val KOBWEB_EXPORT_QUERY = "_kobwebIsExporting=true"

        /** Set by LazyModule in the site while a page's code is still loading. */
        const val PENDING_MODULE_SELECTOR = "[data-pending-module]"

        /** The function the page list module exports, see PrerenderUrls.kt in the site. */
        const val PAGE_LIST_FUNCTION = "prerenderUrls"
    }
}

/** Browsers report http://host as http://host/ */
internal fun Uri.withSlash(): Uri = if (path.isEmpty()) path("/") else this
