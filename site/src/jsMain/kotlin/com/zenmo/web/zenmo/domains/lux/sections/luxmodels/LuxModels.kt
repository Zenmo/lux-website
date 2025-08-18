package com.zenmo.web.zenmo.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.components.model.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
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
                .then(TopDividerLineStyle.toModifier())
                .background(SitePalette.light.overlay)
                .position(Position.Relative)
                .gap(5.cssRem),
        variant = LuxSectionContainerStyleVariant
    ) {
        var luxModels by remember { mutableStateOf(SubdomainModel.allModels) }
        var filterType by remember { mutableStateOf(FilterType.ALL) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HeaderText(
                enText = "Models",
                nlText = "Models",
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(0.px)
                    .textAlign(TextAlign.Center)
            )
            P(
                Modifier.textAlign(TextAlign.Center).toAttrs(),
            ) {
                LangText(
                    en = "Find out more about our models.",
                    nl = "Lees meer over onze modellen."
                )
                Br { }
                LangText(
                    en = "This includes both our public and private models.",
                    nl = "Dit omvat zowel onze openbare als privémodellen."
                )
            }
            FilterChipRow(
                onClick = { type ->
                    filterType = type
                    luxModels = when (type) {
                        FilterType.ALL -> SubdomainModel.allModels
                        FilterType.PUBLIC -> SubdomainModel.publicSubdomains
                        FilterType.PRIVATE -> SubdomainModel.privateSubdomains
                    }
                },
                filterType = filterType
            )
        }

        TwinModelsGrid(
            models = luxModels,
            path = ""
        )
    }
}


@Composable
private fun FilterChipRow(
    onClick: (FilterType) -> Unit,
    filterType: FilterType = FilterType.ALL,
) {
    SimpleGrid(numColumns = numColumns(base = FilterType.entries.size), modifier = Modifier.gap(0.5.cssRem)) {
        FilterType.entries.forEach { type ->
            val isSelected = type == filterType
            Div(
                Modifier
                    .display(DisplayStyle.Flex)
                    .padding(0.25.cssRem, 0.5.cssRem)
                    .textAlign(TextAlign.Center)
                    .border(1.px, LineStyle.Solid, Colors.LightGrey)
                    .color(SitePalette.light.onBackground)
                    .thenIf(
                        isSelected,
                        Modifier
                            .border(1.px, LineStyle.None, Colors.LightGrey)
                            .background(SitePalette.light.primary)
                            .color(SitePalette.light.onPrimary)
                    )
                    .borderRadius(12.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        onClick(type)
                    }
                    .justifyContent(JustifyContent.Center)
                    .toAttrs()
            ) {
                when (type) {
                    FilterType.ALL -> LangText(en = "All", nl = "Alle")
                    FilterType.PUBLIC -> LangText(en = "Public", nl = "Openbaar")
                    FilterType.PRIVATE -> LangText(en = "Private", nl = "Privé")
                }
            }
        }
    }
}