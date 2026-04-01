package energy.lux.frontend.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.toAttrs
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.dom.H4

@Composable
fun TextBlock(
    title: LocalizedText,
    descriptionContent: @Composable () -> Unit,
) {
    Column {
        H4(
            attrs = Modifier
                .color(SitePalette.light.primary)
                .toAttrs()
        ) {
            LangText(
                en = title.en,
                nl = title.nl,
            )
        }
        descriptionContent()
    }
}