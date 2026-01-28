package com.zenmo.web.zenmo.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P

@Composable
fun TwinModelPageIntroBlock(
    challengeText: LocalizedText,
    investigationText: LocalizedText,
    solutionText: LocalizedText,
) {
    Column(
        modifier = Modifier.fillMaxWidth().gap(0.5.cssRem),
    ) {
        TextBlock(
            title = LocalizedText(
                en = "The Challenge",
                nl = "De Uitdaging",
            ),
            description = challengeText,
        )
        TextBlock(
            title = LocalizedText(
                en = "Our Investigation",
                nl = "Ons Onderzoek",
            ),
            description = investigationText,
        )
        TextBlock(
            title = LocalizedText(
                en = "The Solution",
                nl = "De Oplossing",
            ),
            description = solutionText,
        )
    }
}

@Composable
private fun TextBlock(
    title: LocalizedText,
    description: LocalizedText,
) {
    Column {
        H4(
            attrs = Modifier
                .color(SitePalette.light.primary)
                .toAttrs()
        ) {
            LangText(
                en = title.en,
                nl = title.nl,
            )
        }
        P {
            LangText(
                en = description.en,
                nl = description.nl,
            )
        }
    }
}