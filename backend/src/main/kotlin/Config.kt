package com.zenmo.backend

import com.zenmo.backend.contact.SmtpConfig
import java.lang.System.getenv

data class Config(
    val port: Int = getenv("PORT")?.toInt() ?: 9000,

    val baseUrl: String = getenv("BASE_URL") ?: "http://localhost:$port",
    val clientId: String = getEnvRequired("CLIENT_ID"),
    val clientSecret: String = getEnvRequired("CLIENT_SECRET"),
    val anylogicApiKey: String = getEnvRequired("ANYLOGIC_API_KEY"),

    val smtpConfig: SmtpConfig = SmtpConfig.create(),
    val contactMailRecipients: List<String> = getEnvRequired("CONTACT_MAIL_RECIPIENTS")
        .split(",")
        .map { it.trim() },

    val javaScriptFileSource: JavaScriptFileSource = JavaScriptFileSource.valueOf(
        getEnvRequired("JS_FILE_SOURCE")
    )
)

enum class JavaScriptFileSource {
    CLASSPATH, // production, from the resources folder
    DIRECTORY, // dev
}

fun getEnvRequired(name: String): String {
    return getenv(name) ?: throw IllegalArgumentException("Environment variable $name is required")
}
