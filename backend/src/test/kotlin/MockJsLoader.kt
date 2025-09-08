package com.zenmo.backend

import com.zenmo.backend.js.loader.JsLoader
import com.zenmo.backend.js.loader.JsResult
import energy.lux.site.shared.AccessPolicy
import org.http4k.routing.ResourceLoader
import java.time.Instant

/**
 * Loader which does not evaluate the javascript, just returns the file info
 */
class MockJsLoader(
    private val resourceLoader: ResourceLoader,
): JsLoader {
    var requestCount = 0

    override fun load(path: String): JsResult? {
        requestCount++

        val url = resourceLoader.load(path)
        if (url == null) {
            return null
        }

        val connection = url.openConnection()

        return JsResult(
            accessPolicy = AccessPolicy.Public(),
            content = connection.inputStream.readBytes(),
            lastModified = Instant.ofEpochMilli(connection.lastModified),
            eTag = "etag",
        )
    }
}
