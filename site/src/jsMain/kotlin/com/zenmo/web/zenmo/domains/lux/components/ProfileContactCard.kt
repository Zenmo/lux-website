package com.zenmo.web.zenmo.domains.lux.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPhone
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ProfileImageStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCardImageContainerStyle
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Text

//todo put this on component demo
@Composable
fun ProfileContactCard(
    name: String,
    imageUrl: String,
    email: String,
    telephoneNumber: String? = null,
    enSubtitle: String? = null,
    nlSubtitle: String? = null,
    organization: @Composable () -> Unit = {},
) {
    MediaContentLayout(
        imageUrl = imageUrl,
        visualContent = {
            Box(TeamCardImageContainerStyle.toModifier().size(18.cssRem)) {
                Image(
                    modifier = ProfileImageStyle.toModifier(),
                    src = imageUrl,
                    alt = "$name photo",
                )
            }
        },
        title = {
            HeaderText(
                enText = name,
                nlText = name,
                modifier = Modifier.margin(0.cssRem).fontSize(2.5.cssRem)
            )
        },
        subtitle = {
            if (enSubtitle != null && nlSubtitle != null) {
                SubHeaderText(
                    enText = enSubtitle,
                    nlText = nlSubtitle,
                    modifier = Modifier.color(SitePalette.light.primary)
                        .fontSize(1.15.cssRem)
                        .margin(0.cssRem)
                )
            }
        },
        description = {
            Column(Modifier.gap(0.5.cssRem)) {
                ContactInfo(
                    email = email,
                    telephoneNumber = telephoneNumber,
                )
                organization()
            }
        },
        actionText = {},
        reversed = false,
    )
}

@Composable
fun ContactInfo(
    email: String,
    telephoneNumber: String? = null,
) {
    Column(Modifier.gap(0.5.cssRem)) {
        if (telephoneNumber != null) {
            Row {
                MdiPhone(Modifier.padding(right = 0.25.cssRem))
                Text(telephoneNumber)
            }
        }
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