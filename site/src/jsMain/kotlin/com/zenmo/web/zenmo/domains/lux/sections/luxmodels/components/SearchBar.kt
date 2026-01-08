package com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiSearch
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.focusVisible
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val SearchBarInputStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .padding(left = 0.25.cssRem)
            .border(0.px, LineStyle.None, Colors.Transparent)
    }
    focusVisible {
        Modifier.outline(0.px, LineStyle.None, Colors.Transparent)
    }
}

val SearchBarStyle = CssStyle {
    base {
        Modifier
            .minWidth(300.px)
            .backgroundColor(Colors.White)
            .color(SitePalette.light.onBackground)
            .padding(0.5.cssRem)
            .border(1.px, LineStyle.Solid, Colors.LightGrey)
            .luxBorderRadius()
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = SearchBarStyle.toModifier()
    ) {
        val language = LocalLanguage.current
        MdiSearch(
            modifier = Modifier.color(Colors.LightGrey),
        )
        org.jetbrains.compose.web.dom.Input(
            type = InputType.Text,
            attrs = TextStyle.toModifier(BodyTextStyle).then(SearchBarInputStyle.toModifier()).toAttrs {
                name("modelSearch")
                placeholder(
                    language.translate(
                        en = "Search models by name...",
                        nl = "Zoek modellen op naam...",
                    )
                )
                value(query)
                onInput { onQueryChange(it.value) }
            }
        )
    }
}

