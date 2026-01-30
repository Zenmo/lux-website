package com.zenmo.web.zenmo.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.em

@Composable
fun ApplicationAreaCTAButton(
    modifier: Modifier = Modifier,
    path: String = "/book-demo",
    bgColor: CSSColorValue = SitePalette.light.primary,
    textColor: CSSColorValue = Colors.White,
    text: LocalizedText = LocalizedText(
        en = "Contact us",
        nl = "Neem contact op",
    ),
    content: @Composable () -> Unit = {
        LangText(
            en = text.en,
            nl = text.nl,
        )
    },
) {
    Link(
        path = path,
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        modifier = Modifier
            .background(bgColor).color(textColor)
            .padding(leftRight = 2.25.em, topBottom = 1.1.em)
            .luxBorderRadius()
            .then(modifier)
    ) {
        content()
    }
}