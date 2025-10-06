package com.zenmo.web.zenmo.domains.lux.subdomains.genius

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H1

val PartnerLogoStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Contain)
    }
}

@Composable
fun PartnerLogos() {
    Column(
        Modifier.margin(bottom = 5.cssRem)
            .gap(2.cssRem)
            .fillMaxWidth()
            .borderRadius(30.px)
            .background(Colors.White)
            .padding(leftRight = 3.cssRem, topBottom = 5.cssRem)
            .boxShadow(0.px, 0.px, 15.px, 15.px, rgba(0, 0, 0, 0.03f))
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
            numColumns = numColumns(base = 2, sm = 2, md = 2, lg = 3, xl = 4),
            modifier = Modifier.columnGap(1.cssRem).rowGap(2.cssRem).fillMaxWidth()
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


val PartnerLogosImageContainerStyle = CssStyle {
    base {
        Modifier
            .padding(1.cssRem)
    }
    Breakpoint.ZERO {
        Modifier
            .fillMaxWidth()
            .height(100.px)
            .padding(0.5.cssRem)
    }
    Breakpoint.SM {
        Modifier
            .fillMaxWidth()
            .height(100.px)
            .padding(0.5.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .fillMaxWidth()
            .height(120.px)
    }
    Breakpoint.LG {
        Modifier
            .width(240.px)
            .height(140.px)
    }
    Breakpoint.XL {
        Modifier
            .width(240.px)
            .height(140.px)
    }
}

@Composable
private fun PartnerLogoImage(
    partner: GeniusPartners,
) = Box(
    PartnerLogosImageContainerStyle.toModifier(),
    contentAlignment = Alignment.Center
) {
    Image(
        src = partner.logoUrl,
        alt = "${partner.partnerName} logo",
        modifier = PartnerLogoStyle.toModifier()
    )
}

enum class GeniusPartners(
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