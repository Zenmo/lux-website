package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.elzenburgDeGeer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun ElzenburgDeGeer() {
    PrivateTwinModelPage(
        entryPoint = elzenburgDeGeer.entryPoint,
        imageUrl = elzenburgDeGeer.imageUrl,
        introContent = {
            HeaderText(
                enText = elzenburgDeGeer.label.en,
                nlText = elzenburgDeGeer.label.nl,
            )
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}