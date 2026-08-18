package energy.lux.frontend.domains.zenmo.pages.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.styles.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.widgets.MoreInfoLink
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun ProjectRowCard(item: ZenmoProject, reversed: Boolean = false) {
    val projectRowStyle = if (reversed) ProjectRowReverseStyle else ResponsiveFlexStyle
    Div(
        projectRowStyle.toModifier()
            .gap(2.cssRem)
            .toAttrs()
    ) {
        Image(
            src = item.imageUrl,
            alt = item.titleText.en,
            modifier = ProjectImageStyle.toModifier(),
        )
        ProjectContent(item)
    }
}

@Composable
private fun ProjectContent(item: ZenmoProject) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.constrainedWidth()
    ) {
        Column(
            modifier = Modifier
                .flex(1)
                .fillMaxWidth()
                .padding(clamp(12.px, 5.vw, 32.px)),
            verticalArrangement = Arrangement.spacedBy(0.5.cssRem),
            horizontalAlignment = Alignment.Start,
        ) {

            Span(
                TextStyle.toModifier(LabelTextStyle)
                    .color(SitePalette.light.primary)
                    .toAttrs()
            ) {
                LangText(
                    en = item.categoryText.en.uppercase(),
                    nl = item.categoryText.nl.uppercase(),
                )
            }
            SubHeaderText(item.titleText)
            P {
                LangText(item.descriptionText)
            }
            MoreInfoLink(item.url)
        }
    }
}