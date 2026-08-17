package energy.lux.frontend.domains.zenmo.pages.projects

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered

val isieProject = ZenmoProject(
    categoryText = LocalizedText(
        en = "Client: Energy Innovation NL",
        nl = "Opdrachtgever: Energy Innovation NL",
    ),
    titleText = LocalizedText("ISIE"),
    descriptionText = LocalizedText(
        en = """
            The goal of ISIE is to develop a coherent set of tools, in order to analyze the energy system in an
            integrated way, across different sectors, energy carriers, and scale levels.
        """.trimIndent(),
        nl = """
            Het doel van ISIE is om een samenhangend instrumentarium te ontwikkelen waarmee het energiesysteem
            integraal kan worden geanalyseerd, over verschillende sectoren, energiedragers en schaalniveaus heen.
        """.trimIndent(),
    ),
    url = "https://isie.energy",
    imageUrl = "https://isie.energy/isie-logo.png"
)

val holonProject = ZenmoProject(
    categoryText = LocalizedText(
        en = "Client: Energy Innovation NL", nl = "Opdrachtgever: Energy Innovation NL",
    ),
    titleText = LocalizedText(en = "HOLON", nl = "HOLON"),
    descriptionText = LocalizedText(
        en = """
            In the Holon project, we investigated the potential of a holarchic energy system. Through an interactive
            calculation tool, practical examples, and a community, the platform helps individuals, entrepreneurs, and
            municipalities put this approach into practice.
        """.trimIndent(),
        nl = """
            In project Holon onderzochten we de potentie van een holarchisch energiesysteem. Via een interactieve
            rekentool, praktijkvoorbeelden en een community helpt het platform particulieren, ondernemers en gemeenten
            om deze aanpak in de praktijk te brengen.
        """.trimIndent(),
    ),
    url = "https://holons.energy",
    imageUrl = "/zenmo/images/header_casus_buurtelectrificatie.jpg"
)

val neonProject = ZenmoProject(
    categoryText = LocalizedText(
        en = "Scientific research",
        nl = "Wetenschappelijk onderzoek",
    ),
    titleText = LocalizedText(en = "NEON", nl = "NEON"),
    descriptionText = LocalizedText(
        en = """
            The NEON research program, which Zenmo is managing in cooperation with the TU/e, consists of 40 PhD
            researchers, 20 (assistant) professors and 12 business partners, all working together with the same drive
            towards our mutual goal of accelerating the energy and mobility transition through multidisciplinary research.
        """.trimIndent(),
        nl = """
            Het NEON-onderzoeksprogramma, dat Zenmo leidt in samenwerking met de TU/e, bestaat uit 40 promovendi,
            20 (assistent-)hoogleraren en 12 bedrijfspartners, die samenwerken vanuit dezelfde drive naar ons
            gezamenlijke doel: het versnellen van de energie- en mobiliteitstransitie door middel van multidisciplinair
            onderzoek.
        """.trimIndent(),
    ),
    url = "https://neonresearch.nl",
    imageUrl = "/zenmo/images/renewables_focus_news_0.jpg"
)

val empoweredProject = ZenmoProject(
    categoryText = LocalizedText(
        en = "Positive Energy Districts",
        nl = "Positive Energy Districts",
    ),
    titleText = LocalizedText(en = "EmPowerED", nl = "EmPowerED"),
    descriptionText = LocalizedText(
        en = """
            The EmPowerED project is developing a systems design toolbox that helps decision-makers understand the
            complex interplay of social, legal, financial, and technical factors in local energy systems. This enables
            the design of solutions that are not only technically feasible but also socially supported.
        """.trimIndent(),
        nl = """
            Het EmPowerED project is gericht op het ontwikkelen van een systems design toolbox die beleidsmakers helpt
            om de complexe samenhang tussen sociale, wettelijke, financiële en technische factoren in lokale
            energiesystemen te begrijpen. Dit maakt het mogelijk om oplossingen te ontwerpen die niet alleen technisch
            haalbaar zijn maar ook sociaal draagvlak hebben.
        """.trimIndent(),
    ),
    url = empowered.url,
    imageUrl = empowered.imageUrl,
)

val heat4BuildingsProject = ZenmoProject(
    categoryText = LocalizedText(
        en = "Affordable heat",
        nl = "Betaalbare warmte",
    ),
    titleText = LocalizedText(en = "Heat4Buildings", nl = "Heat4Buildings"),
    descriptionText = LocalizedText(
        en = """
            Heat4Buildings focuses on developing a wide range of heating solutions for the built environment. These
            solutions lead to lower costs, higher energy efficiency, and reduced grid load. The project started in
            autumn 2025, will run for three years, and is funded through the OPZuid ERDF programme.
        """.trimIndent(),
        nl = """
            Heat4Buildings richt zich op de ontwikkeling van een breed palet aan warmteoplossingen voor de gebouwde
            omgeving. Deze oplossingen leiden tot lagere kosten, hogere energie-efficiëntie en vermindering van
            netbelasting. Het project is in het najaar van 2025 gestart, zal drie jaar duren en wordt gefinancierd
            middels het OPZuid EFRO programma.
        """.trimIndent(),
    ),
    url = "https://www.dgbc.nl/wat-wij-doen/heat4buildings/",
    imageUrl = PrivateSubdomainModel.H4B.imageUrl,
)

val local4LocalProject = ZenmoProject(
    categoryText = LocalizedText(
        en = "Affordable heat & power",
        nl = "Betaalbare warmte & stroom",
    ),
    titleText = LocalizedText(en = "Local4Local", nl = "Local4Local"),
    descriptionText = LocalizedText(
        en = """
            In the Local4Local project, Zenmo developed a tool for (starting) energy communities: the CoCo
            (cooperation configurator).
        """.trimIndent(),
        nl = """
            Binnen het project Local4Local ontwikkelde Zenmo een tool voor (beginnende) energiegemeenschappen:
            de CoCo (coöperatie-configurator).
        """.trimIndent(),
    ),
    url = "https://coco.local4local.nu/",
    imageUrl = "/zenmo/images/sander-weeteling.jpg",
)

val allProjects: List<ZenmoProject> = listOf(
    isieProject,
    holonProject,
    neonProject,
    empoweredProject,
    heat4BuildingsProject,
    local4LocalProject,
)