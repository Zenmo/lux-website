package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.navbar_actions.NavBarActionsMenuWidget
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.NarrowScreenHeaderComponents
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.WideScreenHeaderComponents
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px


val HeaderInnerStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.SpaceBetween)
            .alignItems(AlignItems.Center)
            .margin(0.px, autoLength)
            .position(Position.Relative)
            .zIndex(5)
    }
}


@OptIn(DelicateApi::class)
@Composable
fun LuxHeader() {
    WideScreenHeaderComponents {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth(),
        ) {
            LuxLogo()
            NavBar()
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.gap(1.cssRem)
            ) {
                if (window.location.host == SiteGlobals.LUX_DOMAIN) {
                    BookADemoButton()
                }
                NavBarActionsMenuWidget()
            }
        }
    }
    NarrowScreenHeaderComponents()
}
