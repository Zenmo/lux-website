package energy.lux.frontend.domains.zenmo.pages.home.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPhoto
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.widgets.VisualContentPlaceholder
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

data class ProjectItem(
    val imageUrl: String,
    val url: String = "",
    val categoryText: LocalizedText,
    val titleText: LocalizedText = LocalizedText(nl = "Lorem ipsum dolor sit amet"),
    val descriptionText: LocalizedText = LocalizedText(nl = "Lorem ipsum dolor sit amet ".repeat(3)),
)

@Composable
fun ProjectCard(item: ProjectItem) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .cursor(Cursor.Pointer)
            .onClick {
                if (item.url.isNotBlank()) {
                    window.open(item.url, "_self")
                }
            },
        verticalArrangement = Arrangement.Top,
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = ProjectCardImageStyle.toModifier()
        ) {
            VisualContentPlaceholder(
                descriptionText = LocalizedText(en = "Project image", nl = "Project afbeelding"),
                icon = { MdiPhoto() },
                modifier = Modifier.fillMaxSize()
                    .minHeight(0.vh)
                    .backgroundColor(Colors.Transparent)
                    .boxShadow(BoxShadow.None),
            )
            Span(
                ProjectCategoryBadgeStyle.toModifier()
                    .margin(1.cssRem)
                    .toAttrs()
            ) {
                LangText(en = item.categoryText.en, nl = item.categoryText.nl)
            }
        }
        Column(
            modifier = Modifier.padding(top = 1.cssRem),
        ) {
            Span(TextStyle.toModifier(TitleTextStyle).toAttrs()) {
                LangText(en = item.titleText.en, nl = item.titleText.nl)
            }
            P { LangText(en = item.descriptionText.en, nl = item.descriptionText.nl) }
        }
    }
}