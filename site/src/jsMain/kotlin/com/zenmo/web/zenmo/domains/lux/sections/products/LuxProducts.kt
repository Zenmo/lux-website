package com.zenmo.web.zenmo.domains.lux.sections.products

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxSection

@Composable
fun LuxProducts() {
    Column(Modifier.id(LuxSection.PRODUCTS.id)) {
        LuxCompany()
        LuxEnergyHub()
        LuxResidentialArea()
        LuxMunicipality()
    }
}
