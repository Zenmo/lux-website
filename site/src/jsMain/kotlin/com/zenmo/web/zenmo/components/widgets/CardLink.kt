package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.isZenmoDomain
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

val CardLinkStyle = CssStyle {
    base {
        Modifier
            .borderRadius(24.px)
            .thenIf(!isZenmoDomain, Modifier.luxBorderRadius(LuxCornerRadius.lg))
            .background(Color.white)
            .boxShadow(0.px, 2.px, 4.px, 0.px, rgba(0, 0, 0, 0.24f))
            .overflow(Overflow.Hidden)
            .transition(Transition.of(TransitionProperty.All, 350.ms, TransitionTimingFunction.Ease))
    }
    hover {
        Modifier
            .boxShadow(0.px, 8.px, 10.px, 1.px, rgba(0, 0, 0, 0.2f))
            .transform { translateY((-8).px) }
    }
}


val LinkNoStyle = CssStyle {
    base {
        Modifier.color(SitePalette.light.onBackground)
    }
    hover {
        Modifier.textDecorationLine(TextDecorationLine.None)
    }
}

@Composable
fun CardLink(
    modifier: Modifier = Modifier,
    url: String,
    imageUrl: String = "",
    imageAltText: String = "",
    enTitle: String = "",
    nlTitle: String = "",
    enDescription: String = "",
    nlDescription: String = "",
    title: @Composable () -> Unit = {
        SubHeaderText(
            enText = enTitle,
            nlText = nlTitle,
            modifier = Modifier.margin(0.cssRem)
        )
    },
    description: @Composable () -> Unit = {
        P(
            DeEmphasizedTextStyle.toModifier()
                .margin(0.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = enDescription,
                nl = nlDescription,
            )
        }
    },
    metaContent: @Composable () -> Unit = { }
) {
    Link(
        path = url,
        modifier = LinkNoStyle.toModifier().fillMaxSize(),
        updateHistoryMode = UpdateHistoryMode.REPLACE,
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
    ) {
        Column(
            CardLinkStyle.toModifier()
                .then(modifier),
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(225.px).overflow(Overflow.Hidden),
                contentAlignment = Alignment.Center,
            ) {
                Img(
                    src = imageUrl,
                    alt = imageAltText,
                    attrs = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).toAttrs()
                )
                metaContent()
            }
            Column(
                Modifier.padding(1.cssRem).gap(1.cssRem).fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
            ) {
                title()
                description()
            }
        }
    }
}
