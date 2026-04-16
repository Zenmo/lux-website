package energy.lux.frontend.domains.lux.core.model.subdomain

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.PrivateTwinModel
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.*
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenRouting
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.Genius
import domains.lux.subdomains.private_subdomains.oss.OssRouting
import kotlin.uuid.Uuid


enum class PrivateSubdomainModel(
    override val subdomain: String,
    override val subdomainComponent: @Composable () -> Unit,
    override val label: LocalizedText,
    override val applicationArea: LuxApplicationArea,
    override val imageUrl: String,
    override val entryPoint: String,
    override val modelId: Uuid = Uuid.NIL,
) : SubdomainTwinModel, PrivateTwinModel {
    DRECHTSTEDEN(
        subdomain = "drechtsteden",
        subdomainComponent = { DrechtstedenRouting() },
        label = LocalizedText(nl = "Drechtsteden"),
        imageUrl = "/lux/images/model_thumbnails/drechtsteden-rivier.jpg",
        entryPoint = "drechtsteden",
        applicationArea = LuxApplicationArea.LUX_REGION
    ),
    GENUIS(
        subdomain = "genius",
        subdomainComponent = { Genius() },
        label = LocalizedText(nl = "Genius"),
        imageUrl = "/lux/images/model_thumbnails/GENIUS5.jpg",
        entryPoint = "genius",
        modelId = Uuid.parse("42e7ad8d-102f-4a32-808c-65bdd646a52a"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
    ),
    HESSENPOORT(
        subdomain = "hessenpoort",
        subdomainComponent = { Hessenpoort() },
        label = LocalizedText(nl = "Hessenpoort"),
        imageUrl = "/lux/images/model_thumbnails/Hessenpoort2.jpg",
        entryPoint = "hessenpoort",
        modelId = Uuid.parse("ebade042-5518-4162-8eb5-f55439c67c64"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
    ),
    KAS_ALS_ENERGIEBRON(
        subdomain = "kasalsenergiebron",
        subdomainComponent = { KasAlsEnergiebron() },
        label = LocalizedText(nl = "Kas Als Energiebron"),
        imageUrl = "/lux/images/model_thumbnails/kasalsenergiebron6.jpg",
        entryPoint = "kasalsenergiebron",
        modelId = Uuid.parse("7dfd7bdd-9882-4c58-bfc2-5aa6e5aac938"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
    ),
    PREZERO(
        subdomain = "prezero",
        subdomainComponent = { PreZero() },
        label = LocalizedText(nl = "PreZero"),
        imageUrl = "/lux/images/model_thumbnails/ModelThumbnailPreZero.png",
        entryPoint = "prezero",
        modelId = Uuid.parse("72d47601-ffb6-4b66-b7a1-81cb289c6f4e"),
        applicationArea = LuxApplicationArea.LUX_BUSINESS
    ),
    BORCHWERF(
        subdomain = "borchwerf",
        subdomainComponent = { Borchwerf() },
        label = LocalizedText(nl = "Borchwerf"),
        imageUrl = "/lux/images/model_thumbnails/borchwerf.png",
        entryPoint = "borchwerf",
        modelId = Uuid.parse("0ef687d2-3227-47da-b9e1-5ea5751af17d"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    DE_WIEKEN(
        subdomain = "dewieken",
        subdomainComponent = { DeWieken() },
        label = LocalizedText(nl = "De Wieken"),
        imageUrl = "/lux/images/model_thumbnails/dewieken.png",
        entryPoint = "dewieken",
        modelId = Uuid.parse("784ed110-8b2c-4bcf-be75-54f69d278ec6"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    VAANPARK(
        subdomain = "vaanpark",
        subdomainComponent = { Vaanpark() },
        label = LocalizedText(nl = "Vaanpark"),
        imageUrl = "/lux/images/model_thumbnails/vaanpark.png",
        entryPoint = "vaanpark",
        modelId = Uuid.parse("b72013ef-c6b4-4171-afef-754e547b723f"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    BIJSTERHUIZEN(
        subdomain = "bijsterhuizen",
        subdomainComponent = { Bijsterhuizen() },
        label = LocalizedText(nl = "Bijsterhuizen"),
        imageUrl = "/lux/images/model_thumbnails/bijsterhuizen.png",
        entryPoint = "bijsterhuizen",
        modelId = Uuid.parse("66624cc5-eb5e-447e-82bf-9b0fa1bfcf7d"),
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    OSS(
        subdomain = "oss",
        subdomainComponent = { OssRouting() },
        label = LocalizedText(nl = "Oss"),
        imageUrl = "/lux/images/model_thumbnails/oss.png",
        entryPoint = "oss",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
}
