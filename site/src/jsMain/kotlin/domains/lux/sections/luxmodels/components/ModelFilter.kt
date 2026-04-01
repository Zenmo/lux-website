package energy.lux.frontend.domains.lux.sections.luxmodels.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.DeEmphasizedTextStyle
import energy.lux.frontend.domains.lux.sections.ResponsiveFlexStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span

@Composable
fun ModelFilter(
    filterLabel: LocalizedText,
    content: @Composable () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Span(
            attrs = DeEmphasizedTextStyle.toModifier()
                .textTransform(TextTransform.Uppercase)
                .padding(bottom = 8.px)
                .toAttrs()
        ) {
            LangText(
                en = filterLabel.en,
                nl = filterLabel.nl
            )
        }
        Div(
            ResponsiveFlexStyle.toModifier()
                .gap(0.5.cssRem)
                .toAttrs()
        ) { content() }
    }
}