package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A

val LuxLogoImageVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier.Companion
            .display(DisplayStyle.Companion.Block)
            .boxSizing(BoxSizing.Companion.BorderBox)
    }

    Breakpoint.ZERO {
        Modifier.Companion
            .width(120.px)
            .height(50.px)
    }

    Breakpoint.SM {
        Modifier.Companion
            .width(120.px)
            .height(50.px)
    }

    Breakpoint.MD {
        Modifier.Companion
            .width(150.px)
            .height(60.px)
    }
    Breakpoint.LG {
        Modifier.Companion
            .width(200.px)
            .height(80.px)
    }

    Breakpoint.XL {
        Modifier.Companion
            .width(200.px)
            .height(80.px)
    }
}

@Composable
fun LuxLogo(
    asLink: Boolean = false,
    domain: String = SiteGlobals.LUX_DOMAIN
) {
    val protocol = window.location.protocol
    A(
        href = if (asLink) "$protocol//$domain" else null,
        attrs = Modifier.Companion
            .cursor(
                if (asLink) Cursor.Companion.Pointer
                else Cursor.Companion.Default
            )
            .toAttrs()

    ) {
        Image(src = "/lux/logos/lux-energy-twin.png", variant = LuxLogoImageVariant)
    }
}