package energy.lux.frontend.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.luxBorderRadius
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.em

@Composable
fun ApplicationAreaCTAButton(
    modifier: Modifier = Modifier,
    path: String? = null,
    bgColor: CSSColorValue = SitePalette.light.primary,
    textColor: CSSColorValue = Colors.White,
    text: LocalizedText = LocalizedText(
        en = "Contact us",
        nl = "Neem contact op",
    ),
    icon: (@Composable () -> Unit)? = null,
) {
    PrimaryButton(
        modifier = Modifier
            .background(bgColor).color(textColor)
            .padding(leftRight = 2.25.em, topBottom = 1.1.em)
            .luxBorderRadius()
            .then(modifier),
        enText = text.en,
        nlText = text.nl,
        icon = icon,
        onClick = {
            if (!path.isNullOrBlank()) {
                window.open(path, "_self")
            } else {
                val element = document.getElementById(APPLICATION_AREA_CONTACT_PERSON_ID)
                element?.scrollIntoView()
            }
        }
    )
}
