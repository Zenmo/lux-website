package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.silk.components.icons.mdi.MdiChevronRight
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.thenIf
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText

@Composable
fun SideMenuNavLink(
    href: String,
    label: LocalizedText,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    Link(
        path = href,
        variant = SideMenuLinkVariant.thenIf(isActive, ActiveSideMenuLinkVariant),
        modifier = Modifier.onClick { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            LangText(label)
            MdiChevronRight()
        }
    }
}