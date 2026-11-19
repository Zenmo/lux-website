package energy.lux.prerender

import java.io.File
import kotlin.io.path.createTempDirectory
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PublicChunksTest {
    private val dir = createTempDirectory("chunks").toFile()

    private fun chunk(content: String) = File(dir, "${content.hashCode()}.mjs").apply { writeText(content) }

    @Test
    fun `a chunk with the Public policy is public`() {
        assertTrue(PublicChunks().isPublic(chunk("accessPolicy\$1 = new (Public())();")))
    }

    @Test
    fun `a chunk with a role is not public`() {
        assertFalse(PublicChunks().isPublic(chunk("accessPolicy\$1 = new (RoleBased())('Hessenpoort');")))
    }

    @Test
    fun `a chunk that only re-exports another chunk is not public`() {
        val reExport = "export { ProtectedComponent\$1 as ProtectedComponent, accessPolicy\$1 as accessPolicy } from './x.mjs';"
        assertFalse(PublicChunks().isPublic(chunk(reExport)))
    }

    @Test
    fun `a missing file is not public`() {
        assertFalse(PublicChunks().isPublic(File(dir, "missing.mjs")))
    }
}
