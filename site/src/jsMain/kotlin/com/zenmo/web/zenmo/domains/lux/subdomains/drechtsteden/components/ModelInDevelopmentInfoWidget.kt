package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P


val ModelInDevelopmentInfoWidgetStyle = CssStyle {
    base {
        Modifier.Companion
            .boxSizing(BoxSizing.BorderBox)
            .background(SitePalette.light.secondary.lightened(0.5f))
            .borderLeft(.5.cssRem, LineStyle.Solid, SitePalette.light.secondary)
    }
    Breakpoint.ZERO {
        Modifier.Companion.padding(20.px)
    }

    Breakpoint.SM {
        Modifier.Companion.padding(20.px)
    }

    Breakpoint.MD {
        Modifier.Companion.padding(leftRight = 134.px, topBottom = 20.px)
    }
    Breakpoint.LG {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 30.px)
    }
    Breakpoint.XL {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 30.px)
    }
}


@Composable
fun ModelInDevelopmentInfoWidget(
    enTitle: String = "This model is still in development",
    nlTitle: String = "Dit model is nog in ontwikkeling",
    enDescription: String = """
        Note, this model is still in development. The data for the capacity of the medium voltage stations 
        has been assumed based on the available profiles of the participating companies.
    """.trimIndent(),
    nlDescription: String = """
        Let op, dit model is nog in ontwikkeling. De data van de capaciteit op de middenspanningsstations is 
        aangenomen op basis van de beschikbare profielen van de deelnemende bedrijven.
    """.trimIndent(),
) {
    var visible by remember { mutableStateOf(true) }
    SectionContainer(
        modifier = ModelInDevelopmentInfoWidgetStyle.toModifier()
            .thenIf(
                !visible,
                Modifier.Companion.display(DisplayStyle.Companion.None)
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.Companion.fillMaxWidth()
        ) {
            H3(
                Modifier.Companion
                    .flex(1)
                    .margin(0.px)
                    .toAttrs()
            ) {
                LangText(
                    en = enTitle,
                    nl = nlTitle,
                )
            }

            CloseIcon(
                modifier = Modifier.Companion.fontSize(FontSize.Companion.Larger)
                    .cursor(Cursor.Companion.Pointer)
                    .onClick { visible = false },
            )
        }
        P {
            LangText(
                nl = nlDescription,
                en = enDescription,
            )
        }
    }
}