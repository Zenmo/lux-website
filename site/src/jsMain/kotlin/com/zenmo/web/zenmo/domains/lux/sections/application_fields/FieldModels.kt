package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowForward
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.luxModelsMenuItem
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P


@Composable
fun FieldModels(
    featuredModels: List<TwinModelCardItem>,
    showMoreModelsLink: Boolean,
) {
    LuxSectionContainer(
        modifier =
            Modifier
                .then(TopDividerLineStyle.toModifier())
                .background(SitePalette.light.overlay),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HeaderText(
                enText = "Example Models",
                nlText = "Voorbeeldmodellen",
            )
            if (showMoreModelsLink) {
                P {
                    LangText(
                        en = "Explore more real-world examples and detailed simulations.",
                        nl = "Ontdek meer praktijkvoorbeelden en gedetailleerde simulaties."
                    )
                }
                BrowseAllModelsLink()
            }
        }
        TwinModelsGrid(
            models = featuredModels,
        )
    }
}

@Composable
private fun BrowseAllModelsLink() {
    Link(
        path = luxModelsMenuItem.route.path,
        variant = UncoloredLinkVariant.then(UndecoratedLinkVariant),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .verticalLinearBackground()
                .padding(8.px, 16.px)
                .gap(8.px)
                .color(Colors.White)
                .luxBorderRadius()
        ) {
            LangText(
                en = "Browse all models",
                nl = "Bekijk alle modellen"
            )
            MdiArrowForward()
        }
    }
}