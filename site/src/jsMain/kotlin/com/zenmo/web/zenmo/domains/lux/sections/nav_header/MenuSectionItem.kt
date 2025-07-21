package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Li

val ActiveMenuStyle = CssStyle {
    base {
        Modifier
            .color(SitePalette.light.primary)
            .fontWeight(FontWeight.Bold)
    }
}

@Composable
fun MenuSectionItem(
    href: String,
    enTitle: String,
    nlTitle: String,
    isActive: Boolean = false,
    modifier: Modifier = Modifier
        .padding(10.px),
) {
    Li(
        Modifier
            .listStyle(ListStyleType.None)
            .position(Position.Relative).toAttrs(),
    ) {
        A(
            href = href,
            attrs = modifier
                .color(SitePalette.light.onBackground)
                .thenIf(isActive, ActiveMenuStyle.toModifier())
                .textDecorationLine(TextDecorationLine.None)
                .toAttrs()
        ) {
            LangText(
                en = enTitle,
                nl = nlTitle,
            )
        }
    }
}
