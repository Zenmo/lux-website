package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.core.MenuFactory
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.domains.zenmo.widgets.MenuItemWithSubs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Nav


val NavBarStyle = CssStyle {
    base {
        Modifier
            .size(autoLength)
            .listStyle(ListStyleType.None)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .gap(12.px)
            .flex(1)
    }
}

@Composable
fun NavBar(
    modifier: Modifier = NavBarStyle.toModifier(),
) {
    Nav(
        attrs = modifier.toAttrs()
    ) {
        MenuFactory.menuItems().forEach { item ->
            when (item) {
                is MenuItem.Simple -> {
                    NavBarLink(
                        href = item.route.url,
                        label = item.route.label,
                        isActive = isPathActive(href = item.route.url),
                    )
                }

                is MenuItem.WithSubs -> MenuItemWithSubs(item)
            }
        }
    }
}