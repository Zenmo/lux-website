package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.columnGap
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toAttrs
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P

@Composable
fun GeniusTextGrid() {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier.columnGap(3.cssRem).rowGap(2.cssRem).fillMaxWidth()
    ) {
        TextParagraph(
            enTitleText = "Managing energy flows",
            nlTitleText = "Beheer van energiestromen",
            content = {
                LangText(
                    en = """
                        This collaborative project comprises the installation of a large scale, 3.4 MWh battery, 
                        which is used to avoid peaks in the campus electricity grid. This battery, along with all 
                        of the campus’ energy assets like solar panels, heating systems and residential towers, 
                        will be connected through an innovative, intelligent energy management system.
                    """.trimIndent(),
                    nl = """
                        Dit samenwerkingsproject omvat de installatie van een grootschalige batterij van 3,4 MWh, 
                        die wordt gebruikt om pieken in het elektriciteitsnet van de campus te voorkomen. Deze 
                        batterij, samen met alle energie-assets van de campus zoals zonnepanelen, verwarmingssystemen 
                        en woongebouwen, zal worden verbonden via een innovatief, intelligent energiebeheersysteem.
                    """.trimIndent()
                )
                Br { }
                Br { }
                LangText(
                    en = """
                        This energy management software platform will effectively be the beating heart of the 
                        innovation project, enabling smart use and control of assets like batteries, charging stations 
                        and solar panels. To provide insights into the energy consumption of buildings, smart metering 
                        is installed. Based on these real-time monitoring data combined with historic data and a 
                        predictive model, the software platform optimizes energy flows within the campus network with 
                        the aim to decrease the burden on the city’s electricity grid.
                    """.trimIndent(),
                    nl = """
                        Dit energiebeheersoftwareplatform zal in feite het kloppende hart van het innovatieproject zijn, 
                        waardoor slim gebruik en controle van assets zoals batterijen, laadstations en zonnepanelen 
                        mogelijk wordt. Om inzicht te krijgen in het energieverbruik van gebouwen, wordt slimme 
                        metering geïnstalleerd. Op basis van deze realtime monitoringsgegevens in combinatie met 
                        historische gegevens en een voorspellend model, optimaliseert het softwareplatform de 
                        energiestromen binnen het campusnetwerk met als doel de belasting van het elektriciteitsnet van 
                        de stad te verminderen.
                    """.trimIndent()
                )
            },
        )

        TextParagraph(
            enTitleText = "Testing ground",
            nlTitleText = "Testomgeving",
            content = {
                LangText(
                    en = """
                        An important feature of the project is the testing ground it provides: companies can experiment 
                        with their innovative energy technologies and demonstrate them in a real life environment. 
                        Examples are the heat storage unit that will be provided by RIFT, and the battery setup 
                        delivered by Fudura. Such a testing ground can help bring innovative solutions for the energy 
                        transition to market faster.
                    """.trimIndent(),
                    nl = """
                        Een belangrijk kenmerk van het project is de testomgeving die het biedt: bedrijven kunnen 
                        experimenteren met hun innovatieve energietechnologieën en deze demonstreren in een echte 
                        omgeving. Voorbeelden zijn de warmteopslagunit die door RIFT zal worden geleverd en de 
                        batterijopstelling die door Fudura wordt geleverd. Zo'n testomgeving kan helpen om innovatieve 
                        oplossingen voor de energietransitie sneller op de markt te brengen.
                    """.trimIndent()
                )
                Br {}
                Br {}
                LangText(
                    en = """
                        Once the initially closed-loop system will be fully functional, it will be opened up to also 
                        communicate with neighboring organizations in an attempt to achieve a local energy hub that 
                        helps balance the local grid load.
                    """.trimIndent(),
                    nl = """
                        Zodra het aanvankelijk gesloten systeem volledig operationeel is, zal het worden geopend om ook 
                        te communiceren met naburige organisaties in een poging om een lokaal energiecentrum te 
                        bereiken dat helpt bij het balanceren van de lokale netbelasting.
                    """.trimIndent()
                )
            },
        )

        TextParagraph(
            enTitleText = "Strengthening expertise",
            nlTitleText = "Versterking van expertise",
            content = {
                LangText(
                    en = """
                        The GENIUS-project brings together the expertise of TU/e’s Energy research community,  and Real 
                        Estate with several companies including start-ups and governmental organizations in a joint 
                        effort to align the energy usage of all different energy producers and consumers active on 
                        campus, ranging from research groups, maintenance companies, and housing associations to
                        electricity suppliers.
                    """.trimIndent(),
                    nl = """
                        Het GENIUS-project brengt de expertise van de TU/e's Energy-onderzoekscommunity en Real Estate 
                        samen met verschillende bedrijven, waaronder start-ups en overheidsorganisaties, in een 
                        gezamenlijke inspanning om het energieverbruik van alle verschillende energieproducenten 
                        en -consumenten op de campus op elkaar af te stemmen, variërend van onderzoeksgroepen, 
                        onderhoudsbedrijven en woningcorporaties tot elektriciteitsleveranciers.
                    """.trimIndent()
                )
            },
        )
    }
}


@Composable
private fun TextParagraph(
    enTitleText: String,
    nlTitleText: String,
    content: @Composable () -> Unit,
) = Column {
    H4(
        Modifier.margin(0.cssRem).toAttrs()
    ) {
        LangText(
            en = enTitleText,
            nl = nlTitleText,
        )
    }
    P(DeEmphasizedTextStyle.toAttrs()) {
        content()
    }
}