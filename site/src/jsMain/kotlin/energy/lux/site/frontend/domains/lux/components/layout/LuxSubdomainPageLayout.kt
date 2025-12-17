package energy.lux.site.frontend.domains.lux.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.navbar_actions.NavBarActionsMenuWidget
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxLogo
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.LuxHeaderComponent
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem


val LayoutHeaderStyle = CssStyle {
    base {
        Modifier
            .padding(3.5.cssRem)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .gap(1.cssRem)
    }
    Breakpoint.ZERO {
        Modifier
            .padding(1.5.cssRem, 2.cssRem)
    }
    Breakpoint.SM {
        Modifier
            .padding(1.5.cssRem, 2.cssRem)
    }
}


@Composable
fun LuxSubdomainPageLayout(
    title: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    PageLayout(
        header = {
            LayoutHeader(title = title)
        },
        footer = {},
        title = title
    ) {
        content()
    }
}

@Composable
private fun LayoutHeader(
    title: String,
) {
    LuxHeaderComponent {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            LuxLogo()

            SubHeaderText(
                enText = title,
                nlText = title,
                modifier = Modifier
                    .margin(0.cssRem)
                    .displayIfAtLeast(Breakpoint.MD)
            )

            NavBarActionsMenuWidget()
        }
    }
}