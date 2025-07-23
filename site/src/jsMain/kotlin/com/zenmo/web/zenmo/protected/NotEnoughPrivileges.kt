package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H4

@Composable
fun NotEnoughPrivileges(
    actionContent: @Composable () -> Unit = {
        PrimaryButton(
            enText = "Return to LUX",
            nlText = "Keer terug naar LUX",
        ) {
            window.history.back()
        }
    }
) {
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H4 {
            LangText(
                en = "You do not have enough privileges to access this content.",
                nl = "Je hebt niet genoeg rechten om deze inhoud te bekijken."
            )
        }
        actionContent()
    }
}