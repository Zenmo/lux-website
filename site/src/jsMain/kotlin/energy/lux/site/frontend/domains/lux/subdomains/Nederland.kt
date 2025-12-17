package energy.lux.site.frontend.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import kotlin.uuid.Uuid


@Composable
fun NederlandIndex() {
    LuxSubdomainPageLayout(
        title = "Nederland",
    ) {
        ModelPageContent(
            twin = SubdomainModel.Nederland,
            imageUrl = "/lux/images/Model-nederland.png",
            enDescriptionParagraph = "Below is a mock-up of the digital twin for the Netherlands",
            nlDescriptionParagraph = "Bekijk hieronder de mock-up van de digital twin voor Nederland",
            modelContent = {
                AnyLogicEmbed(
                    modelId = Uuid.parse("0853040a-824d-4341-9d50-26bf4a3deb8f"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            }
        ) {}
    }
}
