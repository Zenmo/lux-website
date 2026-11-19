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
import org.http4k.core.Uri
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class PreRenderTest {
    /**
     * Serves the same HTML for every path, like a single-page app,
     * and a page list module that lists one more page.
     */
    fun startFrontEndServer(port: Int): Http4kServer {
        val app: HttpHandler = { request ->
            if (request.uri.path == "/pages.mjs") {
                Response(OK)
                    .header("Content-Type", "text/javascript")
                    .body("""export function prerenderUrls() { return ["http://localhost:$port/sub/page"] }""")
            } else {
                Response(OK)
                    .header("Content-Type", "text/html")
                    .body(javaClass.getResource("/spa.html")!!.openStream())
            }
        }
        return app.asServer(Undertow(port)).start()
    }

    @Test
    fun testPreRendering() {
        val port = 8081

        startFrontEndServer(port).use {
            val project = ProjectBuilder.builder().build()
            val task = project.tasks.register("preRender", PreRenderTask::class.java)
            var persistence = InMemoryPagePersistence()
            task.configure {
                it.startUrls.set(listOf("http://localhost:$port"))
                it.pageListModuleUrl.set("http://localhost:$port/pages.mjs")
                it.outputDir.set(project.layout.buildDirectory.dir("preRender"))
                it.persistence.set(persistence)
            }

            task.get().action()

            val pages = persistence.getPages()
            assertEquals(2, pages.size)

            val homePage = pages[Uri.of("http://localhost:$port/")]
            assertNotNull(homePage)
            assertContains(homePage, "<h1>Home page</h1>")

            val subPage = pages[Uri.of("http://localhost:$port/sub/page")]
            assertNotNull(subPage)
            assertContains(subPage, "<h1>Sub page</h1>")
        }
    }
}