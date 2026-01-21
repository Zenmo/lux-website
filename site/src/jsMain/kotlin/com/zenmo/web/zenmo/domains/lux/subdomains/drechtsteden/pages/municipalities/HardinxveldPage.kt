package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun HardinxveldPage() {
    ModelInDevelopmentInfoWidget()
    ModelPageContent(
        modelLabel = hardinxveld.label,
        enHeaderText = "Bedrijventerreinen Gemeente Hardinxveld-Giessendam",
        nlHeaderText = "Bedrijventerreinen Gemeente Hardinxveld-Giessendam",
        enDescriptionParagraph = """
                Below you can find the digital twin for the sustainability of the business parks in the municipality 
                of Hardinxveld-Giessendam. The companies in this municipality are exploring whether they can share 
                energy and invest in sustainable technologies together. The digital twin will help design these 
                sustainable energy systems and make the right decisions.
            """.trimIndent(),
        nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van de bedrijventerreinen in Gemeente 
                Hardinxveld-Giessendam. De bedrijven in deze gemeente zijn aan het onderzoeken of ze samen energie 
                kunnen delen en investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen van 
                deze duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
        pageImageSrc = hardinxveld.imageUrl
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
