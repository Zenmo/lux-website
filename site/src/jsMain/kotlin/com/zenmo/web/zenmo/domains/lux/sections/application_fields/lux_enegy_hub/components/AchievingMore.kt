package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P


@Composable
fun AchievingMore() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderText(
            enText = "Achieving more together",
            nlText = "Samen meer bereiken",
        )
        P {
            LangText(
                en = "By showing how companies can achieve more together than alone.",
                nl = "Bijvoorbeeld door te laten zien hoe bedrijven samen meer kunnen bereiken dan alleen."
            )
            B {
                LangText(
                    en = " Think:",
                    nl = " Denk aan:",
                )
            }
        }
    }
    EnergyCollaborationGrid()
}


@Composable
private fun EnergyCollaborationGrid() {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 4, xl = 4),
        modifier = Modifier.gap(1.5.cssRem)
    ) {
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Shared Battery",
                nl = "Gedeelde Batterij"
            ),
            description = LocalizedText(
                en = "Shared storage capacity for peak buffering",
                nl = "Gedeelde opslagcapaciteit voor piekbuffering"
            ),
            titleColor = SitePalette.light.primary
        )
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Group Contract (GTO)",
                nl = "Groepscontract (GTO)"
            ),
            description = LocalizedText(
                en = "Collective energy purchasing power",
                nl = "Collectieve inkoopkracht voor energie"
            ),
            titleColor = SitePalette.light.secondary
        )
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Direct Energy Connection",
                nl = "Directe Energieverbinding"
            ),
            description = LocalizedText(
                en = "Galvanically isolated cable between companies",
                nl = "Galvanisch geïsoleerde kabel tussen bedrijven"
            ),
            titleColor = SitePalette.light.primary
        )
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Heat Network",
                nl = "Warmtenet"
            ),
            description = LocalizedText(
                en = "Efficient distribution of residual heat",
                nl = "Efficiënte distributie van restwarmte"
            ),
            titleColor = SitePalette.light.secondary
        )
    }
}


@Composable
private fun EnergyCollaborationCard(
    title: LocalizedText,
    description: LocalizedText,
    titleColor: CSSColorValue
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(24.px)
            .gap(12.px)
            .background(Colors.White)
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, titleColor)
            .then(HoverBoxShadowStyle.toModifier())
    ) {
        H3(
            Modifier
                .color(titleColor)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            LangText(
                en = title.en,
                nl = title.nl
            )
        }
        P {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }
    }
}