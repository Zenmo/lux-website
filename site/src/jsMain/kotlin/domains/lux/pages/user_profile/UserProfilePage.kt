package energy.lux.frontend.domains.lux.pages.user_profile

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiCopy
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.user.LoginIconButton
import energy.lux.frontend.core.services.auth.UserService
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.sections.DeEmphasizedTextStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.widgets.button.IconButton
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.luxBorderRadius
import energy.lux.site.shared.UserInfo
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import web.navigator.navigator


@Composable
fun UserProfilePage() {
    val userService = UserService()
    val scope = rememberCoroutineScope()
    var userInfo by remember { mutableStateOf<UserInfo?>(null) }
    var userIdToken by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(Unit) {
        userInfo = userService.userInfo()
    }
    LuxSectionContainer(
        modifier = Modifier
            .gap(1.cssRem)
    ) {
        if (userInfo == null) {
            LoginPrompt(userService)
        }

        userInfo?.let { user ->
            Box(
                Modifier
                    .size(18.cssRem)
                    .minSize(15.cssRem)
                    .clip(Circle())
                    .background(SitePalette.light.overlay)
                    .color(SitePalette.light.primary),
                contentAlignment = Alignment.Center,
            ) {
                HeaderText(
                    enText = user.iconLetters(),
                    nlText = user.iconLetters(),
                    textColor = SitePalette.light.primary,
                )
            }

            val userName = user.name ?: user.preferred_username
            SubHeaderText(
                enText = userName,
                nlText = userName,
                textColor = SitePalette.light.primary,
                fontWeight = FontWeight.Bold
            )
            user.email?.let {
                SpanText(it, modifier = DeEmphasizedTextStyle.toModifier())
            }

            if (userIdToken != null) {
                UserIDTokenCard(
                    token = userIdToken!!,
                    copyToken = {
                        scope.launch {
                            navigator.clipboard.writeText(userIdToken!!)
                            window.alert("ID token copied to clipboard")
                            userIdToken = null
                        }
                    }
                )
            } else {
                MyIdTokenButton(
                    enabled = userIdToken == null,
                    onClick = {
                        scope.launch {
                            userIdToken = userService.userIdToken()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun LoginPrompt(
    userService: UserService
) {
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            enText = "Log In",
            nlText = "Inloggen",
        )
        LangText(
            en = "Log in to see your profile.",
            nl = "Log in om je profiel te bekijken.",
        )
        LoginIconButton(
            userService = userService,
            modifier = Modifier.background(SitePalette.light.primary)
                .color(Colors.White)
        )
    }
}


@Composable
private fun MyIdTokenButton(
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    PrimaryButton(
        modifier = Modifier,
        enText = "My ID token",
        nlText = "Mijn ID-token",
        onClick = { onClick() },
        enabled = enabled
    )
}


@Composable
fun UserIDTokenCard(
    copyToken: () -> Unit,
    token: String,
) {
    Box(
        Modifier.fillMaxWidth()
            .background(SitePalette.light.overlay)
            .color(SitePalette.light.primary)
            .luxBorderRadius(),
        contentAlignment = Alignment.Center
    ) {
        Pre(
            Modifier
                .padding(1.cssRem)
                .styleModifier {
                    property("word-break", "break-all")
                    property("word-wrap", "break-word")
                    property("white-space", "pre-wrap")
                }
                .toAttrs()
        ) {
            Text(token)
        }
        IconButton(
            onClick = copyToken,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            MdiCopy()
        }
    }
}
