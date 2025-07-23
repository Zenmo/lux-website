package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiError
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ErrorWidget(
    errorMessage: String,
    actionContent: @Composable () -> Unit = {
        PrimaryButton(
            enText = "Return to LUX",
            nlText = "Keer terug naar LUX",
            modifier = Modifier.margin(top = 1.cssRem)
        ) { window.history.back() }
    }
) {
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MdiError(
            Modifier.color(Color.red)
                .fontSize(50.px)
        )
        SubHeaderText(
            enText = "Error",
            nlText = "Fout",
            modifier = Modifier.margin(0.cssRem)
        )
        P(
            Modifier
                .fillMaxWidth()
                .textAlign(TextAlign.Center)
                .margin(top = 0.cssRem, bottom = 0.cssRem, leftRight = 5.cssRem)
                .toAttrs()
        ) {
            Text(errorMessage)
        }
        actionContent()
    }
}