package com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.model

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.icons.mdi.MdiApartment
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHouse
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLan
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.home.featureIcon
import org.jetbrains.compose.web.css.px

data class ApplicationAreaItem(
    val luxApplicationArea: LuxApplicationArea,
    val description: LocalizedText,
    val icon: @Composable () -> Unit,
) {
    companion object {
        val luxApplicationAreas = listOf(
            ApplicationAreaItem(
                luxApplicationArea = LuxApplicationArea.LUX_COMPANY,
                description = LocalizedText(
                    en = "More and more companies are discovering that they can grow their business with batteries, even if the grid operator does not make extra capacity available.",
                    nl = "Steeds meer bedrijven ontdekken dat ze hun bedrijf kunnen laten groeien met batterijen, zelfs als de netbeheerder geen extra capaciteit beschikbaar stelt."
                ),
                icon = { MdiApartment(Modifier.featureIcon(size = 32.px)) }
            ),
            ApplicationAreaItem(
                luxApplicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
                description = LocalizedText(
                    en = "Business parks facing grid congestion can do much more with existing capacity. Show how companies can achieve more together through common batteries and group contracts.",
                    nl = "Bedrijventerreinen die te maken hebben met netcongestie kunnen veel meer doen met de bestaande capaciteit. Laat zien hoe bedrijven samen meer kunnen bereiken via gemeenschappelijke batterijen en groepscontracten."
                ),
                icon = { MdiLan(Modifier.featureIcon(size = 32.px)) }
            ),
            ApplicationAreaItem(
                luxApplicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA,
                description = LocalizedText(
                    en = "How do we get residential areas off gas while reducing energy costs? Automated solutions for dealing with grid congestion in neighborhoods.",
                    nl = "Hoe krijgen we woonwijken van het gas af terwijl we de energiekosten verlagen? Geautomatiseerde oplossingen voor het omgaan met netcongestie in wijken."
                ),
                icon = { MdiHouse(Modifier.featureIcon(size = 32.px)) }
            ),
            ApplicationAreaItem(
                luxApplicationArea = LuxApplicationArea.LUX_REGION,
                description = LocalizedText(
                    en = "The ideal tool to support provinces and municipalities in realizing energy hubs with dynamic simulation and scenario planning.",
                    nl = "Het ideale hulpmiddel om provincies en gemeenten te ondersteunen bij het realiseren van energiehubs met dynamische simulatie en scenarioplanning."
                ),
                icon = { MdiBolt(Modifier.featureIcon(size = 32.px)) }
            ),
        )
    }
}