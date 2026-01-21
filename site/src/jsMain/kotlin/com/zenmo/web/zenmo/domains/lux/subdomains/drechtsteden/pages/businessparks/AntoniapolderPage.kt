package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun AntoniapolderPage() {
    ModelInDevelopmentInfoWidget()
    ModelPageContent(
        modelLabel = antoniapolder.label,
        enHeaderText = "Bedrijventerrein Antoniapolder",
        nlHeaderText = "Bedrijventerrein Antoniapolder",
        enDescriptionParagraph = """
                Below you can view the digital twin for the sustainability of the Antoniapolder and Groenoord business 
                parks in Hendrik-Ido-Ambacht. The companies in this business park are exploring whether they can share 
                energy and invest in sustainable technologies together. The digital twin will assist in designing these 
                sustainable energy systems and making the right decisions.
            """.trimIndent(),
        nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein Antoniapolder en Groenoord 
                in Hendrik-Ido-Ambacht. De bedrijven op dit bedrijventerrein zijn aan het onderzoeken of ze samen 
                energie kunnen delen en investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen 
                van deze duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
        enSubHeaderText = "Design your own energy system",
        nlSubHeaderText = "Ontwerp je eigen energiesysteem",
        pageImageSrc = antoniapolder.imageUrl
    ) {
        ProfileContactCard(
            name = ZenmoTeam.NAUD_LOOMANS.memberName,
            imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
            email = ZenmoTeam.NAUD_LOOMANS.email,
            telephoneNumber = "+31 6 15249535",
            enSubtitle = "Website and model development",
            nlSubtitle = "Website en model ontwikkeling",
        )
    }
}