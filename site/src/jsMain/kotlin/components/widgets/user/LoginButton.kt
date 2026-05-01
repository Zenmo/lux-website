package energy.lux.frontend.components.widgets.user

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogin
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import energy.lux.frontend.components.widgets.IconLink
import energy.lux.frontend.components.widgets.navbar_actions.NavBarActionsMenuItem
import energy.lux.frontend.core.services.auth.UserService
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

@Composable
fun LoginIconButton(userService: UserService, modifier: Modifier = Modifier) {
    IconLink(href = userService.loginUrl(), modifier = modifier) {
        MdiLogin(
            modifier = Modifier.position(Position.Relative).right(2.px)
        )
    }
}

@Composable
fun LoginButton(userService: UserService) {
    Link(
        path = userService.loginUrl(),
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
        modifier = Modifier.fillMaxWidth()
    ) {
        NavBarActionsMenuItem(
            title = LocalizedText(
                en = "Log In",
                nl = "Inloggen",
            ),
            onClick = {},
        ) {
            MdiLogin()
        }
    }
}