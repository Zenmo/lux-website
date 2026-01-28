package com.zenmo.web.zenmo.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Video


@Composable
fun LuxHero(
    breakpoint: Breakpoint
) {
    Box(
        Modifier
            .fillMaxWidth()
            .position(Position.Relative)
            .height(100.vh),
        contentAlignment = Alignment.Center
    ) {
        Video(
            attrs = Modifier
                .objectFit(ObjectFit.Cover)
                .display(DisplayStyle.Block)
                .role("none")
                .fillMaxSize()
                .toAttrs {
                    ref {
                        // muted doesn't work when set via attr()
                        it.muted = true
                        it.playbackRate = 0.75

                        onDispose {}
                    }
                    attr("src", "/lux/videos/lux_hero_movie.mp4")
                    attr("poster", "/lux/images/hero_poster.png")
                    attr("autoplay", "true")
                    attr("loop", "true")
                    attr("preload", "auto")
                    attr("width", "100%")
                    attr("height", "100%")
                })

        Div(
            Modifier.fillMaxSize()
                .background(Colors.Black.copyf(alpha = 0.7f))
                .toAttrs()
        )

        SectionContainer(
            variant = LuxSectionContainerStyleVariant,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.gap(0.cssRem) // ignore LuxSectionContainerStyleVariant gap
        ) {
            TitleWithTagline()
            HeroParagraphAndVideoContent(breakpoint)
        }
    }
}


@Composable
private fun TitleWithTagline() {
    Column(
        modifier = Modifier.color(Colors.White)
            .textAlign(TextAlign.Center)
            .gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeaderText(
            enText = "LUX Energy Twin",
            nlText = "LUX Energy Twin",
        )
        SubHeaderText(
            enText = "Local power, global impact!",
            nlText = "Lokale energie, wereldwijde impact!",
        )
    }
}

