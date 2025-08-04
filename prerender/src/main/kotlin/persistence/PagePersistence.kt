package energy.lux.prerender.persistence

import org.http4k.core.Uri

/**
 * This interface gives implementers the opportunity
 * to specify how HTML pages are saved.
 */
interface PagePersistence {
    fun save(url: Uri, html: String)
}

