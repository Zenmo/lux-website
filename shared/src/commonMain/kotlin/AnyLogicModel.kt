package energy.lux.site.shared

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class AnyLogicModel(
    val uuid: String,
    val lastModifiedDate: String,
) {
    companion object {
        fun listFromJson(jsonString: String): List<AnyLogicModel> =
            Json.decodeFromString(jsonString)
    }
}