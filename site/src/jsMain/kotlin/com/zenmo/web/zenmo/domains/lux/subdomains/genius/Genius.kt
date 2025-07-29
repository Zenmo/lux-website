package com.zenmo.web.zenmo.domains.lux.subdomains.genius

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPhone
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.*
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.HeaderInnerStyle
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeaderPaddingStyle
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCardImageContainerStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.HolonBlockHeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun Genius() {
    PageLayout(
        header = { GeniusHeader() },
        footer = {},
        title = "Genius"
    ) {
        SectionContainer(
            modifier = Modifier.gap(5.cssRem),
            variant = LuxSectionContainerStyleVariant
        ) {
            IntroContent()

            ImageContent(
                imageUrl = "/lux/images/afbeelding.jpeg",
                alt = "genius campus image",
                modifier = Modifier.fillMaxWidth()
            )

            TextContent()

            ModelWrapper(
                imgUrl = "/lux/images/models/genius.png",
                entryPoint = "genius"
            )

            PartnerLogos()

            MediaContentLayout(
                imageUrl = "",
                visualContent = {
                    Box(TeamCardImageContainerStyle.toModifier().size(22.cssRem)) {
                        Image(
                            modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                            src = ZenmoTeam.ATE.image,
                            alt = "${ZenmoTeam.ATE.memberName} photo",
                        )
                    }
                },
                title = {
                    HeaderText(
                        enText = ZenmoTeam.ATE.memberName,
                        nlText = ZenmoTeam.ATE.memberName,
                        modifier = Modifier.margin(0.cssRem)
                    )
                },
                subtitle = {
                    SubHeaderText(
                        enText = "Website and model development",
                        nlText = "Website en model ontwikkeling",
                        modifier = Modifier.color(SitePalette.light.primary)
                            .margin(0.cssRem)
                    )
                },
                description = {
                    Column(Modifier.gap(0.5.cssRem)) {
                        Row {
                            MdiPhone(Modifier.padding(right = 0.25.cssRem))
                            Text("+31 6 14910380")
                        }

                        Row {
                            MdiMail(Modifier.padding(right = 0.25.cssRem))
                            Text(ZenmoTeam.ATE.email)
                        }
                    }
                },
                actionText = {},
                reversed = false,
            )
        }
    }
}

val HeaderLogoStyle = CssStyle {
    base {
        Modifier
            .width(80.px)
            .height(40.px)
    }
}

@Composable
private fun GeniusHeader() {
    Header(
        attrs = NavHeaderStyle.toModifier()
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Div {
                Image(
                    src = "/lux/logos/genius/logo_genius.png",
                    alt = "genius logo",
                    modifier = Modifier.width(160.px).height(80.px)
                )
            }

            Div {
                Row(
                    modifier = Modifier.gap(1.cssRem),
                ) {
                    Image(
                        src = GeniusPartners.ZENMO.logoUrl,
                        alt = "zenmo logo",
                        modifier = HeaderLogoStyle.toModifier()
                    )

                    Image(
                        src = "/lux/logos/TUe-logo-scarlet-L-1.png",
                        alt = "TU/e",
                        modifier = HeaderLogoStyle.toModifier()
                    )
                    LanguageSwitchButton()
                }
            }
        }
    }
}

@Composable
private fun IntroContent() {
    Column {
        Div {
            LangBlock(
                en = {
                    H1(TextStyle.toModifier(HeaderTextStyle).toAttrs()) {
                        Span(TextStyle.toModifier(HolonBlockHeaderTextStyle).toAttrs()) {
                            Text("GENIUS - ")
                        }
                        Text("Grid Efficiency Network Integration for Universal Sustainability")
                    }
                },
                nl = {
                    H1(TextStyle.toModifier(HeaderTextStyle).toAttrs()) {
                        Span(TextStyle.toModifier(HolonBlockHeaderTextStyle).toAttrs()) {
                            Text("GENIUS - ")
                        }
                        Text("Grid Efficiency Network Integratie voor Universele Duurzaamheid")
                    }
                }
            )
        }
        P {
            LangText(
                en = """
                    In the three-year European innovation project GENIUS, a consortium of partners led by TU/e will 
                    optimize the campus’ energy infrastructure and usage in order to address the growing problem of 
                    network congestion. The project will act as a blueprint for the energy management of other 
                    campus-like environments, such as industrial sites.
                """.trimIndent(),
                nl = """
                    In het driejarige Europese innovatieproject GENIUS zal een consortium van partners onder leiding 
                    van de TU/e de energie-infrastructuur en het energieverbruik van de campus optimaliseren om het 
                    groeiende probleem van netwerkcongestie aan te pakken. Het project zal dienen als blauwdruk voor 
                    het energiebeheer van andere campusachtige omgevingen, zoals industrieterreinen.
                """.trimIndent()
            )
        }

        P(
            DeEmphasizedTextStyle.toModifier().toAttrs()
        ) {
            LangText(
                en = """
                    The GENIUS-project is funded by a strategic European OPZuid grant worth 1,375,000 euros, 
                    supplemented by investments by the national and regional government. The total project budget 
                    amounts approximately 3 million euros. The aim of the project is to solve the problem of net 
                    congestion on campus, and to serve as a testing ground for innovations, shortening their time to 
                    market.
                """.trimIndent(),
                nl = """
                    Het GENIUS-project wordt gefinancierd door een strategische Europese OPZuid-subsidie van 1,375,000 
                    euro, aangevuld met investeringen van de nationale en regionale overheid. Het totale projectbudget 
                    bedraagt ongeveer 3 miljoen euro. Het doel van het project is om het probleem van netwerkcongestie 
                    op de campus op te lossen en te dienen als testomgeving voor innovaties, waardoor de tijd tot 
                    marktverkrijging wordt verkort.
                """.trimIndent()
            )
        }
    }
}

