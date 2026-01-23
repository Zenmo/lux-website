package com.zenmo.web.zenmo.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLock
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.subdomainModels
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components.EmptyResults
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components.SearchBar
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components.filterAndSearchModels
import com.zenmo.web.zenmo.domains.lux.widgets.RadioRow
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span


enum class FilterType {
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
        var query by remember { mutableStateOf("") }

        val allModels =
            (subdomainModels + com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.drechtstedenModels).map { it.toTwinModelCardItem() }
        var luxModels by remember { mutableStateOf(allModels) }
        var filterType by remember { mutableStateOf(FilterType.ALL) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(36.px),
        ) {
            HeaderText(
                enText = "Models",
                nlText = "Modellen",
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

            SearchBar(
                query = query,
                onQueryChange = { searchQuery ->
                    query = searchQuery
                    luxModels = filterAndSearchModels(
                        models = allModels,
                        query = query,
                        filterType = filterType
                    )
                }
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Span(
                    attrs = DeEmphasizedTextStyle.toModifier()
                        .textTransform(TextTransform.Uppercase)
                        .padding(bottom = 8.px)
                        .toAttrs()
                ) {
                    LangText(
                        en = "Access",
                        nl = "Toegang"
                    )
                }
                RadioRow(
                    value = filterType,
                    options = FilterType.entries.associateWith { it.name },
                    onChange = { type ->
                        filterType = type
                        luxModels = filterAndSearchModels(
                            models = allModels,
                            query = query,
                            filterType = filterType
                        )
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
        }

        if (luxModels.isNotEmpty()) {
            TwinModelsGrid(
                models = luxModels,
            )
        } else {
            EmptyResults()
        }
    }
}
