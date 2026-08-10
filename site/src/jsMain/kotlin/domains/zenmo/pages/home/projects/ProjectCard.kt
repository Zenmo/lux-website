package energy.lux.frontend.domains.zenmo.pages.home.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.pages.projects.ZenmoProject
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun ProjectCard(item: ZenmoProject) {
    val path = when (item) {
        is ZenmoProject.External -> item.url
        is ZenmoProject.Internal -> item.path
    }
    Link(
        path = path,
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        modifier = Modifier.fillMaxWidth()
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.px)
                .background(SitePalette.light.overlay)
                .borderRadius(14.px)
                .overflow(Overflow.Clip)
        ) {
            Image(
                src = item.imageUrl,
                alt = item.titleText.en,
                modifier = Modifier.fillMaxSize()
                    .objectFit(ObjectFit.Cover),
            )
            Span(
                TextStyle.toModifier(LabelTextStyle)
                    .padding(leftRight = 0.75.cssRem, topBottom = 0.25.cssRem)
                    .borderRadius(50.px)
                    .backgroundColor(SitePalette.light.primary)
                    .color(SitePalette.light.onPrimary)
                    .margin(1.cssRem)
                    .toAttrs()
            ) {
                LangText(en = item.categoryText.en, nl = item.categoryText.nl)
            }
        }
        Column(
            modifier = Modifier.padding(top = 1.cssRem),
        ) {
            SubHeaderText(enText = item.titleText.en, nlText = item.titleText.nl)
            P(
                Modifier.padding(right = 0.5.cssRem)
                    .toAttrs()
            ) { LangText(en = item.descriptionText.en, nl = item.descriptionText.nl) }
        }
    }
}