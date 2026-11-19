package energy.lux.frontend.domains.lux.sections.nav_header.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import energy.lux.frontend.components.SideMenuState
import energy.lux.frontend.core.models.MenuItem
import org.jetbrains.compose.web.css.px

@Composable
fun NarrowScreenHeaderComponents(menuItems: List<MenuItem>) {
    var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

    LuxHeaderComponent(
        modifier = Modifier.height(70.px).displayUntil(Breakpoint.MD),
    ) {
        MobileTopBar(
            onMenuClick = {
                menuState = when (menuState) {
                    SideMenuState.OPEN -> menuState.close()
                    else -> SideMenuState.OPEN
                }
            }, menuState = menuState
        )
    }

    if (menuState != SideMenuState.CLOSED) {
        SideMenu(
            menuItems = menuItems,
            menuState = menuState,
            close = { menuState = menuState.close() },
            onAnimationEnd = {
                if (menuState == SideMenuState.CLOSING)
                    menuState = SideMenuState.CLOSED
            }
        )
    }
}