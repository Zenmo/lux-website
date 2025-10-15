package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResRegion
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.AukeNaudContactCard

@Composable
fun DrechtstedenPage() {
    val twinModel = DrechtstedenResRegion.DrechtstedenRes
    DrechtstedenTwinLayout(
        title = twinModel.title,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = twinModel.title,
        nlTwinPageHeaderTitle = twinModel.title,
    ) {
        ModelInDevelopmentInfoWidget()
        ModelPageContent(
            twin = twinModel,
            imageUrl = "/lux/images/drechtsteden/res-region/drechtsteden_2.png",
            enDescriptionParagraph = """
                                Below is a mock-up of the digital twin for the sustainability of the Drechtsteden. 
                                This area is working on a smart energy system. The digital twin will assist in 
                                designing these sustainable energy systems and making the right decisions.
                        """.trimIndent(),
            nlDescriptionParagraph = """
                                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van de 
                                Drechtsteden. In dit gebied wordt gewerkt aan een slim energiesysteem. De digital twin 
                                zal helpen bij het ontwerpen van deze duurzame energiesystemen en het maken van de 
                                juiste beslissingen.
                        """.trimIndent(),
            enSubHeaderText = "Design your own energy system",
            nlSubHeaderText = "Ontwerp je eigen energiesysteem",
        ) {
            AukeNaudContactCard()
        }
    }
}


