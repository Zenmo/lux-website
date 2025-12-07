package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.navbar_actions.NavBarActionsMenuWidget
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxLogo
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.LuxHeaderComponent
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals
import org.jetbrains.compose.web.css.px

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
                LuxHeader()
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
    LuxHeaderComponent {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            LuxLogo(
                domain = "${SubdomainModel.Drechtsteden.title}.${SiteGlobals.LUX_DOMAIN}"
            )
            SubHeaderText(
                enText = enTitle,
                nlText = nlTitle,
                modifier = Modifier.margin(0.px)
                    .textAlign(TextAlign.Center)
                    .displayIfAtLeast(Breakpoint.MD),
            )
            NavBarActionsMenuWidget()
        }
    }
}