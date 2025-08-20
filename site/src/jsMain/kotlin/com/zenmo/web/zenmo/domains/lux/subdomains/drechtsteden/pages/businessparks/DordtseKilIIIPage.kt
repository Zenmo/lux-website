package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun DordtseKilIIIPage() {
    val twinModel = DrechtstedenTwinModel.DordtseKil34
    DrechtstedenTwinLayout(
        title = twinModel.title,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = twinModel.title,
        nlTwinPageHeaderTitle = twinModel.title,
    ) {
        ModelInDevelopmentInfoWidget(
            enDescription = "Note, this model is still in development.",
            nlDescription = "Let op, dit model is nog in ontwikkeling.",
        )
        ModelPageContent(
            twin = twinModel,
            enHeaderText = "Bedrijventerreinen Dordtse Kil III & IV",
            nlHeaderText = "Bedrijventerreinen Dordtse Kil III & IV",
            enDescriptionParagraph = """
                Below you can find the digital twin for the sustainability of business park Dordtse Kil 3&4 in 
                Dordrecht. The companies on this business park are investigating whether they can share energy 
                together and invest in sustainable technologies. The digital twin will help in designing these 
                sustainable energy systems and making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein Dordtse Kil 3&4 in 
                Dordrecht. De bedrijven op dit bedrijventerrein zijn aan het onderzoeken of ze samen energie kunnen 
                delen en investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen van deze 
                duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
            enSubHeaderText = "Design your own energy system",
            nlSubHeaderText = "Ontwerp je eigen energiesysteem",
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