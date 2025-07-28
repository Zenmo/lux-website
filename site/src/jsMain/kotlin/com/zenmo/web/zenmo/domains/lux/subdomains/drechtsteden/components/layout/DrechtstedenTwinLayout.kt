package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.HeaderInnerStyle
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeaderPaddingStyle
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxLogo
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.DrechtstedenHeader
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.pages.SiteGlobals
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Header

@Composable
fun DrechtstedenTwinLayout(
    title: String,
    useTwinPageHeader: Boolean = false,
    enTwinPageHeaderTitle: String = "",
    nlTwinPageHeaderTitle: String = "",
    content: @Composable () -> Unit,
) {
    PageLayout(
        header = {
            if (useTwinPageHeader) {
                TwinModelPageHeader(
                    enTitle = enTwinPageHeaderTitle,
                    nlTitle = nlTwinPageHeaderTitle,
                )
            } else {
                DrechtstedenHeader()
            }
        },
        footer = {},
        title = "Drechtsteden - $title",
    ) {
        content()
    }
}

@Composable
private fun TwinModelPageHeader(
    enTitle: String,
    nlTitle: String,
) {
    Header(
        attrs = NavHeaderStyle.toModifier()
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // would it be better to wrap this in a clickable box and use window.history.back()?
            LuxLogo(asLink = true, domain = "${LuxSubdomains.DRECHTSTEDEN.domainName}.${SiteGlobals.LUX_DOMAIN}")
            SubHeaderText(
                enText = enTitle,
                nlText = nlTitle,
                modifier = Modifier.margin(0.px).textAlign(TextAlign.Center),
            )
            LanguageSwitchButton()
        }
    }
}