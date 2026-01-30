package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components.*


@Composable
fun LuxCompany(
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LuxCompanyHero()
        BatteryValueSection()
        HowItWorks()
        InteractiveDashboardSection()
        PersonalAdvice()
        UniqueFeature()
    }
}
