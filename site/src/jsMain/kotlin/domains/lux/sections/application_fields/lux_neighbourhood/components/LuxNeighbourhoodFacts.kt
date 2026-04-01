package energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.IconStyle
import com.varabyte.kobweb.silk.components.icons.mdi.MdiCheckCircle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.P


@Composable
fun LuxNeighbourhoodFacts() {
    LuxSectionContainer {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(clamp(32.px, 5.vw, 64.px))
                .gap(2.cssRem)
                .luxBorderRadius(LuxCornerRadius.xl)
                .border(1.px, LineStyle.Solid, Colors.LightGrey)
                .borderLeft(4.px, LineStyle.Solid, SitePalette.light.secondary)
        ) {
            HeaderText(
                enText = "Did you know?",
                nlText = "Wist je dat?",
                textColor = SitePalette.light.primary,
            )
            Column(
                modifier = Modifier.gap(0.5.cssRem)
            ) {
                FactBlock(
                    LocalizedText(
                        en = "Twelve municipalities are using LUX Neighbourhood for their analyses.",
                        nl = "Twaalf gemeenten gebruiken LUX Woonbuurt voor hun analyses."
                    )
                )

                FactBlock(
                    LocalizedText(
                        en = """
                            A direct connection with TNO’s design toolkit is on the way! Making detailed cost analysis of 
                            district heating networks possible. 
                        """.trimIndent(),
                        nl = """
                            Een directe koppeling met de ontwerptoolkit van TNO komt er aan! Dit maakt gedetailleerde 
                            kostenanalyses van stadsverwarmingsnetwerken mogelijk.
                        """.trimIndent()
                    )
                )

                FactBlock(
                    LocalizedText(
                        en = "We are also working with ESRI on integration of LUX in ArcGIS.",
                        nl = "We werken ook samen met ESRI aan de integratie van LUX in ArcGIS."
                    )
                )
            }
        }
    }
}

@Composable
private fun FactBlock(
    text: LocalizedText
) {
    Row(
        modifier = Modifier.gap(8.px),
    ) {
        MdiCheckCircle(
            modifier = Modifier.color(SitePalette.light.primary),
            style = IconStyle.OUTLINED
        )
        P(Modifier.margin(0.px).toAttrs()) {
            LangText(
                en = text.en,
                nl = text.nl,
            )
        }
    }
}
