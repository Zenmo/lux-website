package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.EmpoweredHeader
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.EmpoweredTextGrid
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.LearnMoreAboutEmpowered
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
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        },
    )
}