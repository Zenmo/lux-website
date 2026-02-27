package energy.lux.site.shared

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlin.js.JsExport
import kotlin.time.Instant
import kotlin.uuid.Uuid

@JsExport
@Serializable
data class AnyLogicModel(
    val uuid: Uuid,
    @Serializable(with = InstantSerializer::class)
    val lastModifiedDate: Instant
) {
    companion object {
        fun listFromJson(jsonString: String): List<AnyLogicModel> =
            Json.decodeFromString(jsonString)
    }
}

object InstantSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Instant", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): Instant {
        return Instant.parse(decoder.decodeString())
    }
}