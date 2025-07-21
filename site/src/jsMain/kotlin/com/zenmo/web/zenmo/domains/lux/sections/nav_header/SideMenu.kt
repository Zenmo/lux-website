package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowForwardIos
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.SideMenuSlideInAnim
import com.zenmo.web.zenmo.components.SideMenuState
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul


val FrostedNavStyle = CssStyle.base {
    Modifier
        .styleModifier {
            property("-webkit-backdrop-filter", "saturate(150%) blur(12px)")
        }
        .backdropFilter(saturate(150.percent), blur(12.px))
}

val MobileNavStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .top(100.percent)
            .right(0.percent)
            .width(100.percent)
            .minHeight(100.percent)
            .zIndex(10)
            .display(DisplayStyle.Block)
            .background(SitePalette.light.surfaceContainerLow)
    }
}

@Composable
fun SideMenu(
    menuState: SideMenuState,
    close: () -> Unit,
    onAnimationEnd: () -> Unit,
    sectionInView: String,
) {
    key(menuState) {
        Nav(
            MobileNavStyle.toModifier()
                .then(FrostedNavStyle.toModifier())
                .animation(
                    SideMenuSlideInAnim.toAnimation(
                        duration = 200.ms,
                        timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                        direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                        fillMode = AnimationFillMode.Forwards
                    )
                )
                .onAnimationEnd { onAnimationEnd() }
                .onClick { it.stopPropagation() }
                .toAttrs()
        ) {
            Ul(
                Modifier
                    .display(DisplayStyle.Block)
                    .marginBlock {
                        start(1.cssRem)
                        end(1.cssRem)
                    }
                    .paddingInline {
                        start(40.px)
                        end(40.px)
                    }
                    .fillMaxWidth()
                    .toAttrs()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .gap(1.5.cssRem),
                    horizontalAlignment = Alignment.Start
                ) {
                    LuxSection.entries.forEach { section ->
                        val isActive = sectionInView == section.id
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .gap(1.5.cssRem),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MenuSectionItem(
                                href = section.href,
                                enTitle = section.title.en,
                                nlTitle = section.title.nl,
                                isActive = isActive,
                                modifier =
                                    TextStyle.toModifier(HolonLineTextStyle)
                                        .display(DisplayStyle.Block)
                                        .padding(topBottom = 16.px)
                                        .onClick { close() }
                            )
                            MdiArrowForwardIos(
                                modifier = Modifier
                                    .fontSize(fontSize = com.varabyte.kobweb.compose.css.FontSize.XLarge)
                            )
                        }
                    }
                }
            }
        }
    }
}