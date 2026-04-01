package energy.lux.frontend.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Video

@Composable
fun ClippedHeroVideoBackground() {
    Box(
        Modifier
            .fillMaxSize()
            .styleModifier {
                property(
                    "clip-path",
                    "polygon(70% 0%, 100% 0%, 100% 100%, 50% 100%)"
                )
            }
    ) {
        Video(
            attrs = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover)
                .pointerEvents(PointerEvents.None)
                .toAttrs {
                    ref {
                        it.muted = true
                        it.playbackRate = 0.75
                        onDispose {}
                    }
                    attr("src", "/lux/videos/lux_hero_movie.mp4")
                    attr("poster", "/lux/images/hero_poster.png")
                    attr("autoplay", "true")
                    attr("loop", "true")
                    attr("preload", "auto")
                }
        )
        Div(
            Modifier
                .fillMaxSize()
                .background(SitePalette.light.primary.toRgb().copyf(alpha = 0.25f))
                .toAttrs()
        )
    }
}