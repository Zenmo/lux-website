package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHelp
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.P


@Composable
fun ResHero() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.Start)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_RESIDENTIAL_AREA.areaTitle.en,
            nlText = LuxApplicationArea.LUX_RESIDENTIAL_AREA.areaTitle.nl,
        )
        QuestionsGrid()
        GetAnswersBanner()
    }
}

@Composable
private fun GetAnswersBanner() {
    Column(
        Modifier
            .fillMaxWidth()
            .color(Colors.White)
            .gap(1.cssRem)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(clamp(32.px, 5.vw, 64.px))
            .verticalLinearBackground()
    ) {
        Box(
            Modifier
                .size(80.px)
                .background(SitePalette.light.secondary)
                .color(Colors.Black)
                .clip(shape = Circle())
                .flexShrink(0),
            contentAlignment = Alignment.Center
        ) {
            MdiHelp(Modifier.fontSize(40.px))
        }

        SubHeaderText(
            enText = "Get Answers",
            nlText = "Krijg Antwoorden",
        )

        P {
            LangText(
                en = """
                    You will get an answer to these questions and many more with LUX residential area. And this in an 
                    automated way that greatly reduces costs compared to a standard consultancy project.
                """.trimIndent(),
                nl = """
                    Op deze vragen en nog veel meer krijg je een antwoord met LUX-woonwijk. En dat op een
                    geautomatiseerde manier die de kosten sterk verlaagt ten opzichte van een standaard adviesproject.
                """.trimIndent()
            )
        }
    }
}