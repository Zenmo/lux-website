package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import energy.lux.frontend.domains.lux.sections.LuxSectionContainerStyleVariant
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import energy.lux.frontend.pages.SiteGlobals
import kotlinx.browser.window

@Composable
fun UnknownDomain(
    domain: String
) {
    SectionContainer(
        verticalArrangement = Arrangement.Center,
        variant = LuxSectionContainerStyleVariant
    ) {
        HeaderText(
            enText = "Unknown Domain: $domain",
            nlText = "Onbekend Domein: $domain"
        )

        PrimaryButton(
            enText = "Go to main Lux site",
            nlText = "Ga naar de hoofd Lux site",
            onClick = {
                window.location.href = "//${SiteGlobals.LUX_DOMAIN}"
            }
        )
    }
}
