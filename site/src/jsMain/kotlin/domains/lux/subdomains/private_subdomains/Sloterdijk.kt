package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette


@Composable
fun Sloterdijk() {
    val sloterdijk = PrivateSubdomainModel.SLOTERDIJK
    LuxSubdomainPageLayout(
        title = sloterdijk.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = sloterdijk.entryPoint,
            modelId = sloterdijk.modelId,
            imageUrl = "/lux/images/models/sloterdijk.png",
            introContent = {
                HeaderText(
                    enText = sloterdijk.label.en,
                    nlText = sloterdijk.label.nl,
                    textColor = SitePalette.light.primary,
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}