package com.zenmo.backend

import com.zenmo.backend.js.JsServer
import com.zenmo.backend.js.loader.CachingJsLoader
import org.http4k.core.Request
import org.http4k.routing.ResourceLoader
import kotlin.test.Test
import org.http4k.core.Method.GET
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class JsCacheTest {
    /**
     * Verify that the ETag HTTP logic works as expected.
     * Verify that the JsLoader is only called once per file.
     */
    @Test
    fun testBothCaches() {
        val resourceLoader = ResourceLoader.Classpath("/js")
        val mockJsLoader = MockJsLoader(resourceLoader)

        val jsServer = JsServer(
            jsLoader = CachingJsLoader(resourceLoader, mockJsLoader),
            resourceLoader = resourceLoader,
            oAuthSessions = InMemorySessionOAuthPersistence(),
            clientId = "clientId",
        )

        val response1 = jsServer.invoke(Request(GET, "/script1.js"))
        assertEquals(200, response1.status.code)
        assertNotNull(response1.header("ETag"))
        assertEquals("script1content", response1.bodyString())

        val response2 = jsServer.invoke(
            Request(GET, "/script1.js").header("If-None-Match", "other-etag")
        )
        assertEquals(200, response2.status.code)

        val response3 = jsServer.invoke(
            Request(GET, "/script1.js").header("If-None-Match", response1.header("ETag"))
        )
        assertEquals(304, response3.status.code)
        assertEquals(0, response3.body.length)

        assertEquals(1, mockJsLoader.requestCount)

        val response4 = jsServer.invoke(Request(GET, "/script2.js"))
        assertEquals(200, response1.status.code)
        assertEquals("script2content", response4.bodyString())

        assertEquals(2, mockJsLoader.requestCount)
    }
}

