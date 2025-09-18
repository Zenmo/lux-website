package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.VideoContentStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Video

@Composable
fun LuxVideo(
    src: String = "/lux/videos/hero_vid.mp4",
) {
    Box(
        VideoContentStyle.toModifier()
    ) {
        Video(
            attrs = Modifier.Companion
                .borderRadius(24.px)
                .objectFit(ObjectFit.Companion.Cover)
                .aspectRatio(2, 1)
                .attrsModifier {
                    attr("src", src)
                    attr("controls", "true")
                    attr("width", "100%")
                    attr("height", "100%")
                    attr("autoPlay", "false")
                }.toAttrs()
        )
    }
}