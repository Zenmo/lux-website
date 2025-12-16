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
        Modifier.Companion
            .padding(leftRight = 1.5.cssRem)
    }
    Breakpoint.SM {
        Modifier.Companion
            .padding(leftRight = 1.5.cssRem)
    }
    Breakpoint.MD {
        Modifier.Companion
            .padding(leftRight = 3.cssRem)
    }
    Breakpoint.LG {
        Modifier.Companion
            .padding(leftRight = 4.cssRem)
    }

    Breakpoint.XL {
        Modifier.Companion
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
    modifier: Modifier = Modifier.Companion,
    yearBoxModifier: Modifier = Modifier.Companion,
) {
    Row(
        modifier = AboutUsHorizontalPaddingStyle.toModifier()
            .fillMaxWidth()
            .gap(2.cssRem)
            .thenIf(breakpoint >= Breakpoint.MD, Modifier.Companion.gap(4.cssRem))
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.Companion.fillMaxWidth().gap(1.cssRem)
        ) {
            SubHeaderText(
                enText = title.en,
                nlText = title.nl,
                modifier = Modifier.Companion
                    .fontFamily(PublicRes.FontFamilies.HOLON_BLOCK)
                    .textTransform(TextTransform.Companion.Uppercase)
                    .margin(0.cssRem)
                    .color(SitePalette.Companion.light.primary)
            )
            Box(
                Modifier.Companion.color(Colors.Black.copyf(alpha = 0.8f))
                    .textAlign(TextAlign.Companion.Justify)
            ) {
                textContent()
            }
        }

        YearBox(
            description = journeyDescription,
            yearText = yearText,
            breakpoint = breakpoint,
            modifier = Modifier.Companion.width(35.percent)
                .thenIf(breakpoint <= Breakpoint.LG, Modifier.Companion.width(40.percent))
                .then(yearBoxModifier)
        )
    }
}

@Composable
private fun YearBox(
    description: LocalizedText,
    yearText: @Composable () -> Unit,
    modifier: Modifier = Modifier.Companion,
    breakpoint: Breakpoint
) {
    Column(
        modifier = Modifier.Companion
            .alignSelf(AlignSelf.Companion.Stretch)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(3.cssRem)
            .thenIf(breakpoint < Breakpoint.MD, Modifier.Companion.display(DisplayStyle.Companion.None))
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        yearText()
        P(
            Modifier.Companion.margin(0.cssRem)
                .textAlign(TextAlign.Companion.Center)
                .thenIf(breakpoint > Breakpoint.MD, Modifier.Companion.width(90.percent))
                .toAttrs()
        ) {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }
    }
}