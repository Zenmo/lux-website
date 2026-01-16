package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignContent
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.OverflowWrap
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLock
import com.varabyte.kobweb.silk.components.icons.mdi.MdiOpenInNew
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.getApplicationAreaColor
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.styles.cubicBezierTransition
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span

const val metaContentClassName = "meta-content"

val ModelCardLinkStyle = CssStyle {
    base {
        Modifier
            .border(1.px, LineStyle.Solid, SitePalette.light.overlay)
            .cubicBezierTransition()
    }

    cssRule(" .$metaContentClassName") {
        Modifier
            .display(DisplayStyle.None)
            .cubicBezierTransition()
    }

    cssRule(" img") {
        Modifier
            .cubicBezierTransition()
    }


    cssRule(":hover img") {
        Modifier
            .transform {
                scale(1.05f)
            }
    }

    cssRule(":hover .$metaContentClassName") {
        Modifier.fillMaxSize()
            .display(DisplayStyle.Block)
            .zIndex(1)
            .background(
                Background.of(
                    image = linearGradient(0.deg) {
                        add(Colors.Black.copyf(alpha = 0.25f), 0.percent)
                        add(Colors.Black.copyf(alpha = 0f), 30.percent)
                        add(Colors.Black.copyf(alpha = 0f), 100.percent)
                    }.toImage()
                )
            )
            .padding(16.px)
            .alignContent(AlignContent.FlexEnd)
    }

    hover {
        Modifier
            .border(1.px, LineStyle.Solid, SitePalette.light.primary)
            .transform { translateY(0.px) }
    }
}

@Composable
fun ModelCard(
    model: TwinModelCardItem,
    showLock: Boolean = false,
    modifier: Modifier = Modifier,
) {
    CardLink(
        url = model.url,
        imageUrl = model.imageUrl,
        imageAltText = model.label.en,
        label = model.label,
        modifier = ModelCardLinkStyle.toModifier()
            .then(HoverBoxShadowStyle.toModifier())
                then (modifier),
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Span(
                    TextStyle.toModifier(BodyTextStyle)
                        .flexWrap(FlexWrap.Wrap)
                        .overflowWrap(OverflowWrap.BreakWord)
                        .width(80.percent)
                        .toAttrs()
                ) {
                    LangText(model.label.en, model.label.nl)
                }

                if (showLock) {
                    RoundedIcon(
                        icon = {
                            MdiLock(
                                Modifier.fontSize(16.px)
                                    .then(DeEmphasizedTextStyle.toModifier())
                            )
                        },
                        modifier = Modifier
                            .background(SitePalette.light.overlay)
                    )
                }
            }
        },
        description = {
            ApplicationFieldLabel(
                label = model.applicationArea.areaTitle,
                labelColor = getApplicationAreaColor(model.applicationArea)
            )
        },
        metaContent = {
            Box(
                Modifier.fillMaxSize().classNames(metaContentClassName),
                contentAlignment = Alignment.BottomEnd,
            ) {
                RoundedIcon {
                    MdiOpenInNew(Modifier.fontSize(16.px))
                }
            }
        }
    )
}


@Composable
private fun ApplicationFieldLabel(
    label: LocalizedText,
    labelColor: Color
) {
    Div(
        Modifier
            .display(DisplayStyle.InlineBlock)
            .padding(5.px, 8.px)
            .justifyContent(JustifyContent.Center)
            .backgroundColor(labelColor.lightened(0.85f))
            .luxBorderRadius()
            .color(labelColor)
            .fontSize(FontSize.Small)
            .toAttrs()
    ) {
        LangText(
            en = label.en,
            nl = label.nl
        )
    }
}

@Composable
private fun RoundedIcon(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
) {
    Box(
        Modifier.size(32.px)
            .borderRadius(50.percent)
            .background(Colors.White)
            .color(SitePalette.light.primary)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) { icon() }
}