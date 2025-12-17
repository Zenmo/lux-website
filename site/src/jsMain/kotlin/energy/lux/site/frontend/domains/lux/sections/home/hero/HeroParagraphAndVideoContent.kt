package energy.lux.site.frontend.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div

@OptIn(DelicateApi::class)
@Composable
fun HeroParagraphAndVideoContent(
    breakpoint: Breakpoint
) {
    Div(
        ResponsiveRowStyle
            .toModifier()
            .color(Colors.White)
            .gap(1.5.cssRem)
            .thenIf(breakpoint >= Breakpoint.MD, Modifier.margin(top = 1.5.cssRem))
            .thenIf(breakpoint >= Breakpoint.LG, Modifier.padding(leftRight = 4.cssRem))
            .toAttrs(),
    ) {
        WhatIsLuxText(breakpoint)
        WhatIsLuxVideo()
    }
}