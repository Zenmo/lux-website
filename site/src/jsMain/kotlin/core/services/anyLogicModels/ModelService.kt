package energy.lux.frontend.core.services.anyLogicModels

import com.varabyte.kobweb.core.AppGlobals
import energy.lux.site.shared.AnyLogicModel
import web.http.fetch
import web.url.URL


interface ModelsDataSource {
    suspend fun getAllModels(): List<AnyLogicModel>
}

class ModelService(
    private val backendUrl: String = AppGlobals.getValue("BACKEND_URL"),
) : ModelsDataSource {
    override suspend fun getAllModels(): List<AnyLogicModel> {
        val response = fetch(URL(backendUrl).apply { pathname = "/api/anylogic-models" })
        if (response.status != 200.toShort()) {
            throw Exception(response.text())
        }
        return AnyLogicModel.listFromJson(response.text())
    }
}

