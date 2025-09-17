package com.zenmo.web.zenmo.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import kotlin.uuid.Uuid


@Composable
fun HilversumIndex() {
    LuxSubdomainPageLayout(
        title = "Werfgebied Hilversum"
    ) {
        ModelPageContent(
            twin = SubdomainModel.Hilversum,
            imageUrl = "/lux/images/Werfgebied-Hilversum.png",
            enDescriptionParagraph = """
                View the digital twin for the Werfgebied Hilversum sustainability project. 
                The digital twin assists in designing these sustainable energy systems and making the 
                right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk de digitale tweeling voor het Werfgebied Hilversum duurzaamheid project.
                De digitale tweeling helpt bij het ontwerpen van deze duurzame energiesystemen en het maken
                van de juiste beslissingen.
            """.trimIndent(),
            modelContent = {
                AnyLogicEmbed(
                    modelId = Uuid.parse("00edc3d3-2942-486a-93ae-26f809872a54"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            }
        ) {
            ProfileContactCard(
                name = ZenmoTeam.NAUD_LOOMANS.memberName,
                imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                email = ZenmoTeam.NAUD_LOOMANS.email,
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}
