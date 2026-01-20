package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun DeGeerPage() {
    DrechtstedenTwinLayout(
        title = deGeer.label.nl,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = deGeer.label.en,
        nlTwinPageHeaderTitle = deGeer.label.nl,
    ) {
        ModelInDevelopmentInfoWidget(
            enDescription = "Note, this model is still in development.",
            nlDescription = "Let op, dit model is nog in ontwikkeling.",
        )
        ModelPageContent(
            modelLabel = deGeer.label,
            enHeaderText = "Bedrijventerrein De Geer",
            nlHeaderText = "Bedrijventerrein De Geer",
            enDescriptionParagraph = """
                Below you can view the digital twin for the sustainability of business park De Geer in Zwijndrecht. The 
                companies on this business park are exploring whether they can share energy and invest in sustainable 
                technologies together. The digital twin will assist in designing these sustainable energy systems and 
                making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein De Geer in Zwijndrecht. De 
                bedrijven op dit bedrijventerrein onderzoeken of ze samen energie kunnen delen en investeren in 
                duurzame technieken. De digital twin zal helpen bij het ontwerpen van deze duurzame energiesystemen en 
                het maken van de juiste beslissingen.
            """.trimIndent(),
            enSubHeaderText = "Design your own energy system",
            nlSubHeaderText = "Ontwerp je eigen energiesysteem",
            pageImageSrc = deStaart.imageUrl
        ) {
            ProfileContactCard(
                name = ZenmoTeam.GILLIS.memberName,
                imageUrl = ZenmoTeam.GILLIS.image,
                email = ZenmoTeam.GILLIS.email,
                telephoneNumber = "+31 6 47171375",
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}