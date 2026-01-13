package com.zenmo.web.zenmo.domains.lux.components.model


sealed class TwinModel(
    val title: String,
    val entryPoint: String?,
    val image: String,
    val isPrivate: Boolean = false
) {
    open fun url(path: String, protocol: String, luxDomain: String): String {
        return "${protocol}//$luxDomain/$path/${title.lowercase()}"
    }

    val searchTokens: List<String>
        get() = listOf(title)

}