package com.zenmo.backend.js

import energy.lux.site.shared.AccessPolicy
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.io.IOAccess
import java.net.URL

fun interface JsAccessPolicyEvaluator {
    fun eval(url: URL): AccessPolicy
}

val getScriptAccessPolicy = JsAccessPolicyEvaluator { url ->
    val context = Context.newBuilder("js")
        .option("js.esm-eval-returns-exports", "true")
        .allowIO(IOAccess.ALL) // allow imports
        .build()

    addShims(context)

    val source = Source.newBuilder("js", url).build()
    val output = context.eval(source)
    val jsAccessPolicy = output.getMember("accessPolicy")
    if (jsAccessPolicy == null) {
        throw Exception("Can't serve javascript module because it does not have an exported member accessPolicy: $url")
    }
    val jsonAccessPolicy = jsAccessPolicy.invokeMember("get").invokeMember("toJson")

    println("JSON accessPolicy of $url: $jsonAccessPolicy")

    AccessPolicy.fromJson(jsonAccessPolicy.asString())
}

/**
 * There is, unfortunately, some top-level code that uses browser-specific APIs.
 * We need to shim this to evaluate the access policy.
 *
 * This does not affect the served JavaScript.
 */
private fun addShims(context: Context) {
    context.eval(
        "js",
        """
            globalThis.TextDecoder = class {}
            globalThis.crypto = {
                getRandomValues: function(typedArray) { 
                    return typedArray 
                }
            }
            globalThis.CSSStyleSheet = class {
                replaceSync() {}
            }
        """.trimIndent()
    )
}
