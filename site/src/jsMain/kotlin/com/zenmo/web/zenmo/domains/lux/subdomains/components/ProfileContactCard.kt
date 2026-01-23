package com.zenmo.web.zenmo.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ProfileImageStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCardImageContainerStyle
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div

enum class ProfileCardArrangementDirection {
    HORIZONTAL, VERTICAL
}

//todo put this on component demo
@OptIn(DelicateApi::class)
@Composable
fun ProfileContactCard(
    name: String,
    imageUrl: String,
    email: String,
    cardArrangementDirection: ProfileCardArrangementDirection,
) {
    val breakpoint = rememberBreakpoint()
    val isVertical = cardArrangementDirection == ProfileCardArrangementDirection.VERTICAL ||
            breakpoint < Breakpoint.MD
    Div(
        ResponsiveRowStyle.toModifier()
            .width(auto)
            .gap(clamp(2.cssRem, 5.vw, 5.cssRem))
            .justifyContent(JustifyContent.Start)
            .thenIf(
                isVertical,
                Modifier.flexDirection(FlexDirection.Column)
            )
            .toAttrs(),
    ) {
        Box(
            TeamCardImageContainerStyle.toModifier().size(18.cssRem),
        ) {
            Image(
                modifier = ProfileImageStyle.toModifier(),
                src = imageUrl,
                alt = "$name photo",
            )
        }
        Column(
            Modifier.gap(0.5.cssRem)
                .textAlign(TextAlign.Center),
            horizontalAlignment = if (isVertical)
                Alignment.CenterHorizontally else Alignment.Start
        ) {
            SubHeaderText(
                enText = "Website and model development",
                nlText = "Website en model ontwikkeling",
                modifier = Modifier.color(SitePalette.light.primary)
                    .fontSize(1.15.cssRem)
                    .margin(0.cssRem)
            )
            HeaderText(
                enText = name,
                nlText = name,
                modifier = Modifier.margin(0.cssRem)
                    .fontSize(2.5.cssRem)
            )
            Row {
                MdiMail(Modifier.padding(right = 0.25.cssRem))
                InlineLink(
                    destinationUrl = "mailto:$email",
                    enLinkText = email,
                    nlLinkText = email,
                )
            }
        }
    }
}