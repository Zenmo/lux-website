package energy.lux.frontend.domains.zenmo.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiNorthEast
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.css.*

@Composable
fun MoreInfoLink(
    url: String,
    text: LocalizedText = LocalizedText(en = "Learn more", nl = "Meer informatie"),
    modifier: Modifier = Modifier,
) {
    Link(
        path = url,
        variant = UncoloredLinkVariant.then(UndecoratedLinkVariant),
        modifier = MoreInfoLinkStyle.toModifier().then(modifier),
    ) {
        LangText(text)
        MdiNorthEast(modifier = Modifier.fontSize(16.px))
    }
}