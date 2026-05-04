package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.OssGisMap
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.ossTwinModels
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import kotlin.uuid.Uuid


@Composable
fun OssIndex() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        anylogicRender = {},
        introContent = {
            HeaderText(
                enText = "This is the Oss Project",
                nlText = "Dit is het Oss Project",
            )
        },
        mediaContent = {
            OssGisMap()
        },
        extraContent = {
        },
        footerContent = {
            HeaderText(
                enText = "Explore the Models",
                nlText = "Verken de Modellen",
            )
            TwinModelsGrid(
                models = ossTwinModels.map {
                    it.toTwinModelCardItem()
                }
            )
        },
    )
}
