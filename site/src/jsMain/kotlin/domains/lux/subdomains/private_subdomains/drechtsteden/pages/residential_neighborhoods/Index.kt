package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_neighborhoods

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.domains.lux.sections.application_fields.DrechtstedenProjectArea
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.ResidentialAreaModelPageText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.toTwinModelCardItems
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun NeighbourhoodsPage() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        introContent = {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .gap(1.cssRem)
            ) {
                HeaderText(
                    enText = DrechtstedenProjectArea.RESIDENTIAL_AREAS.label.en,
                    nlText = DrechtstedenProjectArea.RESIDENTIAL_AREAS.label.nl,
                )
                ResidentialAreaModelPageText()
            }
        },
        anylogicRender = {},
        footerContent = {
            HeaderText(
                enText = "Explore the Models",
                nlText = "Verken de Modellen",
            )
            NeighbourhoodModels()
        }
    )
}


@Composable
fun NeighbourhoodModels() =
    TwinModelsGrid(
        models = drechtstedenNeighbourhoodsModels.toTwinModelCardItems(),
    )
