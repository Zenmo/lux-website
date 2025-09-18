package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import com.zenmo.web.zenmo.domains.zenmo.navigation.asNavLinkPath
import web.window.window


enum class ApplicationField(
    val enFieldName: String,
    val nlFieldName: String
) {
    LUX_COMPANY("LUX Company", "LUX Bedrijf"),
    LUX_ENERGY_HUB("LUX Energy Hub", "LUX Energie Hub"),
    LUX_RESIDENTIAL_AREA("LUX Residential Area", "LUX Woongebied"),
    LUX_REGION("LUX Region", "LUX Regio");


    fun fieldRoute() = this.enFieldName.asNavLinkPath("application-fields")

    companion object {
        fun current(): ApplicationField? {
            val path = window.location.pathname
            return entries.firstOrNull { it.fieldRoute() == path }
        }
    }
}
