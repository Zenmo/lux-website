package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.vorstenGrafDonk
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.core.models.ZenmoTeamMember


@Composable
fun VorstenGrafDonk() {
    PrivateTwinModelPage(
        entryPoint = vorstenGrafDonk.entryPoint,
        imageUrl = vorstenGrafDonk.imageUrl,
        modelId = vorstenGrafDonk.modelId,
        introContent = {
            HeaderText(
                enText = vorstenGrafDonk.label.en,
                nlText = vorstenGrafDonk.label.nl,
            )
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeamMember.ATE)
        }
    )
}