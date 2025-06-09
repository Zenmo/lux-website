package com.zenmo.web.zenmo.domains.lux.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowBack
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonBlockHeaderTextStyle
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span


val LayoutHeaderStyle = CssStyle {
    base {
        Modifier
            .padding(3.5.cssRem)
            .display(DisplayStyle.Flex)
            .gap(1.cssRem)
    }
    Breakpoint.ZERO {
        Modifier
            .padding(1.5.cssRem, 2.cssRem)
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.SM {
        Modifier
            .padding(1.5.cssRem, 2.cssRem)
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.MD {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.LG {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.XL {
        Modifier.flexDirection(FlexDirection.Row)
    }
}

private val DomainHeaderBackgroundColorVar by StyleVariable<Color>()
private val DomainHeaderFontColorVar by StyleVariable<Color>()
val LayoutSectionContainerColorStyle = CssStyle.base {
    Modifier
        .background(DomainHeaderBackgroundColorVar.value())
        .color(DomainHeaderFontColorVar.value())
}

@Composable
fun LuxSubdomainPageLayout(
    title: String,
    enSubtitle: String = "Design your own energy system",
    nlSubtitle: String = "Ontwerp je eigen energiesysteem",
    backgroundColor: Color = SitePalette.light.primary,
    fontColor: Color = SitePalette.light.onPrimary,
    domainLogo: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        if (domainLogo != null) {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                domainLogo()
            }
        }

        Column(Modifier.fillMaxSize()) {
            SectionContainer(
                horizontalAlignment = Alignment.Start,
                modifier = LayoutSectionContainerColorStyle.toModifier()
                    .setVariable(DomainHeaderBackgroundColorVar, backgroundColor)
                    .setVariable(DomainHeaderFontColorVar, fontColor)
                    .then(LayoutHeaderStyle.toModifier()),
            ) {
                IconButton(
                    onClick = {
                        // todo navigate back to the previous page or lux.energy
                    },
                    modifier =
                        Modifier
                            .margin(top = 5.px)
                            .background(backgroundColor.shifted(ColorMode.current, 0.2f))
                ) {
                    MdiArrowBack(Modifier.color(fontColor))
                }

                Column {
                    HeaderText(
                        enText = title,
                        nlText = title,
                        modifier = TextStyle.toModifier(HolonBlockHeaderTextStyle)
                            .margin(0.cssRem)
                    )
                    Span(
                        TextStyle.toModifier(HolonLineTextStyle)
                            .margin(0.cssRem).toAttrs()
                    ) {
                        LangText(
                            en = enSubtitle,
                            nl = nlSubtitle,
                        )
                    }
                }
            }
            content()
        }
    }
}