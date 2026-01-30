package com.zenmo.web.zenmo.domains.lux.sections.application_fields.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPlayArrow
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Video
import org.w3c.dom.HTMLVideoElement

val ApplicationAreaVideoContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .luxBorderRadius(LuxCornerRadius.xl)
            .overflow(Overflow.Clip)
    }

    Breakpoint.ZERO {
        Modifier.height(300.px)
    }
    Breakpoint.SM {
        Modifier
            .height(300.px)
    }
    Breakpoint.MD {
        Modifier
            .height(350.px)
    }
    Breakpoint.LG {
        Modifier
            .height(500.px)
    }
    Breakpoint.XL {
        Modifier
            .height(720.px)
    }
}


@Composable
fun ApplicationAreaVideo(
    src: String = "/lux/videos/lux_hero_movie.mp4",
    poster: String = "/lux/images/hero_poster.png",
    videoTitle: LocalizedText,
    videoCaption: LocalizedText = LocalizedText(
        en = "Demo Video",
        nl = "Demo Video"
    ),
) {
    Box(
        modifier = ApplicationAreaVideoContainerStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        var videoRef by remember { mutableStateOf<HTMLVideoElement?>(null) }
        var isPlaying by remember { mutableStateOf(false) }

        Video(
            attrs = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover)
                .toAttrs {
                    ref {
                        videoRef = it
                        it.onplay = {
                            isPlaying = true
                        }
                        it.onended = {
                            isPlaying = false
                        }

                        onDispose {
                            videoRef = null
                            isPlaying = false
                        }
                    }
                    attr("src", src)
                    attr("poster", poster)
                    attr("width", "100%")
                    attr("height", "100%")
                    if (isPlaying) {
                        attr("controls", "true")
                    }
                })

        IconButton(
            onClick = { videoRef?.play() },
            modifier = Modifier.background(Colors.White)
                .transform { scale(1.1f) }
                .thenIf(
                    isPlaying,
                    Modifier.display(DisplayStyle.None),
                )
        ) {
            MdiPlayArrow(
                modifier = Modifier
                    .color(SitePalette.light.primary)
            )
        }

        if (!isPlaying) {
            VideoOverlay(
                videoTitle = videoTitle,
                videoCaption = videoCaption,
            )
        }
    }
}


@Composable
private fun VideoOverlay(
    videoTitle: LocalizedText,
    videoCaption: LocalizedText,
) {
    Box(
        Modifier.fillMaxSize()
            .background(Colors.Black.copyf(alpha = 0.5f)),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.padding(32.px)
                .gap(1.cssRem)
                .color(Colors.White)
        ) {
            Span {
                LangText(
                    en = videoCaption.en,
                    nl = videoCaption.nl,
                )
            }
            SubHeaderText(
                enText = videoTitle.en,
                nlText = videoTitle.nl,
                modifier = Modifier.margin(0.cssRem)
            )
        }
    }
}
