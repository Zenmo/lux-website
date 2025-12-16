package com.zenmo.web.zenmo.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.RadioRow
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P


private enum class FilterType {
    ALL,
    PUBLIC,
    PRIVATE
}

@Composable
fun LuxModels() {
    SectionContainer(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier =
            Modifier
                .background(SitePalette.light.overlay)
                .position(Position.Relative)
                .gap(5.cssRem),
        variant = LuxSectionContainerStyleVariant
    ) {
        var luxModels by remember { mutableStateOf(SubdomainModel.allModels) }
        var filterType by remember { mutableStateOf(FilterType.ALL) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(36.px),
        ) {
            HeaderText(
                enText = "Example Models",
                nlText = "Voorbeeldmodellen",
                modifier = Modifier
                    .margin(0.px)
            )
            P(
                Modifier
                    .margin(0.px)
                    .toAttrs()
            ) {
                LangText(
                    en = "Explore our collection of energy models for different regions and applications.",
                    nl = "Ontdek onze collectie energiemodellen voor verschillende regio's en toepassingen."
                )
            }

            RadioRow(
                value = filterType,
                options = FilterType.entries.associateWith { it.name },
                onChange = { type ->
                    filterType = type
                    luxModels = when (type) {
                        FilterType.ALL -> SubdomainModel.allModels
                        FilterType.PUBLIC -> SubdomainModel.publicSubdomains
                        FilterType.PRIVATE -> SubdomainModel.privateSubdomains
                    }
                }
            ) { option, _ ->
                when (option) {
                    FilterType.ALL -> LangText(en = "All", nl = "Alle")
                    FilterType.PUBLIC -> LangText(en = "Public", nl = "Openbaar")
                    FilterType.PRIVATE -> Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.px)
                    ) {
                        MdiLock(Modifier.fontSize(16.px))
                        LangText(en = "Private", nl = "Privé")
                    }
                }
            }
        }

        TwinModelsGrid(
            models = luxModels,
            path = ""
        )
    }
}
