package energy.lux.prerender.persistence

import org.gradle.api.file.Directory
import org.gradle.api.tasks.OutputDirectory
import org.http4k.core.Uri

/**
 * Save pages to disk where the directory structure is the domain + path.
 */
data class PerDomainDiskPagePersistence(
    @get:OutputDirectory
    val outputDir: Directory,
): PagePersistence {
    override fun save(pageUri: Uri, html: String) {
        val file = outputDir.file(toOutputFilePath(pageUri))
        file.asFile.parentFile.mkdirs()
        file.asFile.writeText(html)
    }

    fun toOutputFilePath(pageUri: Uri): String {
        val path = pageUri.path
        val filePath = if (path.isEmpty()) {
            "index.html"
        } else {
            "$path.html"
        }

        return "${pageUri.host}/$filePath"
    }
}
