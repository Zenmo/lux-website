package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.SideMenuSlideInAnim
import energy.lux.frontend.components.SideMenuState
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.MenuFactory
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.domains.lux.components.HorizontalLine
import energy.lux.frontend.domains.lux.styles.DeEmphasizedTextStyle
import energy.lux.frontend.domains.zenmo.sections.nav_header.ZenmoLanguageToggleButton
import energy.lux.frontend.domains.zenmo.widgets.button.IconButton
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span


@Composable
fun SideMenu(
    menuState: SideMenuState,
    close: () -> Unit,
    onAnimationEnd: () -> Unit,
) {
    Overlay(
        modifier = Modifier
            .zIndex(2)
            .setVariable(OverlayVars.BackgroundColor, Colors.Transparent)
            .onClick { close() },
    ) {
        key(menuState) {
            Column(
                SideMenuStyle.toModifier()
                    .align(Alignment.CenterEnd)
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .onAnimationEnd { onAnimationEnd() }
                    .onClick { it.stopPropagation() },
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ZenmoLanguageToggleButton()
                    IconButton(
                        modifier = Modifier
                            .background(Colors.Transparent)
                            .color(Colors.Black),
                        onClick = { close() }
                    ) {
                        CloseIcon()
                    }
                }
                HorizontalLine(
                    modifier = Modifier.margin(0.px)
                )
                NavItems(close = { close() })
                Box(modifier = Modifier.fillMaxWidth().flexGrow(1))
                Row {
                    SiteLogo()
                }
            }
        }
    }
}

@Composable
private fun NavItems(
    close: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(1.cssRem),
        horizontalAlignment = Alignment.Start
    ) {
        Span(
            TextStyle.toModifier(LabelTextStyle)
                .then(DeEmphasizedTextStyle.toModifier())
                .fontWeight(FontWeight.Bold)
                .letterSpacing(0.07.cssRem)
                .textTransform(TextTransform.Uppercase)
                .toAttrs()
        ) {
            LangText(
                nl = "Navigatie",
                en = "Navigation"
            )
        }
        MenuFactory.menuItems().forEach { item ->
            when (item) {
                is MenuItem.Simple -> {
                    SideMenuNavLink(
                        href = item.route.url,
                        label = item.route.label,
                        isActive = isPathActive(href = item.route.url),
                        onClick = { close() }
                    )
                }

                is MenuItem.WithSubs -> {
                    item.subItems.forEach { subItem ->
                        SideMenuNavLink(
                            href = subItem.route.url,
                            label = subItem.route.label,
                            isActive = isPathActive(href = subItem.route.url),
                            onClick = { close() }
                        )
                    }
                }
            }
        }
    }
}