package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.hidden
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.components.widgets.navbar_actions.NavBarActionsMenuWidget
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.nav_header.LuxLogo
import energy.lux.frontend.domains.lux.sections.nav_header.components.LuxHeaderComponent
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.components.HeaderLogoStyle
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px

@Composable
private fun BrabantHeader(
    title: LocalizedText
) {
    LuxHeaderComponent {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            LuxLogo()

            SubHeaderText(
                enText = title.en,
                nlText = title.nl,
                modifier = Modifier
                    .displayIfAtLeast(Breakpoint.MD)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.gap(1.cssRem)
            ) {

                Image(
                    src = "/lux/logos/TUe-logo-scarlet-L-1.png",
                    alt = "TU/e",
                    modifier = Modifier.width(auto)
                        .height(30.px)
                        .displayIfAtLeast(Breakpoint.MD)
                )
                Image(
                    src = "/lux/logos/province_noord_brabant.jpg",
                    alt = "noord brabant logo",
                    modifier = HeaderLogoStyle.toModifier()
                        .width(180.px)
                        .height(30.px)
                        .displayIfAtLeast(Breakpoint.MD)
                )
                NavBarActionsMenuWidget()
            }
        }
    }
}

@Composable
fun BrabantLayout(
    title: LocalizedText,
    content: @Composable () -> Unit,
) {
    val language = LocalLanguage.current
    val titleText = language.translate(title.en, title.nl)
    PageLayout(
        header = { BrabantHeader(title) },
        footer = {},
        title = "Brabant - $titleText",
    ) {
        content()
    }
}