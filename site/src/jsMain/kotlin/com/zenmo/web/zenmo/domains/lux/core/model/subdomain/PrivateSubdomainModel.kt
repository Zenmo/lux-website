package com.zenmo.web.zenmo.domains.lux.core.model.subdomain

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.PrivateTwinModel
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.subdomains.Borchwerf
import com.zenmo.web.zenmo.domains.lux.subdomains.Hessenpoort
import com.zenmo.web.zenmo.domains.lux.subdomains.KasAlsenErgiebron
import com.zenmo.web.zenmo.domains.lux.subdomains.PreZero
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.Genius


data class PrivateSubdomainModel(
    override val subdomain: String,
    override val subdomainComponent: @Composable () -> Unit,
    override val label: LocalizedText,
    override val applicationArea: LuxApplicationArea,
    override val imageUrl: String,
    override val entryPoint: String,
) : SubdomainTwinModel, PrivateTwinModel


val drechtsteden = PrivateSubdomainModel(
    subdomain = "drechtsteden",
    subdomainComponent = { DrechtstedenRouting() },
    label = LocalizedText(nl = "Drechtsteden"),
    imageUrl = "/img/drechtsteden-rivier.jpg",
    entryPoint = "drechtsteden",
    applicationArea = LuxApplicationArea.LUX_REGION
)
val genius = PrivateSubdomainModel(
    subdomain = "genius",
    subdomainComponent = { Genius() },
    label = LocalizedText(nl = "Genius"),
    imageUrl = "/lux/images/models/genius.png",
    entryPoint = "genius",
    applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
)
val hessenpoort = PrivateSubdomainModel(
    subdomain = "hessenpoort",
    subdomainComponent = { Hessenpoort() },
    label = LocalizedText(nl = "Hessenpoort"),
    imageUrl = "/lux/images/models/hessenpoort.png",
    entryPoint = "hessenpoort",
    applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
)
val kasalsenergiebron = PrivateSubdomainModel(
    subdomain = "kasalsenergiebron",
    subdomainComponent = { KasAlsenErgiebron() },
    label = LocalizedText(nl = "Kas Als Energiebron"),
    imageUrl = "/lux/images/models/kasals.png",
    entryPoint = "kasalsenergiebron",
    applicationArea = LuxApplicationArea.LUX_ENERGY_HUB
)
val prezero = PrivateSubdomainModel(
    subdomain = "prezero",
    subdomainComponent = { PreZero() },
    label = LocalizedText(nl = "PreZero"),
    imageUrl = "/lux/images/models/prezero.png",
    entryPoint = "prezero",
    applicationArea = LuxApplicationArea.LUX_COMPANY
)
val borchwerf = PrivateSubdomainModel(
    subdomain = "borchwerf",
    subdomainComponent = { Borchwerf() },
    label = LocalizedText(nl = "Borchwerf"),
    imageUrl = "/lux/images/models/borchwerf.png",
    entryPoint = "borchwerf",
    applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA
)


val privateSubdomainModels = listOf(
    drechtsteden,
    genius,
    hessenpoort,
    kasalsenergiebron,
    prezero,
    borchwerf
)