@Composable
private fun TextContent() {
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

private enum class GeniusPartners(
    val partnerName: String,
    val logoUrl: String,
    val siteUrl: String? = null,
) {
    EUROPEAN_UNION(
        "Medegefinancierd door de Europese Unie",
        "/lux/logos/genius/europese.jpg"
    ),
    OPZUID("OPZUID", "/lux/logos/genius/op-zuid.jpg"),
    BRABANT(
        "Province Noor-Brabant",
        "/lux/logos/genius/noord_brabant.jpg",
        "https://www.brabant.nl/"
    ),
    TU_E(
        "TU/e",
        "/lux/logos/genius/tu_e.jpg",
        "http://www.tue.nl/"
    ),
    TU_E_EIRES(
        "TU/e EIRES",
        "/lux/logos/genius/eires.jpg",
        "https://www.tue.nl/en/research/institutes/eindhoven-institute-for-renewable-energy-systems/"
    ),
    TU_E_EAISI(
        "TU/e EAISI",
        "/lux/logos/genius/eaisi.jpg",
        "https://www.tue.nl/en/research/institutes/eindhoven-artificial-intelligence-systems-institute"
    ),
    FUDURA(
        "Fudura",
        "/lux/logos/genius/fudura.jpg",
        "https://www.fudura.nl/"
    ),
    SIMPL_ENERGY(
        "simpl.energy",
        "/lux/logos/genius/simpl.jpg",
        "https://simpl.energy/nl/nl"
    ),
    VB_OPTIMUM(
        "VB Optimum",
        "/lux/logos/genius/vb_optimum.jpg",
        "https://vboptimum.com/nl/"
    ),
    EINDHOVEN_ENGINE(
        "Eindhoven Engine",
        "/lux/logos/genius/eindhoven_engine.jpg",
        "https://eindhovenengine.nl/"
    ),
    ZENMO(
        "Zenmo Simulations",
        "/logos/logo2.png",
        "https://zenmo.com"
    ),
    VOLTGOED(
        "VOLTgoed",
        "/lux/logos/genius/voltgoed.jpg",
        "https://www.voltgoed.nl/"
    ),
    RIFT(
        "RIFT",
        "/lux/logos/genius/blaadje.jpg",
        "https://www.ironfueltechnology.com/"
    ),
    WOON_BEDRIJF(
        "Woonbedrijf",
        "/lux/logos/genius/woonbedrijf.jpg",
        "https://www.woonbedrijf.com/"
    ),
    CUBE(
        "CUBE",
        "/lux/logos/genius/cube.jpg",
    ),
    ENERZIEN(
        "Enerzien",
        "/lux/logos/genius/enerzien.jpg",
        "https://enerzien.nl/"
    ),
}


private val majorGeniusPartners = listOf(
    GeniusPartners.EUROPEAN_UNION,
    GeniusPartners.OPZUID,
)

private val listOfGeniusPartners = listOf(
    GeniusPartners.BRABANT,
    GeniusPartners.TU_E,
    GeniusPartners.TU_E_EIRES,
    GeniusPartners.TU_E_EAISI,
    GeniusPartners.FUDURA,
    GeniusPartners.SIMPL_ENERGY,
    GeniusPartners.VB_OPTIMUM,
    GeniusPartners.EINDHOVEN_ENGINE,
    GeniusPartners.ZENMO,
    GeniusPartners.VOLTGOED,
    GeniusPartners.RIFT,
    GeniusPartners.WOON_BEDRIJF,
    GeniusPartners.CUBE,
    GeniusPartners.ENERZIEN,
)

val PartnerLogoStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .objectFit(ObjectFit.Contain)
    }
}

@Composable
private fun PartnerLogos() {
    Column(
        Modifier.margin(bottom = 5.cssRem)
            .gap(2.cssRem)
            .fillMaxWidth()
            .borderRadius(30.px)
            .background(Colors.White)
            .padding(leftRight = 3.cssRem, topBottom = 5.cssRem)
            .textAlign(TextAlign.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H1 {
            LangText(
                en = "The Genius Project is Made Possible By:".uppercase(),
                nl = "Het Genius Project is mogelijk gemaakt door:".uppercase(),
            )
        }

        SimpleGrid(
            numColumns = numColumns(base = 2, md = 2, lg = 2, xl = 2),
            modifier = Modifier.columnGap(1.cssRem).rowGap(2.cssRem)
        ) {
            majorGeniusPartners.forEach { partner ->
                PartnerLogoImage(
                    partner = partner,
                )
            }
        }

        H1 {
            LangText(
                en = "AND BY:",
                nl = "EN DOOR:",
            )
        }

        SimpleGrid(
            numColumns = numColumns(base = 2, md = 4, lg = 4, xl = 4),
            modifier = Modifier.columnGap(1.cssRem).rowGap(2.cssRem)
        ) {
            listOfGeniusPartners.forEach { partner ->
                when (partner.siteUrl == null) {
                    true -> PartnerLogoImage(partner = partner)
                    false -> A(
                        href = partner.siteUrl,
                        attrs = Modifier
                            .textDecorationLine(TextDecorationLine.None)
                            .toAttrs()
                    ) {
                        PartnerLogoImage(partner = partner)
                    }
                }
            }
        }
    }
}

@Composable
private fun PartnerLogoImage(
    partner: GeniusPartners,
) = Box(
    Modifier
        .width(240.px)
        .height(140.px)
        .padding(1.cssRem),
    contentAlignment = Alignment.Center
) {
    Image(
        src = partner.logoUrl,
        alt = "${partner.partnerName} logo",
        modifier = PartnerLogoStyle.toModifier()
    )
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