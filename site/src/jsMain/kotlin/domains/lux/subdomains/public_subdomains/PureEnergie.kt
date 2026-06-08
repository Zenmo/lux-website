package energy.lux.frontend.domains.lux.subdomains.public_subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette


@Composable
fun PureEnergie() {
    val pureEnergie = PrivateSubdomainModel.PURE_ENERGIE
    LuxSubdomainPageLayout(
        title = pureEnergie.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = pureEnergie.entryPoint,
            imageUrl = pureEnergie.imageUrl,
            modelId = pureEnergie.modelId,
            introContent = {
                HeaderText(
                    enText = pureEnergie.label.en,
                    nlText = pureEnergie.label.nl,
                    textColor = SitePalette.light.primary,
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}