package com.zenmo.web.zenmo.domains.lux.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ProfileImageStyle
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*


val ProfileImageContainerStyle = CssStyle {
    base {
        Modifier
            .size(15.cssRem)
            .borderRadius(
                50.percent
            )
            .border(
                width = 6.px,
                color = Color.white,
                style = LineStyle.Solid
            )
    }
}

//todo put this on component demo
@OptIn(DelicateApi::class)
@Composable
fun VerticalProfileContactCard(
    name: String,
    imageUrl: String,
    email: String,
    telephoneNumber: String? = null,
    enSubtitle: String? = null,
    nlSubtitle: String? = null,
    organization: @Composable () -> Unit = {},
) {
    Column(
        Modifier.Companion
            .gap(0.5.cssRem).textAlign(TextAlign.Center),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(Modifier.height(17.cssRem), contentAlignment = Alignment.Center) {
            Image(
                modifier = ProfileImageStyle.toModifier(),
                src = imageUrl,
                alt = "$name photo",
            )
        }
        if (enSubtitle != null && nlSubtitle != null) {
            LangText(en = enSubtitle, nl = nlSubtitle)
        }
        SubHeaderText(
            enText = name,
            nlText = name,
            modifier = Modifier.Companion.color(SitePalette.Companion.light.primary).margin(0.cssRem)
        )
        ContactInfo(
            email = email,
            telephoneNumber = telephoneNumber,
        )
        organization()
    }
}