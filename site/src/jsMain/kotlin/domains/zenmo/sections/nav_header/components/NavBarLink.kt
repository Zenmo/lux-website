package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignContent
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import web.window.window

val NavBarLinkVariant = LinkStyle.addVariant(
    extraModifier = { TextStyle.toModifier(LabelTextStyle) }
) {
    base {
        Modifier
            .fontWeight(FontWeight.Medium)
            .alignContent(AlignContent.Center)
            .color(SitePalette.light.onBackground)
            .borderRadius(50.px)
            .padding(leftRight = 1.em, topBottom = 0.5.em)
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of("0.2s"))
    }
    hover {
        Modifier.background(SitePalette.light.overlay.shifted(colorMode, 0.1f))
    }
}

val ActiveNavBarLinkVariant = CssStyle {
    base {
        Modifier
            .color(SitePalette.light.onPrimary)
            .background(SitePalette.light.primary)
            .transition(Transition.of("0.1s"))
    }
    hover {
        Modifier.background(SitePalette.light.primary)
    }

}

@Composable
fun NavBarLink(
    href: String,
    label: LocalizedText,
    modifier: Modifier = Modifier,
    isActive: Boolean,
) {
    Link(
        path = href,
        variant = NavBarLinkVariant,
        modifier = Modifier
            .thenIf(isActive, ActiveNavBarLinkVariant.toModifier())
            .then(modifier)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LangText(en = label.en, nl = label.nl)
        }
    }
}

fun isPathActive(href: String): Boolean {
    val path = window.location.pathname
    return path == href || (href != "/" && path.startsWith(href))
}