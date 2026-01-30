package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText


@Composable
fun ContactZenmo() {
    LuxSectionContainer {
        HeaderText(
            enText = "Want to know more?",
            nlText = "Wil je meer weten?",
        )
        ApplicationAreaCTAButton(
            text = LocalizedText(
                en = "Contact Zenmo",
                nl = "Contacteer Zenmo"
            )
        )
    }
}