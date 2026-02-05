package com.zenmo.web.zenmo.domains.lux.components.layout

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.FieldModels
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader
import kotlinx.browser.window


@Composable
fun LuxEnergyLayout(
    content: @Composable () -> Unit
) {
    val currentApplicationArea = LuxApplicationArea.entries
        .firstOrNull { it.path == window.location.pathname }

    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = ""
    ) {
        content()
        if (currentApplicationArea != null) {
            FieldModels(
                applicationArea = currentApplicationArea
            )
            ApplicationAreaContactPerson(currentApplicationArea.contactPerson)
        }
    }
}