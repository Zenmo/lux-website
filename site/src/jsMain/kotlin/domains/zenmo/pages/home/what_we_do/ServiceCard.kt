package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

data class ServiceItem(
    val icon: @Composable () -> Unit,
    val titleText: LocalizedText,
    val descriptionText: LocalizedText = LocalizedText("Lorem ipsum dolor sit amet")
)

@Composable
fun ServiceCard(item: ServiceItem) {
    Column(
        modifier = ServiceCardStyle.toModifier().fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .padding(16.px)
                .borderRadius(12.px)
                .color(SitePalette.light.primary)
                .backgroundColor(SitePalette.light.primary.lightened(0.9f)),
            contentAlignment = Alignment.Center
        ) {
            item.icon()
        }
        SubHeaderText(
            enText = item.titleText.en,
            nlText = item.titleText.nl,
            modifier = Modifier.fontSize(1.25.cssRem)
                .padding(top = 1.cssRem)
        )
        P {
            LangText(item.descriptionText)
        }
    }
}