package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun SliedrechtPage() {
    ModelInDevelopmentInfoWidget()
    ModelPageContent(
        modelLabel = sliedrechtBusinesspark.label,
        enHeaderText = "Bedrijventerrein Sliedrecht",
        nlHeaderText = "Bedrijventerrein Sliedrecht",
        enDescriptionParagraph = """
                Below you can view the digital twin for the sustainability of the business parks Nijverwaard, 
                Stationspark, and Kwadrant in Sliedrecht. The companies on these business parks are exploring 
                whether they can share energy and invest in sustainable technologies together. The digital twin will 
                assist in designing these sustainable energy systems and making the right decisions.
            """.trimIndent(),
        nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerreinen Nijverwaard, 
                Stationspark en Kwadrant in Sliedrecht. De bedrijven op deze bedrijventerreinen zijn aan het 
                onderzoeken of ze samen energie kunnen delen en investeren in duurzame technieken. De digital twin zal 
                helpen bij het ontwerpen van deze duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
        enSubHeaderText = "Design your own energy system",
        nlSubHeaderText = "Ontwerp je eigen energiesysteem",
        pageImageSrc = sliedrechtBusinesspark.imageUrl
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