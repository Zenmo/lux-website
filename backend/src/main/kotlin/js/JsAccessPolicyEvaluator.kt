package com.zenmo.backend.js

import energy.lux.site.shared.AccessPolicy
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.io.IOAccess
import java.io.Reader
import java.net.URL

fun interface JsAccessPolicyEvaluator {
    fun eval(url: URL): AccessPolicy
}

val getScriptAccessPolicy = JsAccessPolicyEvaluator { url ->
    val context = Context.newBuilder("js")
        .option("js.esm-eval-returns-exports", "true")
        .allowIO(IOAccess.ALL) // allow imports
        .build()

    val source = Source.newBuilder("js", url).build()
    val output = context.eval(source)
    val jsAccessPolicy = output.getMember("accessPolicy")
    val jsonAccessPolicy = jsAccessPolicy.invokeMember("get").invokeMember("toJson")

    println("JSON accessPolicy of $url: $jsonAccessPolicy")

    AccessPolicy.Companion.fromJson(jsonAccessPolicy.asString())
}
