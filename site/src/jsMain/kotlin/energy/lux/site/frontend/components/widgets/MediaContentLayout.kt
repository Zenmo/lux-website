package energy.lux.site.frontend.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.functions.max
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh


@Composable
fun MediaContentLayout(
    imageUrl: String,
    imageModifier: Modifier = Modifier,
    keepImageAsIs: Boolean = false,
    visualContent: @Composable () -> Unit = {
        ImageContent(
            imageUrl = imageUrl,
            keepImageAsIs = keepImageAsIs,
            modifier = imageModifier
                .fillMaxWidth()
                .thenIf(keepImageAsIs, Modifier.objectFit(ObjectFit.Contain))
        )
    },
    title: @Composable (() -> Unit)? = null,
    description: @Composable () -> Unit = {},
    subtitle: @Composable () -> Unit = {},
    actionText: @Composable () -> Unit = {},
    reversed: Boolean = false,
) {
    SimpleGrid(
        numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier
            .gap(max(2.cssRem, 5.cssRem))
    ) {
        when (reversed) {
            true -> {
                TextContent(
                    title = title,
                    description = description,
                    subtitle = subtitle,
                    actionText = actionText,
                )
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    visualContent()
                }
            }

            false -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    visualContent()
                }
                TextContent(
                    title = title,
                    description = description,
                    subtitle = subtitle,
                    actionText = actionText,
                )
            }
        }
    }
}


@OptIn(DelicateApi::class)
@Composable
private fun TextContent(
    title: @Composable (() -> Unit)? = null,
    subtitle: @Composable () -> Unit,
    description: @Composable () -> Unit,
    actionText: @Composable () -> Unit,
) {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(1.cssRem),
        verticalArrangement =
            if (title == null) Arrangement.Top
            else Arrangement.Center,
        horizontalAlignment =
            if (breakpoint < Breakpoint.MD) Alignment.CenterHorizontally
            else Alignment.Start
    ) {
        subtitle()
        title?.invoke()
        description()
        actionText()
    }
}


val ImageContentStyleVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier
            .borderRadius(30.px)
            .objectFit(ObjectFit.Cover)
            .height(
                max(
                    50.vh,
                    425.px
                )
            ) // ensures the image is at least 425px tall, but can grow to fill 50% of the viewport height
    }
}

@Composable
fun ImageContent(
    imageUrl: String,
    modifier: Modifier = Modifier,
    keepImageAsIs: Boolean = false,
    alt: String = "Image content"
) {
    Image(
        src = imageUrl,
        variant = if (keepImageAsIs) null else ImageContentStyleVariant,
        modifier = modifier,
        alt = alt
    )
}