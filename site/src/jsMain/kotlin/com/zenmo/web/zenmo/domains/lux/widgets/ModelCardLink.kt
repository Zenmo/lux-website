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
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.components.model.TwinModel
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.tagColor
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.styles.cubicBezierTransition
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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
    model: TwinModel,
    url: String,
    modifier: Modifier = Modifier,
) {
    CardLink(
        url = url,
        imageUrl = model.image,
        imageAltText = model.title,
        nlTitle = model.title,
        enTitle = model.title,
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
                    Text(model.title)
                }

                if (model.isPrivate) {
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
            if (model is SubdomainModel) {
                ApplicationFieldLabel(model.applicationArea)
            }
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
private fun ApplicationFieldLabel(field: ApplicationArea) {
    Div(
        Modifier
            .display(DisplayStyle.InlineBlock)
            .padding(5.px, 8.px)
            .justifyContent(JustifyContent.Center)
            .backgroundColor(field.tagColor().lightened(0.85f))
            .luxBorderRadius()
            .color(field.tagColor())
            .fontSize(FontSize.Small)
            .toAttrs()
    ) {
        LangText(
            en = field.areaTitle.en,
            nl = field.areaTitle.nl
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