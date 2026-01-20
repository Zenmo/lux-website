package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun AmstelwijckPage() {
    DrechtstedenTwinLayout(
        title = amstelwijckBusinesspark.label.nl,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = amstelwijckBusinesspark.label.en,
        nlTwinPageHeaderTitle = amstelwijckBusinesspark.label.nl,
    ) {
        ModelInDevelopmentInfoWidget()
        ModelPageContent(
            modelLabel = amstelwijckBusinesspark.label,
            enHeaderText = "Bedrijventerrein Amstelwijck Businesspark",
            nlHeaderText = "Bedrijventerrein Amstelwijck Businesspark",
            enDescriptionParagraph = """
                Below you can view the digital twin for the sustainability of the Amstelwijck Businesspark. 
                The companies on this business park are exploring whether they can share energy and invest in 
                sustainable technologies together. The digital twin will assist in designing these sustainable 
                energy systems and making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein Amstelwijck Businesspark. 
                De bedrijven op dit bedrijventerrein zijn aan het onderzoeken of ze samen energie kunnen delen en 
                investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen van deze duurzame 
                energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
            pageImageSrc = amstelwijckBusinesspark.imageUrl
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