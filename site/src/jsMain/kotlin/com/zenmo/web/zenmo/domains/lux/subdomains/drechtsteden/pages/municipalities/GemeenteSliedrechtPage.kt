package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun GemeenteSliedrechtPage() {
    DrechtstedenTwinLayout(
        title = sliedrechtMunicipality.label.nl,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = sliedrechtMunicipality.label.en,
        nlTwinPageHeaderTitle = sliedrechtMunicipality.label.nl,
    ) {
        ModelInDevelopmentInfoWidget()
        ModelPageContent(
            modelLabel = sliedrechtMunicipality.label,
            enHeaderText = "Bedrijventerreinen Gemeente Sliedrecht",
            nlHeaderText = "Bedrijventerreinen Gemeente Sliedrecht",
            enDescriptionParagraph = """
                Below you can find the digital twin for the sustainability of the business parks in the Municipality 
                of Alblasserdam. The companies in this municipality are exploring whether they can share energy and 
                invest in sustainable technologies together. The digital twin will assist in designing these sustainable 
                energy systems and making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van de bedrijventerreinen in Gemeente 
                Alblasserdam. De bedrijven in deze gemeente zijn aan het onderzoeken of ze samen energie kunnen delen 
                en investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen van deze duurzame 
                energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
            pageImageSrc = sliedrechtMunicipality.imageUrl
        ) {
            ProfileContactCard(
                name = ZenmoTeam.ATE.memberName,
                imageUrl = ZenmoTeam.ATE.image,
                email = ZenmoTeam.ATE.email,
                telephoneNumber = "+31 6 14910380",
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}