package energy.lux.frontend.domains.lux.core.model.subdomain

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.PrivateTwinModel
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenRouting
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.Genius
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.Bijsterhuizen
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.Borchwerf
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.DeWieken
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.Hessenpoort
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.KasAlsEnergiebron
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.PreZero
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.Vaanpark


enum class PrivateSubdomainModel(
    override val subdomain: String,
    override val subdomainComponent: @Composable () -> Unit,
    override val label: LocalizedText,
    override val applicationArea: LuxApplicationArea,
    override val imageUrl: String,
    override val entryPoint: String,
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
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
    ),
    HESSENPOORT(
        subdomain = "hessenpoort",
        subdomainComponent = { Hessenpoort() },
        label = LocalizedText(nl = "Hessenpoort"),
        imageUrl = "/lux/images/model_thumbnails/Hessenpoort2.jpg",
        entryPoint = "hessenpoort",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
    ),
    KAS_ALS_ENERGIEBRON(
        subdomain = "kasalsenergiebron",
        subdomainComponent = { KasAlsEnergiebron() },
        label = LocalizedText(nl = "Kas Als Energiebron"),
        imageUrl = "/lux/images/model_thumbnails/kasalsenergiebron6.jpg",
        entryPoint = "kasalsenergiebron",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
    ),
    PREZERO(
        subdomain = "prezero",
        subdomainComponent = { PreZero() },
        label = LocalizedText(nl = "PreZero"),
        imageUrl = "/lux/images/model_thumbnails/ModelThumbnailPreZero.png",
        entryPoint = "prezero",
        applicationArea = LuxApplicationArea.LUX_BUSINESS
    ),
    BORCHWERF(
        subdomain = "borchwerf",
        subdomainComponent = { Borchwerf() },
        label = LocalizedText(nl = "Borchwerf"),
        imageUrl = "/lux/images/model_thumbnails/borchwerf.png",
        entryPoint = "borchwerf",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    DE_WIEKEN(
        subdomain = "dewieken",
        subdomainComponent = { DeWieken() },
        label = LocalizedText(nl = "De Wieken"),
        imageUrl = "/lux/images/model_thumbnails/dewieken.png",
        entryPoint = "dewieken",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    VAANPARK(
        subdomain = "vaanpark",
        subdomainComponent = { Vaanpark() },
        label = LocalizedText(nl = "Vaanpark"),
        imageUrl = "/lux/images/model_thumbnails/vaanpark.png",
        entryPoint = "vaanpark",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
    BIJSTERHUIZEN(
        subdomain = "bijsterhuizen",
        subdomainComponent = { Bijsterhuizen() },
        label = LocalizedText(nl = "Bijsterhuizen"),
        imageUrl = "/lux/images/model_thumbnails/bijsterhuizen.png",
        entryPoint = "bijsterhuizen",
        applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    ),
}
