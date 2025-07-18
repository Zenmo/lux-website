package com.zenmo.server.js

import energy.lux.site.shared.AccessPolicy
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.io.IOAccess
import java.io.Reader
import java.net.URL

fun interface JsAccessPolicyEvaluator {
    fun eval(sourceReader: Reader, fileName: String): AccessPolicy
    fun eval(url: URL): AccessPolicy =
        eval(url.openStream().reader(), url.toString().substringAfterLast("/"))
}

val getScriptAccessPolicy = JsAccessPolicyEvaluator { sourceReader, fileName ->
    val context = Context.newBuilder("js")
        .option("js.esm-eval-returns-exports", "true")
        .allowIO(IOAccess.ALL) // allow imports
        .build()

    val source = Source.newBuilder("js", sourceReader, fileName).build()
    val output = context.eval(source)
    val jsAccessPolicy = output.getMember("accessPolicy")
    val jsonAccessPolicy = jsAccessPolicy.invokeMember("get").invokeMember("toJson")

    println("JSON accessPolicy of $fileName: $jsonAccessPolicy")

    AccessPolicy.Companion.fromJson(jsonAccessPolicy.asString())
}
