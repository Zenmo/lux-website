package com.zenmo.web.zenmo.components.widgets.user

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextOverflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.navbar_actions.SiteLanguageButton
import com.zenmo.web.zenmo.core.services.auth.UserService
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import energy.lux.site.shared.UserInfo
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Text

/**
 * Entry point to log in, log out, register and change profile.
 *
 */
@Composable
fun UserMenu(
    userService: UserService,
    userInfo: UserInfo?,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier.Companion
            .position(Position.Companion.Relative)
            .width(16.cssRem)
            .background(SitePalette.Companion.light.background)
            .overflow(Overflow.Companion.Hidden)
            .top(10.px)
            .luxBorderRadius(LuxCornerRadius.lg)
            .border(
                width = 0.3.px,
                style = LineStyle.Solid,
                color = Colors.LightGrey
            )
            .zIndex(20),
    ) {
        if (userInfo != null) {
            UserInfo(userInfo = userInfo)
        } else {
            LoginButton(userService)
        }

        SiteLanguageButton()

        if (userInfo != null) LogoutButton(userService = userService, onLogout)
    }
}


@Composable
private fun UserInfo(userInfo: UserInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(0.75.cssRem),
        modifier = Modifier.Companion.fillMaxWidth()
            .padding(1.25.cssRem)
            .borderBottom(0.75.px, LineStyle.Companion.Solid, Colors.LightGrey)
    ) {
        Box(
            modifier = Modifier.Companion
                .padding(1.cssRem, 1.5.cssRem)
                .luxBorderRadius()
                .background(SitePalette.Companion.light.overlay)
                .color(SitePalette.Companion.light.primary),
            contentAlignment = Alignment.Center,
        ) {
            B { Text(userInfo.iconLetters()) }
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.Companion.fillMaxWidth().textOverflow(TextOverflow.Companion.Ellipsis)
        ) {
            B { SpanText(userInfo.name ?: "Unknown", modifier = TextStyle.toModifier()) }
            SpanText(userInfo.email ?: "No email", modifier = DeEmphasizedTextStyle.toModifier().fontSize(1.cssRem))
        }
    }
}


