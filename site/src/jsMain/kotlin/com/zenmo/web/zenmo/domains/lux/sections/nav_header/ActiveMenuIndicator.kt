package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.navigation.asNavLinkPath
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLElement

val ActiveIndicatorWidthStyleVar by StyleVariable<CSSLengthOrPercentageNumericValue>()
val ActiveIndicatorLeftStyleVar by StyleVariable<CSSLengthOrPercentageNumericValue>()

val LuxActiveMenuIndicatorStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .width(ActiveIndicatorWidthStyleVar.value())
            .height(3.px)
            .backgroundColor(SitePalette.light.primary)
            .borderRadius(1.px)
            .left(ActiveIndicatorLeftStyleVar.value())
            .bottom(0.px)
            .boxSizing(BoxSizing.BorderBox)
    }
    before {
        Modifier
            .content("")
            .height(60.px)
            .width(200.percent)
            .background(
                Background.of(
                    image = radialGradient(RadialGradient.Shape.Ellipse, CSSPosition.Bottom) {
                        add(SitePalette.light.primary, 10.percent)
                        add(Colors.Transparent, 60.percent)
                    }.toImage(),
                    repeat = BackgroundRepeat.NoRepeat,
                    position = BackgroundPosition.of(CSSPosition.Bottom)
                )
            )
            .display(DisplayStyle.Block)
            .position(Position.Absolute)
            .bottom(100.percent)
            .left((-50).percent)
            .opacity(0.1)
    }
}

@Composable
fun ActiveMenuIndicator(
    items: List<MenuItem>,
) {
    var indicatorWidth by remember { mutableStateOf(0.px) }
    var indicatorLeft by remember { mutableStateOf(0.px) }

    val activeItem = items.first { item ->
        when (item) {
            is MenuItem.Simple -> isPathActive(item.getPath)
            is MenuItem.WithSubs -> item.subItems.any { sub ->
                isPathActive(href = sub.en.asNavLinkPath(item.title.en))
            }
        }
    }

    val updateIndicatorPosition = {

        val element = document.getElementById(
            when (activeItem) {
                is MenuItem.Simple -> activeItem.title.en.lowercase()
                is MenuItem.WithSubs -> activeItem.title.en.lowercase()
            }
        ) as HTMLElement

        val elementRect = element.getBoundingClientRect()
        indicatorWidth = elementRect.width.px
        indicatorLeft = elementRect.left.px
    }

    LaunchedEffect(activeItem) {
        updateIndicatorPosition()
    }

    DisposableEffect(Unit) {
        val resizeListener: (dynamic) -> Unit = { updateIndicatorPosition() }
        window.onresize = resizeListener

        onDispose {
            window.onresize = null
        }
    }

    Span(
        attrs = LuxActiveMenuIndicatorStyle.toModifier()
            .setVariable(ActiveIndicatorWidthStyleVar, indicatorWidth)
            .setVariable(ActiveIndicatorLeftStyleVar, indicatorLeft).toAttrs()
    )
}