package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.subdomainModels
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette


@Composable
fun FieldModels(
    applicationArea: ApplicationArea
) {
    SectionContainer(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier =
            Modifier
                .then(TopDividerLineStyle.toModifier())
                .background(SitePalette.light.overlay),
        variant = LuxSectionContainerStyleVariant
    ) {
        HeaderText(
            enText = "Models",
            nlText = "Modellen",
        )
        TwinModelsGrid(
            models = subdomainModels
                .map { it.toTwinModelCardItem() }
                .filter { it.applicationArea == applicationArea },
        )
    }
}