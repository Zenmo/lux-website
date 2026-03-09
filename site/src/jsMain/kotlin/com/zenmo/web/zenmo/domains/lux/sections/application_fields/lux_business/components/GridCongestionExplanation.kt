package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBattery0Bar
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiSolarPower
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.BatteryRotationStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span


@Composable
fun GridCongestionExplanation() {
    LuxSectionContainer(
        Modifier
            .background(LuxSpecificColorHues().luxBlackRussian)
            .color(Colors.White)
            .textAlign(TextAlign.Center)
            .gap(1.cssRem),
    ) {
        HeaderText(
            enText = "There are other ways!",
            nlText = "Het kan ook anders!"
        )
        Column(
            modifier = Modifier
                .width(clamp(350.px, 60.vw, 700.px))
                .gap(1.cssRem),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            P {
                LangText(
                    en = """
                        For example, a business can grow without increasing its grid connection by installing a battery 
                        or solar panels; they can also try to optimize their consumption profile over the day. But is 
                        this really going to take care of your problem? What exactly is the impact of this on your 
                        energy consumption? 
                    """.trimIndent(),
                    nl = """
                        Zo kan een bedrijf bijvoorbeeld groeien zonder zijn netaansluiting te verzwaren door een 
                        batterij te plaatsen, of zonnepanelen; vaak is er ook de mogelijkheid om het consumptieprofiel 
                        te optimaliseren. Maar is jouw bedrijf hiermee echt uit de problemen? Wat is nu precies het 
                        effect hiervan op je energiegebruik? 
                    """.trimIndent()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .gap(12.px),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconTextItem(
                    text = LocalizedText(
                        en = "Battery Storage",
                        nl = "Batterijopslag"
                    ),
                    icon = { MdiBattery0Bar(BatteryRotationStyle.toModifier()) },
                )

                IconTextItem(
                    text = LocalizedText(
                        en = "Solar Panels",
                        nl = "Zonnepanelen"
                    ),
                    icon = { MdiSolarPower() },
                )

                IconTextItem(
                    text = LocalizedText(
                        en = "Smart Optimization",
                        nl = "Slimme Optimalisatie"
                    ),
                    icon = { MdiElectricBolt() },
                )
            }
        }
    }
}

val IconTextItemStyle = CssStyle.base {
    Modifier
        .fillMaxSize()
        .padding(24.px, 12.px)
        .gap(8.px)
        .background(Colors.White.copyf(alpha = 0.1f))
        .luxBorderRadius()
}

@Composable
private fun IconTextItem(
    text: LocalizedText,
    icon: @Composable () -> Unit,
) {
    Column(
        IconTextItemStyle.toModifier(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Span(
            Modifier
                .color(SitePalette.light.secondary)
                .toAttrs(),
        ) {
            icon()
        }
        LangText(
            en = text.en,
            nl = text.nl,
        )
    }
}