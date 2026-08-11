package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.BlurModelImageStyle
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.ProtectedWrapperStyle
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.GeniusPartners
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.components.PartnerLogoImage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.majorGeniusPartners
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.core.models.ZenmoTeamMember
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.utils.PublicRes
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*

@Composable
fun H4B() {
    val h4b = PrivateSubdomainModel.H4B
    LuxSubdomainPageLayout(
        title = h4b.label.nl,
    ) {
        SubdomainModelPage(
            modelId = h4b.modelId,
            introContent = {
                Column {
                    H1(
                        TextStyle.toModifier(HeaderTextStyle)
                            .fontFamily(PublicRes.FontFamilies.HOLON_LINE)
                            .textTransform(TextTransform.None)
                            .color(SitePalette.light.primary)
                            .toAttrs()
                    ) {
                        HeaderText(
                            nlText = "H4B - ",
                        )
                        Text(" ${h4b.label.nl} ")
                    }
                    H4BText()
                }

            },
            mediaContent = {
                ImageContent(
                    imageUrl = "/lux/images/Schermafbeelding.jpg",
                    alt = "H4B image",
                    modifier = Modifier
                        .width(80.percent)
                        .height(auto)
                        .objectFit(ObjectFit.Contain)
                )
            },
            anylogicRender = {
                Box(
                    modifier = Modifier
                        .position(Position.Relative)
                        .height(80.vh)
                        .fillMaxWidth()
                        .position(Position.Relative)
                        .textAlign(TextAlign.Center),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        src = "/lux/images/models/genius.png",
                        alt = "H4B model image",
                        modifier = BlurModelImageStyle.toModifier()
                            .fillMaxWidth()
                    )
                    Div(ProtectedWrapperStyle.toModifier().toAttrs()) {
                        H3 {
                            LangText(
                                en = "Come back soon to see the model!",
                                nl = "Kom binnenkort terug om het model te bekijken!"
                            )
                        }
                    }
                }
            },
            extraContent = { H4BPartners() },
            footerContent = { ZenmoModellerProfileCard(ZenmoTeamMember.BAS) }
        )
    }
}

@Composable
private fun H4BText() {
    Column {
        P {
            LangText(
                en = """
                    Heat4Buildings focuses on the development of a wide range of heating solutions for the 
                    built environment. These solutions lead to lower costs, higher energy efficiency, and 
                    reduction of grid load.
                """.trimIndent(),
                nl = """
                    Heat4Buildings richt zich op de ontwikkeling van een breed palet aan warmteoplossingen voor 
                    de gebouwde omgeving. Deze oplossingen leiden tot lagere kosten, hogere energie-efficiëntie 
                    en vermindering van netbelasting.
                """.trimIndent()
            )
        }
        P {
            LangText(
                en = """
                    To realize an affordable and scalable heat supply in various types of built environments, different 
                    solutions are required. The goal is to develop heating systems in which the cost per unit of energy 
                    is reduced by 30%. In this regard, the integration of generation, storage, and transport is crucial 
                    for optimal utilization and exchange of energy. Additionally, easy integration into the built 
                    environment is important for a pleasant living environment. The project has multiple objectives:
                """.trimIndent(),
                nl = """
                    Om een betaalbare en schaalbare warmtevoorziening te realiseren in verschillende typen gebouwde 
                    omgeving, zijn verschillende oplossingen nodig. Het doel is om warmtesystemen te ontwikkelen 
                    waarbij de kosten per eenheid energie met 30% zijn gereduceerd. Hierbij is integratie van opwek, 
                    opslag en transport, voor optimale benutting en uitwisseling van de energie, cruciaal. Daarnaast is 
                    eenvoudige inpassing in de gebouwde omgeving van belang voor een prettige leefomgeving. Het project 
                    kent meerdere doelstellingen:
                """.trimIndent()
            )
        }

        Div {
            Ul {
                Li {
                    LangText(
                        en = "Higher energy density and integrated and affordable heating systems.",
                        nl = "Hogere energiedichtheid en geïntegreerde en betaalbare warmtesystemen."
                    )
                }
                Li {
                    LangText(
                        en = "Reducing grid congestion.",
                        nl = "Verminderen van netcongestie."
                    )
                }
                Li {
                    LangText(
                        en = "Manufacturability, scalability and industrialization.",
                        nl = "Maakbaarheid, schaalbaarheid en industrialisatie."
                    )
                }
                Li {
                    LangText(
                        en = "Reduction of environmental impact.",
                        nl = "Reductie milieu-impact."
                    )
                }
                Li {
                    LangText(
                        en = "Expanding the ecosystem around heat innovation to accelerate the transition.",
                        nl = "Ecosysteem rondom warmte -innovatie uitbreiden om de transitie te versnellen."
                    )
                }
            }
        }
        P {
            LangText(
                en = """
                    During Heat4Buildings, the parties work both individually and jointly on developing and 
                    demonstrating innovations. There is ample room for coordination, ensuring that solutions become 
                    integrated and coherent. Problems are approached from various angles, allowing innovations to truly 
                    become part of a broad portfolio of heating solutions for low-rise buildings, high-rise buildings, 
                    neighborhoods, and business parks.
                """.trimIndent(),
                nl = """
                    Tijdens Heat4Buildings werken de partijen zowel individueel als gezamenlijk aan het ontwikkelen en 
                    demonstreren van innovaties. Er is veel ruimte voor afstemming, waardoor oplossingen integraal en 
                    samenhangend worden. Problemen worden vanuit verschillende invalshoeken benaderd, waardoor 
                    innovaties echt onderdeel worden van een breed portfolio aan warmteoplossingen voor laagbouw, 
                    hoogbouw, wijken en bedrijventerreinen.
                """.trimIndent()
            )
        }
    }
}

@Composable
private fun H4BPartners() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .gap(2.cssRem)
            .fillMaxWidth()
            .borderRadius(30.px)
            .background(Colors.White)
            .padding(leftRight = 3.cssRem, topBottom = 5.cssRem)
            .boxShadow(0.px, 0.px, 15.px, 15.px, rgba(0, 0, 0, 0.03f))
            .textAlign(TextAlign.Center),
    ) {
        H1 {
            LangText(
                en = "This project is funded by:".uppercase(),
                nl = "Dit project wordt gefinancierd door:".uppercase(),
            )
        }

        SimpleGrid(
            numColumns = numColumns(base = 2, md = 3, lg = 3, xl = 3),
            modifier = Modifier.columnGap(1.cssRem).rowGap(1.cssRem)
        ) {
            val funders = majorGeniusPartners + listOf(GeniusPartners.BRABANT)
            funders.forEach { partner ->
                PartnerLogoImage(
                    partner = partner,
                    modifier = Modifier.height(auto)
                )
            }
        }
        H1 {
            LangText(
                en = "Partners:",
                nl = "Partners:",
            )
        }
        ImageContent(
            imageUrl = "/lux/images/h4b_partners.jpeg",
            alt = "H4B partners ",
            modifier = Modifier.fillMaxWidth().objectFit(ObjectFit.Contain)
                .height(auto)

        )
    }
}