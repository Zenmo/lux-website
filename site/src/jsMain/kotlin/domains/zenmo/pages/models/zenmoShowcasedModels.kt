package energy.lux.frontend.domains.zenmo.pages.models

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.model.subdomain.amersfoort
import energy.lux.frontend.domains.lux.core.model.subdomain.demoEnergyHubModel
import energy.lux.frontend.domains.lux.core.model.subdomain.demoNeighbourhoodModel
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.pages.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.pages.application_fields.components.LUX_DEMO_SECTION_ID
import energy.lux.frontend.pages.SiteGlobals
import web.window.window

private val DEMO_MODEL_URL_PREFIX = "${window.location.protocol}//${SiteGlobals.LUX_DOMAIN}/"
val zenmoShowcasedModels: List<ShowcasedModel> = listOf(
    ShowcasedModel(
        model = demoNeighbourhoodModel.copy(
            url = "$DEMO_MODEL_URL_PREFIX${LuxApplicationArea.LUX_ENERGY_HUB.url}#${LUX_DEMO_SECTION_ID}",
        ),
        description = LocalizedText(
            en = """
                In residential areas, peak load on the electricity grid can be strongly reduced through targeted 
                management. This means: connecting more houses with the same grid capacity. 
            """.trimIndent(),
            nl = """
                In woonwijken kan de piekbelasting van het electriciteitsnet sterk afnemen als daar gericht op wordt 
                gestuurd. Dat betekent: met dezelfde netcapaciteit meer huizen aansluiten. 
            """.trimIndent()
        ),
    ),
    ShowcasedModel(
        model = demoEnergyHubModel.copy(
            url = "$DEMO_MODEL_URL_PREFIX${LuxApplicationArea.LUX_ENERGY_HUB.url}#${LUX_DEMO_SECTION_ID}",
        ),
        description = LocalizedText(
            en = """
               In business parks, net congestion is the cause of great problems. Forming an energy hub can be the 
               solution. LUX Energy Hub lets you explore different scenario’s. 
           """.trimIndent(),
            nl = """
             Op bedrijventerreinen zorgt netcongestie voor grote problemen. Samen een energie hub vormen kan de 
             oplossing zijn. LUX Energy Hub biedt je de mogelijkheid om verschillende scenario’s te verkennen.    
            """.trimIndent()
        )
    ),
    ShowcasedModel(
        model = empowered,
        description = LocalizedText(
            en = """
                The EmPowerED project is developing a systems design toolbox that helps decision-makers understand the 
                complex interplay of social, legal, financial, and technical factors in local energy systems. 
            """.trimIndent(),
            nl = """
                Het EmPowerED project is gericht op het ontwikkelen van een systems design toolbox die beleidsmakers 
                helpt om de complexe samenhang tussen sociale, wettelijke, financiële en technische factoren in lokale 
                energiesystemen te begrijpen. 
            """.trimIndent()
        )
    ),
    ShowcasedModel(
        model = amersfoort,
        description = LocalizedText(
            en = """
                The municipality of Amersfoort was interested in the differences in energy dynamics per neighborhood 
                and used LUX Neighbourhood to explore some scenarios.  
            """.trimIndent(),
            nl = """
                De gemeente Amersfoort was geïnteresseerd in de verschillen in energiedynamiek per wijk en heeft LUX 
                Woonwijk gebruikt om enkele scenario's te verkennen. 
            """.trimIndent()
        )
    ),
)