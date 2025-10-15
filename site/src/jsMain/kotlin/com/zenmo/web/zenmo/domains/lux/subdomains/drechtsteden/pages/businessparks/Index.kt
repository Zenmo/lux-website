package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderLeft
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel
import com.zenmo.web.zenmo.domains.lux.components.model.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem

val BusinessParkHeaderStyle = CssStyle.base {
    Modifier.fillMaxWidth()
        .background(SitePalette.light.secondary.lightened(0.5f))
        .borderLeft(.5.cssRem, LineStyle.Solid, SitePalette.light.secondary)
        .padding(leftRight = 1.cssRem, topBottom = 0.5.cssRem)
}

@Composable
fun BusinessParksPage() {
    DrechtstedenTwinLayout(
        title = "Business Parks",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant,
            horizontalAlignment = Alignment.Start
        ) {
            HeaderText(
                enText = "Business parks per municipality",
                nlText = "Bedrijventerreinen per gemeente",
                modifier = BusinessParkHeaderStyle.toModifier()
            )
            MunicipalitiesModels()

            HeaderText(
                enText = "Business parks",
                nlText = "Bedrijventerreinen",
                modifier = BusinessParkHeaderStyle.toModifier()
            )
            BusinessParksModels()
        }
    }
}

@Composable
fun BusinessParksModels() =
    TwinModelsGrid(
        models = DrechtstedenTwinModel.businessParkModels,
        path = "business-parks",
    )

@Composable
fun MunicipalitiesModels() =
    TwinModelsGrid(
        models = DrechtstedenTwinModel.municipalModels,
        path = "business-parks",
    )