package com.zenmo.web.zenmo.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.subdomainModels
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components.*
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.drechtstedenModels
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


enum class FilterType {
    ALL,
    PUBLIC,
    PRIVATE
}


@Composable
fun LuxModels() {
    LuxSectionContainer(
        modifier =
            Modifier
                .background(SitePalette.light.overlay)
    ) {
        val ctx = rememberPageContext()
        val areaParam = ctx.route.queryParams["area"]
        var query by remember { mutableStateOf("") }
        var selectedAreaOptions by remember {
            mutableStateOf(
                areaParam
                    ?.let { runCatching { LuxApplicationArea.valueOf(it) }.getOrNull() }
                    ?.let { setOf(it) }
                    ?: emptySet()
            )
        }
        val allModels = (subdomainModels + drechtstedenModels)
            .map { it.toTwinModelCardItem() }
        var filterType by remember { mutableStateOf(FilterType.ALL) }

        val luxModels = remember(query, filterType, selectedAreaOptions) {
            filterAndSearchModels(
                models = allModels,
                query = query,
                filterType = filterType,
                areas = selectedAreaOptions
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(36.px),
        ) {
            HeaderText(
                enText = "Models",
                nlText = "Modellen",
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
                onQueryChange = { query = it }
            )

            Div(
                ResponsiveFlexStyle.toModifier()
                    .gap(0.5.cssRem)
                    .toAttrs()
            ) {
                ModelAccessFilter(
                    filterType = filterType,
                    onFilterChange = { filterType = it }
                )
                ModelAreaFilter(
                    selectedOptions = selectedAreaOptions,
                    onSelectionChange = { selectedAreaOptions = it }
                )
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