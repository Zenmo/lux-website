package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities.drechtstedenMunicipalityModels
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.toTwinModelCardItems
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText


@Composable
fun BusinessParksPage() {
    LuxSectionContainer(
        modifier = Modifier
            .alignItems(AlignItems.FlexStart),
    ) {
        HeaderText(
            enText = "Business parks per municipality",
            nlText = "Bedrijventerreinen per gemeente",
        )
        MunicipalitiesModels()

        HeaderText(
            enText = "Business parks",
            nlText = "Bedrijventerreinen",
        )
        BusinessParksModels()
    }
}


@Composable
fun BusinessParksModels() =
    TwinModelsGrid(
        models = drechtstedenBusinessParkModels.toTwinModelCardItems(),
    )

@Composable
fun MunicipalitiesModels() =
    TwinModelsGrid(
        models = drechtstedenMunicipalityModels.toTwinModelCardItems(),
    )