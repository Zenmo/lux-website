package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.brabantProvinceModel
import energy.lux.frontend.core.models.ZenmoTeamMember

@Composable
fun BrabantProvince() {
    SubdomainModelPage(
        modelId = brabantProvinceModel.modelId,
        introContent = {},
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeamMember.NAUD_LOOMANS)
        }
    )
}