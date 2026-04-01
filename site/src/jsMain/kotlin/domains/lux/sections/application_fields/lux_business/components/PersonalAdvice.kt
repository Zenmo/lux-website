package energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.LuxSpecificColorHues
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P


@Composable
fun PersonalAdvice() {
    LuxSectionContainer(
        modifier = Modifier
            .background(LuxSpecificColorHues().luxBlackRussian)
            .color(Colors.White)
            .alignItems(AlignItems.FlexStart)
            .gap(1.cssRem)
    ) {
        HeaderText(
            enText = "Personal Advice",
            nlText = "Persoonlijk Advies",
        )
        P {
            LangText(
                en = "We love building simulation models. And every model starts with a good conversation.",
                nl = "Wij houden van het bouwen van simulatiemodellen. En iedere model begint met een goed gesprek."
            )
            Br {}
            LangText(
                en = "Please reach out to us if you want to talk about what Zenmo can do for you - no strings attached.",
                nl = "Neem contact op als je vrijblijvend met ons wil spreken over wat wij voor je kunnen betekenen."
            )
        }

        ApplicationAreaCTAButton(
            text = LocalizedText(
                en = "Contact Zenmo",
                nl = "Contacteer Zenmo"
            )
        )
    }
}
