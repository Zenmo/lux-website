package com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiSearch
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
fun EmptyResults() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        MdiSearch(
            modifier = Modifier
                .fontSize(3.cssRem)
                .color(Colors.LightGrey)
        )

        SubHeaderText(
            enText = "No Models Found",
            nlText = "Geen Modellen Gevonden",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .textTransform(TextTransform.Uppercase)
        )

        P(Modifier.margin(0.px).toAttrs()) {
            LangText(
                en = "Try adjusting your search or filter criteria",
                nl = "Probeer uw zoek- of filtercriteria aan te passen"
            )
        }
    }
}