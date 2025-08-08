package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.Space
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Text

@Composable
fun ColorPaletteDemo() {
    SectionContainer {
        SubHeaderText(
            enText = "Color palette",
            nlText = "Kleurenpalet",
        )

        val palette = SitePalette.light

        ColorDemoRow(
            modifier = Modifier
                .color(palette.primary)
        ) {
            LangText(
                en = "Primary color",
                nl = "Eerste kleur",
            )
            Space()
            Text(palette.primary.toString())
        }

        ColorDemoRow(
            modifier = Modifier
                .color(palette.secondary)
        ) {
            LangText(
                en = "Secondary color",
                nl = "Tweede kleur",
            )
            Space()
            Text(palette.secondary.toString())
        }

        ColorDemoRow(
            modifier = Modifier
                .color(palette.onBackground)
        ) {
            LangText(
                en = "Text color",
                nl = "Tekstkleur",
            )
            Space()
            Text(palette.onBackground.toString())
        }

        ColorDemoRow(
            modifier = Modifier
                .backgroundColor(palette.overlay)
                .color(palette.onBackground)
        ) {
            LangText(
                en = "Tinted background color",
                nl = "Achtergrondkleur",
            )
            Space()
            Text(palette.overlay.toString())
        }

        ColorDemoRow(
            modifier = Modifier
                .backgroundColor(palette.background)
                .color(palette.onBackground)
        ) {
            LangText(
                en = "Almost white background color",
                nl = "Bijna witte achtergrond",
            )
            Space()
            Text(palette.background.toString())
        }
    }
}

@Composable
private fun ColorDemoRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        Modifier
            .fontSize(2.cssRem)
            .fontWeight(FontWeight.Bold)
            .then(modifier),
    ) {
        content()
    }
}
