package com.zenmo.web.zenmo.domains.lux.widgets.headings

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextComponentKind
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.H3

@Composable
fun SubHeaderText(
    modifier: Modifier = Modifier,
    customFont: CssStyleVariant<TextComponentKind>? = HolonLineTextStyle,
    enText: String,
    nlText: String,
) {
    val font = when (window.location.host) {
        SiteGlobals.ZENMO_DOMAIN -> TitleTextStyle
        else -> customFont
    }
    H3(
        TextStyle.toModifier(font)
            .then(modifier)
            .toAttrs()
    ) {
        LangText(
            en = enText,
            nl = nlText,
        )
    }
}