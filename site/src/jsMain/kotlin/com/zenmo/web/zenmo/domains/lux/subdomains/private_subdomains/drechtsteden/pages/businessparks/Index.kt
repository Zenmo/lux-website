package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.BusinessParksText
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities.drechtstedenMunicipalityModels
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.toTwinModelCardItems
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid


@Composable
fun BusinessParksPage() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        introContent = {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .gap(1.5.cssRem)
            ) {
                HeaderText(
                    enText = "Energy hubs",
                    nlText = "Energy hubs",
                )
                BusinessParksText()
            }
        },
        anylogicRender = {},
        footerContent = {
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
    )
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