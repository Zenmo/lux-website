package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.ResidentialAreaModelPageText
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.toTwinModelCardItems
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun NeighbourhoodsPage() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        introContent = {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .gap(1.cssRem)
            ) {
                HeaderText(
                    enText = DrechtstedenProjectArea.RESIDENTIAL_AREAS.label.en,
                    nlText = DrechtstedenProjectArea.RESIDENTIAL_AREAS.label.nl,
                )
                ResidentialAreaModelPageText()
            }
        },
        anylogicRender = {},
        footerContent = {
            HeaderText(
                enText = "Explore the Models",
                nlText = "Verken de Modellen",
            )
            NeighbourhoodModels()
        }
    )
}


@Composable
fun NeighbourhoodModels() =
    TwinModelsGrid(
        models = drechtstedenNeighbourhoodsModels.toTwinModelCardItems(),
    )
