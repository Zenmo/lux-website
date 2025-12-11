package com.zenmo.web.zenmo.components.widgets.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogout
import com.zenmo.web.zenmo.components.widgets.navbar_actions.NavBarActionsMenuItem
import com.zenmo.web.zenmo.core.services.auth.UserService
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
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
