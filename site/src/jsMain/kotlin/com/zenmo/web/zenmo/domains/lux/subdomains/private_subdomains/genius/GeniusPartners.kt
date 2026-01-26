package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius

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
        "https://cubecharging.com/"
    ),
    ENERZIEN(
        "Enerzien",
        "/lux/logos/genius/enerzien.jpg",
        "https://enerzien.nl/"
    ),
}


val majorGeniusPartners = listOf(
    GeniusPartners.EUROPEAN_UNION,
    GeniusPartners.OPZUID,
)

val listOfGeniusPartners = listOf(
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