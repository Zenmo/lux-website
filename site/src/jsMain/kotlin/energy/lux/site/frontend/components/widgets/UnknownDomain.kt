package energy.lux.site.frontend.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.pages.SiteGlobals
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

        val protocol = window.location.protocol
        PrimaryButton(
            enText = "Go to main Lux site",
            nlText = "Ga naar de hoofd Lux site",
            onClick = {
                window.location.href = "${protocol}//${SiteGlobals.LUX_DOMAIN}"
            }
        )
    }
}