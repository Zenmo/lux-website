package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import kotlin.uuid.Uuid

//
@Composable
fun SomeLuxModelPage() {
    LuxSubdomainPageLayout(
        title = "Page title",
    ) {
        ModelPageContent(
            twin = SubdomainModel.Hessenpoort,
            enHeaderText = "Some Lux Model",
            nlHeaderText = "Een Lux Model",
            enDescriptionParagraph = """
                Roses are red, violets are blue. Sugar is sweet, and so are you. I don't know what else to write,
                maybe you should stop reading now.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Rozen zijn rood, viooltjes zijn blauw. Suiker is zoet, en jij ook. Ik weet niet wat ik nog meer moet schrijven,
                misschien moet je nu maar stoppen met lezen.
            """.trimIndent(),
            enSubHeaderText = "This is a subheader",
            nlSubHeaderText = "Dit is een subheader",
            metaContent = { ModelInDevelopmentInfoWidget() },
            modelContent = {
                AnyLogicEmbed(
                    modelId = Uuid.parse("cca6eb2b-fb91-4825-bee2-d5e12d0a3880"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            },
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
}