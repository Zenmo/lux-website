package com.zenmo.web.zenmo.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.domains.zenmo.sections.Footer
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeader
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.pages.isLocalOrPreviewEnvironment
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.percent


@Composable
fun PageLayout(
    title: String,
    header: @Composable () -> Unit = { NavHeader() },
    footer: @Composable () -> Unit = { Footer(Modifier.fillMaxWidth().gridRow(2)) },
    content: @Composable ColumnScope.() -> Unit,
) {
    LaunchedEffect(title) {
        document.title = documentTitleByDomain(title)
    }
    Box(
        Modifier
            .fillMaxWidth()
            .minHeight(100.percent)
            .gridTemplateRows { size(1.fr); size(minContent) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxSize().gridRow(1),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            header()
            content()
        }
        footer()
    }
}

private fun documentTitleByDomain(extraTitle: String): String {
    val domain = window.location.host
    val previewText = when (isLocalOrPreviewEnvironment()) {
        true -> "Preview | "
        false -> ""
    }
    return when {
        domain == SiteGlobals.ZENMO_DOMAIN -> "${previewText}Zenmo - $extraTitle"
        domain == SiteGlobals.LUX_DOMAIN -> "${previewText}LUX Energy"
        domain.endsWith(".${SiteGlobals.LUX_DOMAIN}") -> "$extraTitle | LUX Energy"
        else -> "Unknown"
    }
}