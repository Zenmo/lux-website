package energy.lux.site.frontend.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.px

val LuxLogoImageVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier.Companion
            .display(DisplayStyle.Companion.Block)
            .boxSizing(BoxSizing.Companion.BorderBox)
    }

    Breakpoint.ZERO {
        Modifier.Companion
            .width(100.px)
            .height(40.px)
    }

    Breakpoint.SM {
        Modifier.Companion
            .width(100.px)
            .height(40.px)
    }

    Breakpoint.MD {
        Modifier.Companion
            .width(130.px)
            .height(50.px)
    }
    Breakpoint.LG {
        Modifier.Companion
            .width(180.px)
            .height(60.px)
    }

    Breakpoint.XL {
        Modifier.Companion
            .width(180.px)
            .height(60.px)
    }
}

@Composable
fun LuxLogo(
    domain: String = SiteGlobals.LUX_DOMAIN
) {
    val location = window.location
    val sameOrigin = location.hostname == domain

    Link(
        path = if (sameOrigin) "/" else "${location.protocol}//$domain",
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE
    ) {
        Image(src = "/lux/logos/lux-energy-twin.png", variant = LuxLogoImageVariant)
    }
}