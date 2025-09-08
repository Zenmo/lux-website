package com.zenmo.server.js.loader

import energy.lux.site.shared.AccessPolicy
import org.http4k.routing.ResourceLoader
import java.time.Instant

/**
 * Wrap a JsLoader with cache logic
 */
class CachingJsLoader(
    private val resourceLoader: ResourceLoader,
    private val jsLoader: JsLoader,
): JsLoader {
    /**
     * Map Path to JsResult.
     */
    private val cache: MutableMap<String, JsResult> = mutableMapOf()

    override fun load(path: String): JsResult? {
        val url = resourceLoader.load(path)
        if (url == null) {
            return null
        }

        val lastModified = Instant.ofEpochMilli(url.openConnection().lastModified)

        val cacheEntry = cache[path]
        if (cacheEntry != null && cacheEntry.lastModified == lastModified) {
            println("Cache hit for $path")
            return cacheEntry
        }

        println("Cache miss for $path")

        val newEntry = this.jsLoader.load(path)
        if (newEntry != null) {
            cache[path] = newEntry
        }

        return cache[path]
    }
}
