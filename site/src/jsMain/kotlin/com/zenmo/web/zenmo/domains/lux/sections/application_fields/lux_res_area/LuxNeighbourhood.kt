package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.LuxNeighbourhoodFactAndDemo
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.QuestionsGrid
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.ResAreaPersonalAdvice
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.ResHero
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.get_lux_neighbourhood.GetLuxNeighbourhoodSection


@OptIn(DelicateApi::class)
@Composable
fun LuxNeighbourhood() {
    Column {
        ResHero()
        QuestionsGrid()
        LuxNeighbourhoodFactAndDemo()
        GetLuxNeighbourhoodSection()
        ResAreaPersonalAdvice()
    }
}