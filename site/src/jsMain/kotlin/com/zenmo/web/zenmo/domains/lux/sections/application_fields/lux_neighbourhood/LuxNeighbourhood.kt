package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.bunderbuurten
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.kronenberg
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.loenen
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.FieldModels
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components.LuxNeighbourhoodFactAndDemo
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components.NeighbourhoodHero
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components.NeighbourhoodPersonalAdvice
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components.QuestionsGrid
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components.get_lux_neighbourhood.GetLuxNeighbourhoodSection
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@OptIn(DelicateApi::class)
@Composable
fun LuxNeighbourhood() {
    Column {
        NeighbourhoodHero()
        QuestionsGrid()
        LuxNeighbourhoodFactAndDemo()
        GetLuxNeighbourhoodSection()
        NeighbourhoodPersonalAdvice()
        FieldModels(
            applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
            featuredModels = listOf(
                bunderbuurten.toTwinModelCardItem(),
                loenen.toTwinModelCardItem(),
                kronenberg.toTwinModelCardItem(),
            ),
            showMoreModelsLink = true,
        )
        ApplicationAreaContactPerson(ZenmoTeam.PETER_HOGEVEEN)
    }
}
