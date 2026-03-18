package domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDeviceHub
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.sections.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun LuxRegionHero() {
    LuxSectionContainer {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            TextContent()
            Box(Modifier.fillMaxWidth()) {
                ImageContent(
                    imageUrl = "/lux/images/lux_region_hero.png",
                    alt = "nature",
                )
            }
        }
    }
}


@Composable
private fun TextContent() {
    Column(
        Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_REGION.areaTitle.en,
            nlText = LuxApplicationArea.LUX_REGION.areaTitle.nl,
        )
        Div {
            P(
                Modifier.margin(0.px)
                    .toAttrs()
            ) {
                LangText(
                    en = """
                        The LUX regional model helps municipalities, RES regions, and provinces gain insight into their 
                        local energy system. We do this in an interactive way, loading plans and developing scenarios 
                        together with policymakers. This leads to robust and widely supported scenarios that not only 
                        paint a clear picture but also increase understanding and bring the preconditions into focus.
                    """.trimIndent(),
                    nl = """
                        Het LUX regio model helpt gemeentes, RES regio’s en provincies om inzicht te krijgen in hun lokale 
                        energiesysteem. Dit doen we op een interactieve manier, waarmee we samen met beleidsmakers plannen
                        inladen en scenario’s uitwerken. Zo komen we tot robuste en breed gedragen scenario’s, die niet 
                        alleen een duidelijk beeld schetsen, maar ook het begrip verhogen en de randvoorwaarden in beeld
                        bregen.
                    """.trimIndent()
                )
            }
            P {
                LangText(
                    en = """
                        The energy twin provides an integrated view of the energy system. In the twin, charging 
                        visions, heat transition visions, and large-scale generation and storage can be combined, 
                        among other things. We combine this with detailed information on energy consumption for 
                        households, businesses and mobility into a comprehensive energy vision.
                    """.trimIndent(),
                    nl = """
                        De energy twin zorgt voor een integrale blik op het energiesysteem. In de twin kunnen o.a. de 
                        laadvisies, transitie visies warmte, grootschalige opwek en oplsag bij elkaar worden gevoegd. 
                        Wij voegen hier gedetailleerde informatie over huishoudens, bedrijven, en mobiliteit aan toe 
                        geven zo een compleet energiesysteembeeld.
                    """.trimIndent()
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(24.px)
                .gap(16.px)
                .background(SitePalette.light.primary.lightened(0.85f))
                .luxBorderRadius(LuxCornerRadius.lg)
                .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
        ) {
            MdiDeviceHub(Modifier.color(SitePalette.light.primary))
            P(
                Modifier.margin(0.px)
                    .toAttrs()
            ) {
                LangText(
                    en = """
                        Within a couple of hours we can provide you with an initial model, which can collaboratively be 
                        expanded with more detailed data and future energy system visions.
                    """.trimIndent(),
                    nl = """
                        Het model kan binnen een paar drukken op de knop worden klaargezet voor een eerste inzicht! Daarna 
                        werken we in een vervolgtraject de meest relevante scenario’s uit en voegen we custom data van de 
                        gemeente of regio toe.
                    """.trimIndent()
                )
            }
        }
    }
}
