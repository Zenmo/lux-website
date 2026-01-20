package com.zenmo.web.zenmo.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.nederland
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import kotlin.uuid.Uuid


@Composable
fun NederlandIndex() {
    LuxSubdomainPageLayout(
        title = nederland.label.nl,
    ) {
        ModelPageContent(
            modelLabel = nederland.label,
            pageImageSrc = "/lux/images/Model-nederland.png",
            enDescriptionParagraph = "Below is a mock-up of the digital twin for the Netherlands",
            nlDescriptionParagraph = "Bekijk hieronder de mock-up van de digital twin voor Nederland",
            modelContent = {
                AnyLogicEmbed(
                    modelId = nederland.modelId,
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            }
        ) {}
    }
}
