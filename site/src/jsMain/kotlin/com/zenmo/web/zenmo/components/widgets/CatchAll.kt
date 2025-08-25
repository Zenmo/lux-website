package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowBack
import com.varabyte.kobweb.silk.components.navigation.Link
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import org.jetbrains.compose.web.css.cssRem

@Composable
fun CatchAllPage() {
    SectionContainer(
        modifier = Modifier.textAlign(TextAlign.Center),
        verticalArrangement = Arrangement.Center,
        variant = LuxSectionContainerStyleVariant
    ) {
        HeaderText(
            enText = "This page does not exist.",
            nlText = "Deze pagina bestaat niet."
        )
        Link(
            path = "/",
            modifier = Modifier.textDecorationLine(TextDecorationLine.None)
        ) {
            IconButton(onClick = { }, modifier = Modifier.size(3.cssRem)) {
                MdiArrowBack()
            }
        }
    }
}
