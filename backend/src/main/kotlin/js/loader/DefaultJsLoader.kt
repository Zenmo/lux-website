package com.zenmo.backend.js.loader

import com.zenmo.backend.js.JsAccessPolicyEvaluator
import com.zenmo.backend.js.getScriptAccessPolicy
import org.http4k.routing.ResourceLoader
import java.security.MessageDigest
import java.time.Instant

class DefaultJsLoader(
    private val resourceLoader: ResourceLoader,
    private val accessPolicyEvaluator: JsAccessPolicyEvaluator = getScriptAccessPolicy,
) : JsLoader {
    override fun load(path: String): JsResult? {
        val url = resourceLoader.load(path)
        if (url == null) {
            return null
        }

        val accessPolicy = accessPolicyEvaluator.eval(url)
        val connection = url.openConnection()
        val lastModified = connection.lastModified
        // immediately read into memory to prevent desync
        val content = connection.getInputStream().readBytes()
        val eTag = createETag(content)

        return JsResult(
            lastModified = Instant.ofEpochMilli(lastModified),
            accessPolicy = accessPolicy,
            content = content,
            eTag = eTag,
        )
    }

    private fun createETag(content: ByteArray): String =
        content.contentHashCode().toString(32)
}
