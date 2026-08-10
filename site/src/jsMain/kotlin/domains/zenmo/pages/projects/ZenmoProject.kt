package energy.lux.frontend.domains.zenmo.pages.projects

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoProjectsMenuItem
import energy.lux.frontend.pages.SiteGlobals
import kotlinx.browser.window

sealed interface ZenmoProject {
    val imageUrl: String
    val categoryText: LocalizedText
    val titleText: LocalizedText
    val descriptionText: LocalizedText

    // default placeholder values, will be removed when content is added
    data class External(
        override val imageUrl: String = "",
        override val categoryText: LocalizedText = LocalizedText(nl = "Lorem ipsum"),
        override val titleText: LocalizedText = LocalizedText(nl = "Lorem ipsum dolor sit amet"),
        override val descriptionText: LocalizedText =
            LocalizedText(
                nl = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore 
                    et dolore magna aliqua.
                """.trimIndent(),
            ),
        val url: String = "",
    ) : ZenmoProject

    class Internal(
        override val imageUrl: String = "",
        override val categoryText: LocalizedText = LocalizedText(nl = "Lorem ipsum"),
        override val titleText: LocalizedText = LocalizedText(nl = "Lorem ipsum dolor sit amet"),
        override val descriptionText: LocalizedText =
            LocalizedText(
                nl = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore 
                    et dolore magna aliqua.
                """.trimIndent(),
            ),
        val path: String = "",
        val pageComponent: @Composable () -> Unit,
    ) : ZenmoProject {
        val url: String
            get() = "${window.location.protocol}//${SiteGlobals.ZENMO_DOMAIN}${zenmoProjectsMenuItem.route.path}$path"
    }
}