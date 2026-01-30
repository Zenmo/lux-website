package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components.*


@OptIn(DelicateApi::class)
@Composable
fun LuxCompany(
) {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LuxCompanyHero(breakpoint)
        BatteryValueSection()
        HowItWorks()
        InteractiveDashboardSection()
        PersonalAdvice(breakpoint)
        UniqueFeature(breakpoint)
        ContactZenmo()
    }
}
