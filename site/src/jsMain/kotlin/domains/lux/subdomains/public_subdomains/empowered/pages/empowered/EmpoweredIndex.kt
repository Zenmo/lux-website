package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.bronckhorstMenuItem
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.nijmegenHengstdalMenuItem
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.bronckhorstModel
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.EmpoweredHeader
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.EmpoweredTextGrid
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.LearnMoreAboutEmpowered
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.nijmegenHengstdalModel
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import kotlin.uuid.Uuid

@Composable
fun EmpoweredIndex() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        anylogicRender = {},
        introContent = {
            EmpoweredHeader()
        },
        mediaContent = {
            ImageContent(
                imageUrl = empowered.imageUrl
            )
        },
        extraContent = {
            EmpoweredTextGrid()
            LearnMoreAboutEmpowered()
            EmpoweredModels()
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        },
    )
}

@Composable
private fun EmpoweredModels() {
    TwinModelsGrid(
        models = listOf(
            bronckhorstModel.copy(url = bronckhorstMenuItem.route.path),
            nijmegenHengstdalModel.copy(url = nijmegenHengstdalMenuItem.route.path),
        ),
    )
}