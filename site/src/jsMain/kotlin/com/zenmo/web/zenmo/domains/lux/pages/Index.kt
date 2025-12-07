package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.FieldModels
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader


@Composable
fun LuxEnergyLayout(
    content: @Composable () -> Unit
) {
    val applicationArea = ApplicationArea.current()
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = ""
    ) {
        content()
        if (applicationArea != null) {
            FieldModels(
                applicationArea = applicationArea
            )
        }
    }
}