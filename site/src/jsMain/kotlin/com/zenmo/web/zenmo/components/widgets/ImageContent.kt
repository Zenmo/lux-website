package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.functions.max
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.extendedBy
import com.zenmo.web.zenmo.theme.isZenmoDomain
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val ImageContentStyleVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier
            .borderRadius(30.px)
            .thenIf(
                !isZenmoDomain,
                Modifier.luxBorderRadius(LuxCornerRadius.xl)
            )
            .objectFit(ObjectFit.Cover)
            // ensures the image is at least 425px tall, but can grow to
            // fill 50% of the viewport height
            .height(
                max(
                    50.vh,
                    425.px
                )
            )
    }
}

@Composable
fun ImageContent(
    imageUrl: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    alt: String = "Image content"
) {
    Image(
        src = imageUrl,
        variant = ImageContentStyleVariant,
        modifier = modifier,
        alt = alt
    )
}