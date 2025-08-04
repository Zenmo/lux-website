package energy.lux.prerender

import energy.lux.prerender.persistence.InMemoryPagePersistence
import org.gradle.testfixtures.ProjectBuilder
import org.http4k.core.HttpHandler
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.Http4kServer
import org.http4k.server.asServer
import org.http4k.server.Undertow
import kotlin.test.Test
import org.gradle.kotlin.dsl.register
import org.http4k.core.Uri
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class PreRenderTest {
    /**
     * Serves the same HTML for every path
     */
    fun startFrontEndServer(port: Int = 8080): Http4kServer {
        // app which returns the same html for every path
        val app: HttpHandler = {
            val resourceUri = this.javaClass.getResource("/spa.html")

            Response(OK)
                .header("Content-Type", "text/html")
                .body(resourceUri!!.openStream())
        }
        return app.asServer(Undertow(port)).start()
    }

    @Test
    fun testPreRendering() {
        val port = 8081

        startFrontEndServer(port).use {
            val project = ProjectBuilder.builder().build()
            val task = project.tasks.register<PreRenderTask>("preRender")
            var persistence = InMemoryPagePersistence()
            task.configure {
                entryPointUrl.set("http://localhost:$port")
                outputDir.set(project.layout.buildDirectory.dir("preRender"))
                this.persistence.set(persistence)
            }

            task.get().action()

            val pages = persistence.getPages()
            assertEquals(2, pages.size)

            val homePage = pages[Uri.of("http://localhost:$port")]
            assertNotNull(homePage)
            assertContains(homePage, "<h1>Home page</h1>")

            val subPage = pages[Uri.of("http://localhost:$port/sub/page")]
            assertNotNull(subPage)
            assertContains(subPage, "<h1>Sub page</h1>")
        }
    }
}