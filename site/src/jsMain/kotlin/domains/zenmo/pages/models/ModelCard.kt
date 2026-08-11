package energy.lux.frontend.domains.zenmo.pages.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.max
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.P

@Composable
fun ModelCard(showcased: ShowcasedModel) {
    Link(
        path = showcased.model.url,
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column {
            ImageContent(
                imageUrl = showcased.model.imageUrl,
                alt = showcased.model.label.en,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(max(40.vh, 260.px))
                    .borderRadius(14.px)
                    .margin(bottom = 1.cssRem),
            )
            SubHeaderText(showcased.model.label)
            P { LangText(showcased.description) }
        }
    }
}