package com.zenmo.web.zenmo.core.services

import com.varabyte.kobweb.core.AppGlobals
import energy.lux.site.shared.AnyLogicModel
import web.http.fetch
import web.url.URL

class ModelService(
    private val backendUrl: String = AppGlobals.getValue("BACKEND_URL"),
) {

    private suspend fun getAllModels(): List<AnyLogicModel> {
        val url = URL(backendUrl)
        url.pathname = "/api/anylogic-models"
        val response = fetch(url)
        if (response.status != 200.toShort()) {
            throw Exception("Failed to fetch models: ${response.status}")
        }
        val models = AnyLogicModel.listFromJson(response.text())
        console.log("Fetched models: $models")
        return models
    }
}