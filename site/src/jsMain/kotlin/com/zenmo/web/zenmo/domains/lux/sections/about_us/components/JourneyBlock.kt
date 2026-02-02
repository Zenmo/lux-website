package com.zenmo.web.zenmo.domains.lux.sections.about_us.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P

val AboutUsHorizontalPaddingStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier
            .padding(leftRight = 1.5.cssRem)
    }
    Breakpoint.SM {
        Modifier
            .padding(leftRight = 1.5.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .padding(leftRight = 3.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .padding(leftRight = 4.cssRem)
    }

    Breakpoint.XL {
        Modifier
            .padding(leftRight = 4.cssRem)
    }
}

@Composable
fun JourneyBlock(
    breakpoint: Breakpoint,
    title: LocalizedText,
    textContent: @Composable () -> Unit,
    journeyDescription: LocalizedText,
    yearText: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    yearBoxModifier: Modifier = Modifier,
) {
    Row(
        modifier = AboutUsHorizontalPaddingStyle.toModifier()
            .fillMaxWidth()
            .gap(2.cssRem)
            .thenIf(breakpoint >= Breakpoint.MD, Modifier.gap(4.cssRem))
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().gap(1.cssRem)
        ) {
            SubHeaderText(
                enText = title.en,
                nlText = title.nl,
                textColor = SitePalette.light.primary,
                modifier = Modifier
                    .fontFamily(PublicRes.FontFamilies.HOLON_BLOCK)
                    .textTransform(TextTransform.Uppercase)
            )
            Box(
                Modifier.color(Colors.Black.copyf(alpha = 0.8f))
                    .textAlign(TextAlign.Justify)
            ) {
                textContent()
            }
        }

        YearBox(
            description = journeyDescription,
            yearText = yearText,
            breakpoint = breakpoint,
            modifier = Modifier.width(35.percent)
                .thenIf(breakpoint <= Breakpoint.LG, Modifier.width(40.percent))
                .then(yearBoxModifier)
        )
    }
}

@Composable
private fun YearBox(
    description: LocalizedText,
    yearText: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    breakpoint: Breakpoint
) {
    Column(
        modifier = Modifier
            .alignSelf(AlignSelf.Stretch)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(3.cssRem)
            .thenIf(breakpoint < Breakpoint.MD, Modifier.display(DisplayStyle.None))
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        yearText()
        P(
            Modifier
                .textAlign(TextAlign.Center)
                .thenIf(breakpoint > Breakpoint.MD, Modifier.width(90.percent))
                .toAttrs()
        ) {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }
    }
}