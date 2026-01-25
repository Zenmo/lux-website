package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun Kerkbuurt() {
    DrechtstedenTwinModelPage(
        twin = kerkbuurt,
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        }
    )
}