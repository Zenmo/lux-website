package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.rememberPageContext
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H4

@Composable
fun NotEnoughPrivileges(
    actionContent: @Composable () -> Unit = {
        val ctx = rememberPageContext()
        PrimaryButton(
            enText = "Return to LUX",
            nlText = "Keer terug naar LUX",
        ) {
            ctx.router.navigateTo("/")
        }
    }
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
            .textAlign(TextAlign.Center),
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