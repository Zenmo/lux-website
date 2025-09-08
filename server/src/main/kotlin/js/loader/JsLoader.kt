
package com.zenmo.server.js.loader

import energy.lux.site.shared.AccessPolicy

/**
 * Interface for loading JavaScript files.
 * This has a caching and non-caching implementation
 */
fun interface JsLoader {
    fun load(path: String): JsResult?
}

typealias JsResult = JsResultGeneric<AccessPolicy>

class JsResultGeneric<out T: AccessPolicy>(
    val accessPolicy: T,
    val content: ByteArray,
    val lastModified: java.time.Instant,
    val eTag: String,
)
