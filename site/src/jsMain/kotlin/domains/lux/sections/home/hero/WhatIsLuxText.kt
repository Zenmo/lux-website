package energy.lux.frontend.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLanguage
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.core.model.subdomain.demoEnergyHubModel
import energy.lux.frontend.domains.lux.core.model.subdomain.demoNeighbourhoodModel
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
fun WhatIsLuxText() {
    Column(
        Modifier
            .gap(1.cssRem)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.px, 8.px)
                .gap(8.px)
                .backgroundColor(SitePalette.light.primary.lightened(0.85f))
                .color(SitePalette.light.primary)
                .luxBorderRadius()
        ) {
            MdiLanguage()
            LangText(
                en = "Local power, global impact!",
                nl = "Lokale energie, wereldwijde impact!",
            )
        }

        HeaderText(
            enText = "LUX Energy Twin",
            nlText = "LUX Energy Twin",
            textColor = SitePalette.light.primary,
        )
        P {
            LangText(
                en = """
                    The open source LUX tooling supports local communities or business areas with interactive 
                    digital twins. LUX lights the way to an energy system that is clean and affordable and puts the 
                    power in the hands of users.
                """.trimIndent(),
                nl = """
                    De open-source LUX-tool ondersteunt lokale gemeenschappen of bedrijventerreinen met 
                    interactieve digital twins. LUX wijst de weg naar een energiesysteem dat schoon en betaalbaar 
                    is en de gebruikers de regie geeft.
                """.trimIndent()
            )
        }
        HeroCTAButtons()
    }
}

@Composable
private fun HeroCTAButtons() {
    val ctx = rememberPageContext()
    Row(
        Modifier.gap(1.cssRem),
        horizontalArrangement = Arrangement.Center
    ) {
        PrimaryButton(
            enText = "Demo Energy Hub",
            nlText = "Demo Energy Hub",
            onClick = {
                ctx.router.navigateTo(demoEnergyHubModel.url)
            },
            modifier = Modifier
                .backgroundColor(SitePalette.light.secondary)
                .color(Colors.Black),
        )

        PrimaryButton(
            enText = "Demo Neighbourhood",
            nlText = "Demo Woonwijk",
            onClick = {
                ctx.router.navigateTo(demoNeighbourhoodModel.url)
            },
            modifier = Modifier
                .backgroundColor(SitePalette.light.overlay)
                .color(Colors.Black),
        )
    }
}