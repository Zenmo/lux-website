package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.OverflowWrap
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDiversity2
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLightbulb
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

data class LuxFlipCardItem(
    val title: LocalizedText,
    val description: LocalizedText,
    // need a way to override font-size of mdi icons,
    // cssRule( .material-icons) seems not to work
    val icon: @Composable (Modifier) -> Unit
) {
    companion object {
        val items = listOf(
            LuxFlipCardItem(
                title = LocalizedText(
                    en = "Integral energy simulations",
                    nl = "Integrale energiesimulaties"
                ),
                description = LocalizedText(
                    en = "LUX is multi-level (from company to country) and multi-commodity (from electricity to heat and hydrogen).",
                    nl = "LUX kent meerdere niveaus (van bedrijf naar land) en meerdere soorten energie (van elektriciteit naar warmte en waterstof)"
                ),
                icon = {
                    MdiLightbulb(it)
                }
            ),
            LuxFlipCardItem(
                title = LocalizedText(
                    en = "Interactive digital twin",
                    nl = "Interactieve digitale tweeling"
                ),
                description = LocalizedText(
                    en = "LUX loads all GIS and energy data of your area and lets you run a variety of what-if simulations.",
                    nl = "LUX laadt alle GIS- en energiedata van jouw gebied en laat je verschillende wat-als scenario’s uitproberen."
                ),
                icon = {
                    MdiElectricBolt(it)
                }
            ),
            LuxFlipCardItem(
                title = LocalizedText(
                    en = "Empowering decision support",
                    nl = "Besluitvorming ondersteunen"
                ),
                description = LocalizedText(
                    en = "LUX makes the hard calculations within seconds, so your discussions can focus on the hard decisions.",
                    nl = "LUX doet het rekenwerk in een paar seconden, zodat jouw discussie zich kan richten op de besluitvorming."
                ),
                icon = {
                    MdiDiversity2(it)
                }
            ),
            LuxFlipCardItem(
                title = LocalizedText(
                    en = "Open source",
                    nl = "Open source"
                ),
                description = LocalizedText(
                    en = "LUX source code can be directly downloaded from the LUX Github repository.",
                    nl = "De LUX broncode is vrij te downloaden van de LUX Github repository."
                ),
                icon = {
                    Image(
                        src = "/lux/logos/github-mark.svg",
                        alt = "GitHub Logo",
                        modifier = Modifier.Companion.size(64.px)
                    )
                }
            )
        )
    }
}

@Composable
fun FlipCard(
    item: LuxFlipCardItem
) {
    Div(
        FlipCardStyle.toAttrs()
    ) {
        Div(
            FlipCardInnerStyle
                .toModifier()
                .classNames("flip-card-inner")
                .toAttrs()
        ) {
            Column(
                modifier = FlipCardFrontStyle.toModifier(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    Modifier.height(70.px).fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    item.icon(
                        Modifier
                            .color(SitePalette.Companion.light.secondary)
                            .fontSize(64.px)
                    )
                }
                P(
                    Modifier
                        .margin(0.cssRem)
                        .width(90.percent)
                        .fontSize(FontSize.Larger)
                        .overflowWrap(OverflowWrap.BreakWord)
                        .toAttrs()
                ) {
                    LangText(
                        en = item.title.en,
                        nl = item.title.nl
                    )
                }
            }

            Box(
                FlipCardBackStyle.toModifier(),
                contentAlignment = Alignment.Center
            ) {
                P(
                    Modifier
                        .width(90.percent)
                        .fontSize(FontSize.Large).toAttrs()
                ) {
                    LangText(
                        en = item.description.en,
                        nl = item.description.nl
                    )
                }
            }
        }
    }
}


@Composable
fun LuxFlipCards() {
    Div(
        CardGridStyle.toModifier()
            .toAttrs()
    ) {
        LuxFlipCardItem.items.forEach { item ->
            FlipCard(item)
        }
    }
}