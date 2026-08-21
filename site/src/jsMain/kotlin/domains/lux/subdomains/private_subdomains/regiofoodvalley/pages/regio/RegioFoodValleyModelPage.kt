package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.regio

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.ZenmoTeamMember
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.RegioFoodValleyTwinModel
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText

@Composable
fun RegioFoodValleyModelPage(
    twin: RegioFoodValleyTwinModel,
    websiteModeller: ZenmoTeamMember = ZenmoTeamMember.NAUD_LOOMANS,
    introContent: @Composable () -> Unit = {
        HeaderText(text = twin.label)
    },
    mediaContent: @Composable () -> Unit = {},
) = PrivateTwinModelPage(
    entryPoint = twin.entryPoint,
    modelId = twin.modelId,
    imageUrl = twin.imageUrl,
    introContent = introContent,
    mediaContent = mediaContent,
    footerContent = { ZenmoModellerProfileCard(websiteModeller) },
)