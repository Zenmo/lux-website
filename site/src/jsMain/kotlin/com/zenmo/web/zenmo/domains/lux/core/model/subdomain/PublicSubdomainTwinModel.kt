package com.zenmo.web.zenmo.domains.lux.core.model.subdomain

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.PublicTwinModel
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.*
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.amersfoort.Amersfoort
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.brabant.BrabantRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.EmpoweredRouting
import kotlin.uuid.Uuid

data class PublicSubdomainTwinModel(
    override val subdomain: String,
    override val subdomainComponent: @Composable () -> Unit,
    override val label: LocalizedText,
    override val applicationArea: LuxApplicationArea,
    override val imageUrl: String,
    override val modelId: Uuid,
) : SubdomainTwinModel, PublicTwinModel


val empowered = PublicSubdomainTwinModel(
    subdomain = "empowered",
    subdomainComponent = { EmpoweredRouting() },
    label = LocalizedText(en = "EmPowerEd", nl = "EmPowerEd"),
    imageUrl = "",
    modelId = Uuid.parse("3801076e-44db-4b42-a27f-5be2b6c82a5c"),
    applicationArea = LuxApplicationArea.LUX_REGION
)

val brabant = PublicSubdomainTwinModel(
    subdomain = "brabant",
    subdomainComponent = { BrabantRouting() },
    label = LocalizedText(en = "Brabant", nl = "Brabant"),
    imageUrl = "/lux/images/model_thumbnails/ModelThumbnailBrabant.jpg",
    modelId = Uuid.parse("973255f2-d5fb-4daa-b835-852388716ca7"),
    applicationArea = LuxApplicationArea.LUX_REGION
)

val nederland = PublicSubdomainTwinModel(
    subdomain = "nederland",
    subdomainComponent = { NederlandIndex() },
    label = LocalizedText(en = "Netherlands", nl = "Nederland"),
    imageUrl = "/lux/images/models/nederland.png",
    modelId = Uuid.parse("0853040a-824d-4341-9d50-26bf4a3deb8f"),
    applicationArea = LuxApplicationArea.LUX_REGION
)
val hilversum = PublicSubdomainTwinModel(
    subdomain = "hilversum",
    subdomainComponent = { HilversumIndex() },
    label = LocalizedText(en = "Hilversum", nl = "Hilversum"),
    imageUrl = "/lux/images/model_thumbnails/ModelThumbnailHilversum.jpg",
    modelId = Uuid.parse("00edc3d3-2942-486a-93ae-26f809872a54"),
    applicationArea = LuxApplicationArea.LUX_REGION
)
val bunderbuurten = PublicSubdomainTwinModel(
    subdomain = "bunderbuurten",
    subdomainComponent = { BunderbuurtenIndex() },
    label = LocalizedText(en = "Bunder Neighbourhoods", nl = "Bunderbuurten"),
    imageUrl = "/lux/images/model_thumbnails/ModelThumbnailBunderbuurtenVeghel.jpg",
    modelId = Uuid.parse("da90dd57-a9fb-47b2-9496-345255fda37a"),
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)
val loenen = PublicSubdomainTwinModel(
    subdomain = "loenen",
    subdomainComponent = { LoenenIndex() },
    label = LocalizedText(en = "Loenen", nl = "Loenen"),
    imageUrl = "/lux/images/model_thumbnails/ModelThumbnailLoenen.jpg",
    modelId = Uuid.parse("ba998ba3-05dc-45f6-ac6d-78279765375d"),
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)
val rotterdamDenHaag = PublicSubdomainTwinModel(
    subdomain = "rotterdamdenhaag",
    subdomainComponent = { RotterdamDenHaagIndex() },
    label = LocalizedText(en = "Rotterdam The Hague", nl = "Rotterdam Den Haag"),
    imageUrl = "/lux/images/models/rotterdam.png",
    modelId = Uuid.parse("92952425-a78a-4e69-a896-6ccea66d4ce6"),
    applicationArea = LuxApplicationArea.LUX_REGION
)
val vruchtenbuurt = PublicSubdomainTwinModel(
    subdomain = "vruchtenbuurt",
    subdomainComponent = { VruchtenbuurtIndex() },
    label = LocalizedText(en = "Vruchtenbuurt", nl = "Vruchtenbuurt"),
    imageUrl = "/lux/images/model_thumbnails/ModelThumbnailVruchtenbuurt.jpg",
    modelId = Uuid.parse("cca6eb2b-fb91-4825-bee2-d5e12d0a3880"),
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)
val cognizant = PublicSubdomainTwinModel(
    subdomain = "cognizant",
    subdomainComponent = { Cognizant() },
    label = LocalizedText(en = "Cognizant", nl = "Cognizant"),
    imageUrl = "/lux/images/model_thumbnails/ModelThumbnailCognizant.png",
    modelId = Uuid.parse("7cfc3e4a-608c-4e2c-a834-4d290174ee9e"),
    applicationArea = LuxApplicationArea.LUX_COMPANY
)
val kronenberg = PublicSubdomainTwinModel(
    subdomain = "kronenberg",
    subdomainComponent = { KronenbergIndex() },
    label = LocalizedText(en = "Kronenberg", nl = "EnergieKronenberg"),
    imageUrl = "/lux/images/kronenberg/Skyline-Kronenberg-Jan-Janssen-square.jpg",
    modelId = Uuid.parse("c8d7bd27-5b4a-43b1-bbcb-5ead4fe98696"),
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)
val amersfoort = PublicSubdomainTwinModel(
    subdomain = "amersfoort",
    subdomainComponent = { Amersfoort() },
    label = LocalizedText(en = "Amersfoort", nl = "Amersfoort"),
    imageUrl = "/lux/images/models/amersfoort.jpg",
    modelId = Uuid.parse("88c97843-1272-4557-beec-09412ef2c32b"),
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)
val veenendaal = PublicSubdomainTwinModel(
    subdomain = "veenendaal",
    subdomainComponent = { Veenendaal() },
    label = LocalizedText(en = "Veenendaal", nl = "Veenendaal"),
    imageUrl = "/lux/images/models/veenendaal.jpg",
    modelId = Uuid.parse("0bec54a4-af5d-47fd-8af1-dfb3af0457f6"),
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)

val publicSubdomainModels = listOf(
    empowered,
    brabant,
    nederland,
    hilversum,
    bunderbuurten,
    loenen,
    rotterdamDenHaag,
    vruchtenbuurt,
    cognizant,
    kronenberg,
    amersfoort,
    veenendaal,
)
