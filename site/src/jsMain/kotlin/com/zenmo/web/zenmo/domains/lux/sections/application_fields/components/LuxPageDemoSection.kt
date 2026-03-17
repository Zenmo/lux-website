package com.zenmo.web.zenmo.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLan
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMovie
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.widgets.VisualContentPlaceholder
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

enum class DemoTab(
    val title: LocalizedText,
) {
    DEMO_MODEL(
        LocalizedText(
            en = "Interactive Model",
            nl = "Interactief Model"
        )
    ),
    DEMO_MOVIE(
        LocalizedText(
            en = "Demo Movie",
            nl = "Demo Movie"
        )
    )
}

@Composable
fun LuxPageDemoSection(
    containerColor: CSSColorValue = SitePalette.light.overlay,
    applicationArea: LuxApplicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
    modelContent: @Composable () -> Unit = {
        VisualContentPlaceholder()
    },
    movieContent: @Composable () -> Unit = {
        VisualContentPlaceholder(
            descriptionText = LocalizedText(
                en = "Come back soon to see the demo movie!",
                nl = "Kom snel terug om de demo movie te zien!"
            ),
            icon = {
                MdiMovie(Modifier.fontSize(32.px))
            }
        )
    },
) {
    var selectedTab by remember { mutableStateOf(DemoTab.DEMO_MODEL) }
    LuxSectionContainer(
        modifier = Modifier.background(containerColor)
            .gap(1.cssRem),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.textAlign(TextAlign.Center)
        ) {
            HeaderText(
                enText = "See ${applicationArea.areaTitle.en} in action",
                nlText = "Bekijk ${applicationArea.areaTitle.nl} in actie"
            )
            P {
                LangText(
                    en = """
                        Explore interactive models and demo movies to get started with ${applicationArea.areaTitle.en}.
                    """.trimIndent(),
                    nl = """
                        Bekijk interactieve modellen en demo's om te beginnen met ${applicationArea.areaTitle.nl}.
                    """
                )
            }
        }

        DemoTabLayout(
            selectedTab = selectedTab,
            tabs = DemoTab.entries.associateWith { tab ->
                TabContent(
                    label = tab.title,
                    content = when (tab) {
                        DemoTab.DEMO_MODEL -> modelContent
                        DemoTab.DEMO_MOVIE -> movieContent
                    }
                )
            },
            onChange = { selectedTab = it }
        )
    }
}