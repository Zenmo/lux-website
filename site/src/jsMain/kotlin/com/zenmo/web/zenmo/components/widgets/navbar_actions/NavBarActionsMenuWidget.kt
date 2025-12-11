package com.zenmo.web.zenmo.components.widgets.navbar_actions

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMoreHoriz
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.zenmo.web.zenmo.components.widgets.user.UserMenu
import com.zenmo.web.zenmo.core.services.auth.UserService
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.SubMenuAppearanceAnimKeyFrames
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import energy.lux.site.shared.UserInfo
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*


@Composable
fun NavBarActionsMenuWidget() {
    val userService = UserService()
    var userInfo by remember { mutableStateOf<UserInfo?>(null) }
    var showDropdown by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        document.body?.onclick = {
            showDropdown = false
        }
        userInfo = userService.userInfo()
    }


    Column(modifier = Modifier.position(Position.Relative)) {
        NavBarActionsMenuButton(onClick = { showDropdown = !showDropdown })
        if (showDropdown) {
            Box(
                modifier = Modifier.position(Position.Absolute)
                    .top(100.percent).right(0.px)
                    .width(300.px)
                    .animation(
                        SubMenuAppearanceAnimKeyFrames.toAnimation(
                            duration = 200.ms,
                            timingFunction = AnimationTimingFunction.EaseInOut
                        )
                    )
            ) {
                UserMenu(
                    userService = userService,
                    userInfo = userInfo,
                    onLogout = { userInfo = null })
            }
        }
    }
}

@Composable
private fun NavBarActionsMenuButton(onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = Modifier.width(2.cssRem)) {
        MdiMoreHoriz()
    }
}


