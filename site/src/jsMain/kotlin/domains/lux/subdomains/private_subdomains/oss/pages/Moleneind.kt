package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.moleneind
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun Moleneind() {
    PrivateTwinModelPage(
        entryPoint = moleneind.entryPoint,
        imageUrl = moleneind.imageUrl,
        modelId = moleneind.modelId,
        introContent = {
            HeaderText(
                enText = moleneind.label.en,
                nlText = moleneind.label.nl,
            )
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}