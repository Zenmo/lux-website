package energy.lux.frontend.domains.zenmo.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiExpandMore
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.domains.lux.sections.nav_header.components.SubMenuAppearanceAnimKeyFrames
import energy.lux.frontend.domains.lux.styles.LuxSubMenuItemParentHoverStyle
import energy.lux.frontend.domains.lux.styles.SubmenuContainerStyle
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.AnimatedIconStyle
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.NavBarLink
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.isPathActive
import energy.lux.frontend.theme.styles.DropdownContentStyle
import energy.lux.frontend.theme.styles.DropdownTriggerStyle
import energy.lux.frontend.theme.styles.IconStyle
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div


@Composable
fun MenuItemWithSubs(
    menu: MenuItem.WithSubs,
) {
    val isMenuActive = menu.subItems.any { isPathActive(href = it.route.url) }
    Box(
        modifier = DropdownTriggerStyle.toModifier()
            .then(LuxSubMenuItemParentHoverStyle.toModifier())
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NavBarLink(
                href = "",
                label = menu.title,
                isActive = isMenuActive,
            )
            MdiExpandMore(
                modifier = IconStyle.toModifier()
                    .then(AnimatedIconStyle.toModifier())
            )
        }

        Div(
            SubmenuContainerStyle.toModifier()
                .right(0.percent)
                .animation(
                    SubMenuAppearanceAnimKeyFrames.toAnimation(
                        duration = 200.ms,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                )
                .toAttrs()
        ) {
            Column(
                modifier = DropdownContentStyle.toModifier()
                    .width(150.px)
            ) {
                menu.subItems.forEach { sub ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        NavBarLink(
                            href = sub.route.url,
                            label = sub.route.label,
                            isActive = isPathActive(href = sub.route.url),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}