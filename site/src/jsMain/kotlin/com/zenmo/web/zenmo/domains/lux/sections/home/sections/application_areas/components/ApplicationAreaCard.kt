package com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowForward
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.model.ApplicationAreaItem
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.styles.cubicBezierTransition
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

var ApplicationAreaCardStyle = CssStyle {
    base {
        Modifier
            .padding(48.px)
            .background(Colors.White)
            .luxBorderRadius(LuxCornerRadius.lg)
            .cursor(Cursor.Pointer)
            .cubicBezierTransition()
    }

    cssRule(" .area-link") {
        Modifier
            .gap(8.px)
            .cubicBezierTransition()
    }

    cssRule(":hover .area-link") {
        Modifier
            .background(SitePalette.light.primary.lightened(0.9f))
            .gap(16.px)
    }
}

@Composable
fun ApplicationAreaCard(
    areaItem: ApplicationAreaItem,
) {
    val (
        applicationArea,
        description,
        icon
    ) = areaItem

    Column(
        ApplicationAreaCardStyle.toModifier().then(HoverBoxShadowStyle.toModifier()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.px)
    ) {
        Box(
            Modifier.size(64.px)
                .luxBorderRadius()
                .background(SitePalette.light.primary.lightened(0.9f)),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }
        HeaderText(
            enText = applicationArea.areaTitle.en,
            nlText = applicationArea.areaTitle.nl,
            modifier = Modifier.margin(0.cssRem)
        )
        P(
            DeEmphasizedTextStyle.toModifier()
                .margin(0.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }

        Link(
            path = applicationArea.path,
            variant = UncoloredLinkVariant.then(UndecoratedLinkVariant),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.px, 16.px)
                    .color(SitePalette.light.primary)
                    .luxBorderRadius()
                    .classNames("area-link")
            ) {
                LangText(
                    en = "Learn more",
                    nl = "Meer informatie"
                )

                MdiArrowForward()
            }
        }
    }
}
