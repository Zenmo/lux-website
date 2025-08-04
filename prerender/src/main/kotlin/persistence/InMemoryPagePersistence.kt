package energy.lux.prerender.persistence

import org.http4k.core.Uri

/**
 * Store HTML pages in memory.
 * For testing purposes.
 */
class InMemoryPagePersistence: PagePersistence {
    private val pages = mutableMapOf<Uri, String>()

    fun getPages(): Map<Uri, String> = pages

    override fun save(url: Uri, html: String) {
        pages[url] = html
    }
}
