package energy.lux.frontend.domains.lux.sections.home

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
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.theme.SitePalette
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
                    en = """
                        LUX is applicable at the building, neighborhood, municipality, and regional levels, and can 
                        include all energy carriers (such as electricity, gas, hydrogen, and heat).
                    """.trimIndent(),
                    nl = """
                        LUX is toepasbaar op pand, buurt, gemeente en regio-niveau, en kan alle energiedragers (zoals 
                        elektra, gas, waterstof en warmte) meenemen.
                    """.trimIndent()
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
                    en = """
                        LUX loads energy and GIS data from your system to then explore various what-if scenarios itself.
                    """.trimIndent(),
                    nl = """
                        LUX laadt energie- en GIS-data van jou systeem in om vervolgens zelf verschillende wat-als 
                        scenario's te verkennen
                    """.trimIndent()
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
                    en = """
                        LUX visually and dynamically simulates the energy system, thereby guiding your discussion 
                        regarding decision-making.
                    """.trimIndent(),
                    nl = """
                        LUX speelt het energiesysteem visueel en dynamisch na, daarmee begeleidt het jou discussie 
                        rondom besluitvorming.
                    """.trimIndent()
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
                        modifier = Modifier.size(64.px)
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
                            .color(SitePalette.light.secondary)
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