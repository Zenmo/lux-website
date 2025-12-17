package energy.lux.site.frontend.domains.lux.sections.home.hero

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPlayArrow
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Video
import org.w3c.dom.HTMLVideoElement

@Composable
fun WhatIsLuxVideo() {
    Div(
        Modifier
            .padding(18.px)
            .fillMaxWidth()
            .luxBorderRadius(LuxCornerRadius.lg)
            .border(1.px, LineStyle.Solid, Colors.White.copyf(alpha = 0.1f))
            .background(Colors.Black.copyf(alpha = 0.25f))
            .toAttrs()
    ) {
        Box(
            WhatIsLuxVideoContainerStyle.toModifier(),
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
                        // todo use what is lux video
                        attr("src", "/lux/videos/lux_hero_movie.mp4")
                        attr("poster", "/lux/images/what_is_lux_poster.png")
                        attr("width", "100%")
                        attr("height", "100%")
                        if (isPlaying) {
                            attr("controls", "true")
                        }
                    })

            IconButton(
                onClick = {
                    videoRef?.play()
                    videoRef?.requestFullscreen()
                },
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
        }
    }
}