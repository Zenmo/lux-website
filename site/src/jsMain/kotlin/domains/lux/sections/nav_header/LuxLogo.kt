package energy.lux.frontend.domains.lux.sections.nav_header

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
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.pages.SiteGlobals
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.px

val LuxLogoImageVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier
            .display(DisplayStyle.Block)
            .boxSizing(BoxSizing.BorderBox)
    }

    Breakpoint.ZERO {
        Modifier
            .width(100.px)
            .height(40.px)
    }

    Breakpoint.SM {
        Modifier
            .width(100.px)
            .height(40.px)
    }

    Breakpoint.MD {
        Modifier
            .width(130.px)
            .height(50.px)
    }
    Breakpoint.LG {
        Modifier
            .width(180.px)
            .height(60.px)
    }

    Breakpoint.XL {
        Modifier
            .width(180.px)
            .height(60.px)
    }
}

@Composable
fun LuxLogo(
    domain: String = SiteGlobals.LUX_DOMAIN
) {
    Link(
        path = localizedUrl(domain, "/"),
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE
    ) {
        Image(src = "/lux/logos/lux-energy-twin.png", variant = LuxLogoImageVariant)
    }
}
