package energy.lux.frontend.domains.zenmo.pages.home.projects

import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val ProjectCardImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(260.px)
            .background(SitePalette.light.overlay)
            .borderRadius(14.px)
            .objectFit(ObjectFit.Cover)
            .overflow(Overflow.Clip)
    }
}

val ProjectCategoryBadgeStyle = CssStyle(extraModifier = {
    TextStyle.toModifier(LabelTextStyle)
}) {
    base {
        Modifier
            .padding(leftRight = 0.75.cssRem, topBottom = 0.25.cssRem)
            .borderRadius(50.px)
            .backgroundColor(SitePalette.light.primary)
            .color(SitePalette.light.onPrimary)
    }
}