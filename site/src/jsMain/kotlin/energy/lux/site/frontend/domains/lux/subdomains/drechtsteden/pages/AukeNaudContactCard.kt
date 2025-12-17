package energy.lux.site.frontend.domains.lux.subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.VerticalProfileContactCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem

// this pair seems to be used in multiple places, feels right to have it as a separate composable
@Composable
fun AukeNaudContactCard() {
    Column(
        modifier = Modifier.Companion.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderText(
            enText = "Contact and info", nlText = "Contact en info", modifier = Modifier.Companion.margin(0.cssRem)
        )
        SubHeaderText(
            enText = "Website and model development",
            nlText = "Website en model ontwikkeling",
            modifier = Modifier.Companion.margin(0.cssRem)
        )
        ZenmoInlineLink()
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
            modifier = Modifier.Companion.gap(4.cssRem).margin(topBottom = 3.cssRem)
        ) {
            VerticalProfileContactCard(
                name = ZenmoTeam.NAUD_LOOMANS.memberName,
                imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                email = ZenmoTeam.NAUD_LOOMANS.email,
                telephoneNumber = "+31 (6) 1524 9535",
            )

            VerticalProfileContactCard(
                name = ZenmoTeam.AUKE.memberName,
                imageUrl = ZenmoTeam.AUKE.image,
                email = ZenmoTeam.AUKE.email,
                telephoneNumber = "+31 (6) 5161 4294",
            )
        }
    }
}