package energy.lux.prerender

import energy.lux.prerender.persistence.PerDomainDiskPagePersistence
import org.gradle.testfixtures.ProjectBuilder
import org.http4k.core.Uri
import kotlin.test.Test
import kotlin.test.assertEquals

class PerDomainDiskPagePersistenceTest {
    private val persistence = PerDomainDiskPagePersistence(ProjectBuilder.builder().build().layout.projectDirectory)

    private fun pathFor(url: String) = persistence.toOutputFilePath(Uri.of(url))

    @Test
    fun `a folder URL is saved as index html`() {
        assertEquals("lux.localhost/index.html", pathFor("http://lux.localhost/"))
        assertEquals("lux.localhost/nl/index.html", pathFor("http://lux.localhost/nl/"))
    }

    @Test
    fun `a page URL is saved as an html file`() {
        assertEquals("lux.localhost/en/about.html", pathFor("http://lux.localhost/en/about"))
    }
}
