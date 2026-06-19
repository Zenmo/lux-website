package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.brabantNeighbourhoodModel
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun BrabantNeighbourhood() {
    SubdomainModelPage(
        modelId = brabantNeighbourhoodModel.modelId,
        introContent = {},
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        }
    )
}