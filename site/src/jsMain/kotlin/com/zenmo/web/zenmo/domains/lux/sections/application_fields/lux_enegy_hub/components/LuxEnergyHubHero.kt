package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricBolt
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun LuxEnergyHubHero() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart)
    ) {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            HeroTextContent()
            Box(Modifier.fillMaxWidth()) {
                ImageContent(
                    imageUrl = "/lux/images/nature_img.jpg",
                    alt = "nature",
                )
            }
        }
    }
}

@Composable
private fun HeroTextContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.5.cssRem)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_ENERGY_HUB.label.en,
            nlText = LuxApplicationArea.LUX_ENERGY_HUB.label.nl,
        )
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangBlock(
                en = {
                    Text(
                        """
                        A deep dive into grid congestion, the potential for an energy hubs, and the energy consumption, 
                        production, and storage of your business parc or industrial area. LUX Energy Hub will visualize 
                        all energy data and grid limitations and lets you explore scenario’s with (more) batteries, 
                        solar panels, companies, transformers, etc .
                    """.trimIndent()
                    )
                    Br { }
                    Br { }
                    Text(
                        """
                        It allows our businesses to thrive and find applicable solutions to grid congestion issues. It 
                        also allows municipalities to better assist the businesses and realize economic growth locally. 
                    """.trimIndent()
                    )
                },
                nl = {
                    Text(
                        """
                        Een deepdive in netcongestie, in lokale samenwerking, en in alle energiedynamieken van uw 
                        bedrijventerrein of industriegebied. LUX Energy Hub visualiseert energiedata en netbeperkingen 
                        en stelt u in staat om scenario’s te verkennen met o.a. batterijen, zonnepanelen, nieuwe 
                        bedrijven, nieuwe netaansluitingen en nieuwe energie infrastructuur.
                    """.trimIndent()
                    )
                    Br { }
                    Br { }
                    Text(
                        """
                        Het helpt bedrijven om uit te breiden en oplossingen te vinden voor netcongestie. Daarnaast 
                        ondersteunt het gemeenten bij het beter faciliteren van ondernemers en het realiseren van 
                        lokale economische groei.
                    """.trimIndent()
                    )
                }
            )
        }
        NederlandCodeRed()
    }
}

@Composable
private fun NederlandCodeRed() {
    val luxRed = LuxSpecificColorHues().luxRed
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(24.px)
            .gap(16.px)
            .background(luxRed.lightened(0.85f))
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, luxRed)
    ) {
        MdiElectricBolt(Modifier.color(luxRed))
        P(
            Modifier
                .margin(0.px)
                .toAttrs()
        ) {
            LangBlock(
                en = {
                    Text("The fast majority of Dutch business parks are currently in a congested area ")
                    InlineLink(
                        destinationUrl = "https://data.partnersinenergie.nl/capaciteitskaart/rnb/afname",
                        enLinkText = "(Capacity Map | Netbeheer Nederland)",
                        nlLinkText = "(Capaciteitskaart | Netbeheer Nederland)"
                    )
                    Text(". ")
                    Text(
                        """
                         As a result, cannot realize growth and their sustainability plans, in the worst cases 
                         businesses are moving abroad or even go bankrupt.
                    """.trimIndent()
                    )
                },
                nl = {
                    Text("Voor de meeste bedrijventerreinen in Nederland is reeds congestie afgeroepen ")
                    InlineLink(
                        destinationUrl = "https://data.partnersinenergie.nl/capaciteitskaart/rnb/afname",
                        enLinkText = "(Capaciteitskaart | Netbeheer Nederland)",
                        nlLinkText = "(Capaciteitskaart | Netbeheer Nederland)"
                    )
                    Text(". ")
                    Text(
                        """
                          Het resultaat: bedrijven kunnen niet meer uitbreiden, ze kunnen niet elektrificeren of 
                          verduurzamen, en in de de ergste gevallen moeten ze verhuizen naar het buitenland of staken 
                          ze de activiteiten.
                    """.trimIndent()
                    )
                }
            )
        }
    }
}