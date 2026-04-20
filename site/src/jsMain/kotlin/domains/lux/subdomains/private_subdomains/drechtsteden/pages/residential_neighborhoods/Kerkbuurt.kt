package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_neighborhoods

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.ResidentialAreaModelPageText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun Kerkbuurt() {
    DrechtstedenTwinModelPage(
        twin = kerkbuurt,
        introContent = { ResidentialAreaModelPageText() },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        }
    )
}