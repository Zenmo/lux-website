package energy.lux.frontend.components.widgets.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogout
import energy.lux.frontend.components.widgets.navbar_actions.NavBarActionsMenuItem
import energy.lux.frontend.core.services.auth.UserService
import energy.lux.frontend.core.services.localization.LocalizedText
import kotlinx.coroutines.launch

@Composable
fun LogoutButton(
    userService: UserService,
    onLogout: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    NavBarActionsMenuItem(
        title = LocalizedText(
            en = "Log Out",
            nl = "Uitloggen",
        ),
        onClick = {
            coroutineScope.launch {
                userService.logout()
                onLogout()
            }
        },
    ) {
        MdiLogout()
    }
}
