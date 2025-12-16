package com.zenmo.web.zenmo.domains.lux.components.model

/**
 * Simple UI-only representation of a Twin.
 * Only contains a title and image; does not represent a domain model.
 */
data class SimpleTwin(
    val modelTitle: String,
    val modelImage: String
) : TwinModel(
    title = modelTitle,
    entryPoint = "",
    image = modelImage,
    isPrivate = true
)