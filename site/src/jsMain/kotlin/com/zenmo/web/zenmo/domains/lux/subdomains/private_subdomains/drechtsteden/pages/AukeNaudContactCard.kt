package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.domains.lux.sections.responsiveGap
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileCardArrangementDirection
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun AukeNaudContactCard() {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier.responsiveGap()
    ) {
        ZenmoModellerProfileCard(
            ZenmoTeam.NAUD_LOOMANS,
            ProfileCardArrangementDirection.VERTICAL
        )
        ZenmoModellerProfileCard(
            ZenmoTeam.AUKE,
            ProfileCardArrangementDirection.VERTICAL
        )
    }
}