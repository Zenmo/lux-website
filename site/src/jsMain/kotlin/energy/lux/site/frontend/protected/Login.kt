package energy.lux.site.frontend.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import energy.lux.site.frontend.components.widgets.user.LoginIconButton
import energy.lux.site.frontend.core.services.auth.UserService
import energy.lux.site.frontend.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Login() {
    val userService = UserService()
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubHeaderText(
            enText = "Login to access",
            nlText = "Log in om toegang te krijgen",
            modifier = Modifier.margin(0.cssRem)
        )
        LoginIconButton(userService)
    }
}