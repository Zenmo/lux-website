package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowBack
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3


@Composable
fun BookADemoPage() {
    PageLayout(
        header = {},
        footer = {},
        title = "Book a Demo",
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            H2 {
                LangText(
                    en = "Mail us at ",
                    nl = "Mail ons naar ",
                )
                InlineLink(
                    destinationUrl = "mailto:hallo@zenmo.com",
                    enLinkText = "hallo@zenmo.com",
                    nlLinkText = "hallo@zenmo.com"
                )
            }


            Row(
                modifier = Modifier.gap(0.5.cssRem),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { window.history.back() }) {
                    MdiArrowBack()
                }
                H3 {
                    LangText(
                        en = "Return to LUX",
                        nl = "Keer terug naar LUX",
                    )
                }
            }
        }
    }
}