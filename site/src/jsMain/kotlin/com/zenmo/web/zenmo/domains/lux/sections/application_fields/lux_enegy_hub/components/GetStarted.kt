package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.sections.home.faqs.LUX_GITHUB_REPO_URL
import com.zenmo.web.zenmo.domains.lux.styles.mutedWhite
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun GetStarted() {
    Column(
        Modifier
            .fillMaxWidth()
            .gap(1.cssRem)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(clamp(32.px, 5.vw, 64.px))
            .verticalLinearBackground()
            .color(Colors.White)
            .textAlign(TextAlign.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            enText = "Want to get started ?",
            nlText = "Wil je beginnen ?",
        )
        P {
            LangText(
                en = "Check out the LUX open-source GitHub repo.",
                nl = "Bekijk de open-source GitHub repo van LUX.",
            )
            Br { }

            LangText(
                en = "If you require any help, Zenmo is always happy to support the local hero.",
                nl = "Heb je hulp nodig, Zenmo helpt de lokale held graag verder.",
            )
        }

        Div(
            ResponsiveFlexStyle
                .toModifier()
                .gap(16.px)
                .justifyContent(JustifyContent.Center)
                .fillMaxWidth()
                .toAttrs(),
        ) {
            ApplicationAreaCTAButton(
                icon = { FaGithub() },
                text = LocalizedText(
                    en = "GitHub Repo",
                    nl = "GitHub Repo"
                ),
                bgColor = SitePalette.light.secondary,
                textColor = Colors.Black,
                path = LUX_GITHUB_REPO_URL
            )

            ApplicationAreaCTAButton(
                text = LocalizedText(
                    en = "Contact Zenmo",
                    nl = "Contacteer Zenmo"
                ),
                modifier = Modifier.mutedWhite()
            )
        }
    }
}