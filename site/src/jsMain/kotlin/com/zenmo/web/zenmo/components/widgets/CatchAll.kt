package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.utils.PublicRes
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun CatchAllPage() {
    LuxSectionContainer {
        HeaderText(
            enText = "404",
            nlText = "404",
            textColor = SitePalette.light.primary
        )

        Column(
            Modifier
                .gap(1.cssRem)
                .textAlign(TextAlign.Center)
        ) {
            SubHeaderText(
                enText = "This page does not exist.",
                nlText = "Deze pagina bestaat niet.",
                modifier = Modifier
                    .fontFamily(PublicRes.FontFamilies.HOLON_BLOCK)
                    .textTransform(TextTransform.Uppercase)
            )
            P {
                LangText(
                    en = "The page you're looking for seems to have wandered off the grid.",
                    nl = "De pagina die je zoekt lijkt van de kaart verdwenen te zijn."
                )
            }
        }

        PrimaryButton(
            enText = "GO BACK",
            nlText = "GA TERUG",
            onClick = { window.history.back() }
        )
    }
}
