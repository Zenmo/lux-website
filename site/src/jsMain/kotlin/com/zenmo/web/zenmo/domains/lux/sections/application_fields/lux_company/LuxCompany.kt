package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.cognizant
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.FieldModels
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components.*
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


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
        FieldModels(
            applicationArea = LuxApplicationArea.LUX_BUSINESS,
            featuredModels = listOf(
                cognizant.toTwinModelCardItem(),
                PrivateSubdomainModel.PREZERO.toTwinModelCardItem(),
            ),
            showMoreModelsLink = false,
        )
        ApplicationAreaContactPerson(ZenmoTeam.PETER_HOGEVEEN)
    }
}
