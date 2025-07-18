package com.zenmo.server.js.loader

import com.zenmo.server.js.JsAccessPolicyEvaluator
import com.zenmo.server.js.getScriptAccessPolicy
import org.http4k.routing.ResourceLoader
import java.time.Instant

class DefaultJsLoader(
    private val resourceLoader: ResourceLoader,
    private val accessPolicyEvaluator: JsAccessPolicyEvaluator = getScriptAccessPolicy,
): JsLoader {
    override fun load(path: String): JsResult? {
        val url = resourceLoader.load(path)
        if (url == null) {
            return null
        }

        val connection = url.openConnection()
        val lastModified = connection.lastModified
        // immediately read into memory to prevent desync
        val content = connection.getInputStream().readBytes()

        val filename = path.substringAfterLast('/')
        val accessPolicy = accessPolicyEvaluator.eval(content.inputStream().reader(), filename)

        val cleanPath = path.replace(Regex("\\W"), "")
        val eTag = "$cleanPath-$lastModified"

        return JsResult(
            lastModified = Instant.ofEpochMilli(lastModified),
            accessPolicy = accessPolicy,
            content = content,
            eTag = eTag,
        )
    }
}
