package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.domains.lux.styles.responsiveGap
import energy.lux.frontend.domains.lux.subdomains.components.ProfileCardArrangementDirection
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.core.models.ZenmoTeam

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