package energy.lux.frontend.components.widgets.navbar_actions

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMoreHoriz
import com.varabyte.kobweb.silk.style.animation.toAnimation
import energy.lux.frontend.components.widgets.user.UserMenu
import energy.lux.frontend.core.services.auth.UserService
import energy.lux.frontend.domains.lux.sections.nav_header.components.SubMenuAppearanceAnimKeyFrames
import energy.lux.frontend.domains.zenmo.widgets.button.IconButton
import energy.lux.site.shared.UserInfo
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import org.w3c.dom.HTMLElement


@Composable
fun NavBarActionsMenuWidget() {
    val userService = UserService()
    var userInfo by remember { mutableStateOf<UserInfo?>(null) }
    var showDropdown by remember { mutableStateOf(false) }
    var backingElement by remember { mutableStateOf<HTMLElement?>(null) }

    LaunchedEffect(Unit) {
        document.body?.onclick = { event ->
            val isClickInMenu = backingElement?.contains(event.target as HTMLElement) ?: false

            if (!isClickInMenu) {
                showDropdown = false
            }
        }
        userInfo = userService.userInfo()
    }

    Column(
        ref = ref { backingElement = it },
        modifier = Modifier.position(Position.Relative)
    ) {
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


