package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.navbar_actions.NavBarActionsMenuWidget
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.LuxHeaderComponent
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.GeniusPartners
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

val HeaderLogoStyle = CssStyle {
    base {
        Modifier
            .width(80.px)
            .height(40.px)
    }
}

@Composable
fun GeniusHeader() {
    LuxHeaderComponent {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Div {
                Image(
                    src = "/lux/logos/genius/logo_genius.png",
                    alt = "genius logo",
                    modifier = Modifier.width(160.px).height(80.px)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.gap(1.cssRem)
            ) {
                Row(
                    modifier = Modifier.gap(1.cssRem)
                        .displayIfAtLeast(Breakpoint.MD),
                ) {
                    Image(
                        src = GeniusPartners.ZENMO.logoUrl,
                        alt = "zenmo logo",
                        modifier = HeaderLogoStyle.toModifier()
                    )

                    Image(
                        src = "/lux/logos/TUe-logo-scarlet-L-1.png",
                        alt = "TU/e",
                        modifier = HeaderLogoStyle.toModifier()
                    )
                }
                NavBarActionsMenuWidget()
            }
        }
    }
}