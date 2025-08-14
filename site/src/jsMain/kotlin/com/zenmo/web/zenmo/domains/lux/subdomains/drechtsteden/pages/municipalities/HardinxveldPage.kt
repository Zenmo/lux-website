package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.VerticalProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem

@Composable
fun HardinxveldPage() {
    val twinModel = DrechtstedenTwinModel.SliedrechtMunicipality
    DrechtstedenTwinLayout(
        title = twinModel.title,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = twinModel.title,
        nlTwinPageHeaderTitle = twinModel.title,
    ) {
        ModelInDevelopmentInfoWidget()
        ModelPageContent(
            twin = twinModel,
            enHeaderText = "Zero - Bedrijventerreinen Gemeente Hardinxveld-Giessendam",
            nlHeaderText = "Zero - Bedrijventerreinen Gemeente Hardinxveld-Giessendam",
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


// should we have a ContactCardPair component? instead just one for both Auke and Naud?
@Composable
fun AukeNaudtContactCard() {
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderText(
            enText = "Contact and info", nlText = "Contact en info", modifier = Modifier.margin(0.cssRem)
        )
        SubHeaderText(
            enText = "Website and model development",
            nlText = "Website en model ontwikkeling",
            modifier = Modifier.margin(0.cssRem)
        )
        ZenmoInlineLink()
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
            modifier = Modifier.gap(4.cssRem).margin(topBottom = 3.cssRem)
        ) {
            VerticalProfileContactCard(
                name = ZenmoTeam.NAUD_LOOMANS.memberName,
                imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                email = ZenmoTeam.NAUD_LOOMANS.email,
                telephoneNumber = "+31 (6) 1524 9535",
            )

            VerticalProfileContactCard(
                name = ZenmoTeam.AUKE.memberName,
                imageUrl = ZenmoTeam.AUKE.image,
                email = ZenmoTeam.AUKE.email,
                telephoneNumber = "+31 (6) 5161 4294",
            )
        }
    }
}