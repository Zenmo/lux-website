package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.BusinessParkModelPageText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun Dordrecht() {
    DrechtstedenTwinModelPage(
        twin = dordrecht,
        introContent = { BusinessParkModelPageText() },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}