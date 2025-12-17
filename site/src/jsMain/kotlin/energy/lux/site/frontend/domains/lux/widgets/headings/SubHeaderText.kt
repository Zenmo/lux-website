package energy.lux.site.frontend.domains.lux.widgets.headings

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.TextComponentKind
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import org.jetbrains.compose.web.dom.H3

@Composable
fun SubHeaderText(
    modifier: Modifier = Modifier,
    customFont: CssStyleVariant<TextComponentKind>? = null,
    enText: String,
    nlText: String,
) {
    H3(
        TextStyle.toModifier(customFont ?: TitleTextStyle)
            .then(modifier)
            .toAttrs()
    ) {
        LangText(
            en = enText,
            nl = nlText,
        )
    }
}