package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.core.isPrivate
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.bronckhorstMenuItem
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.empoweredDomain
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.dom.P


val bronckhorstModel = TwinModelCardItem(
    label = bronckhorstMenuItem.route.label,
    imageUrl = "/lux/images/bronckhorst.jpg",
    url = localizedUrl(empoweredDomain, bronckhorstMenuItem.route.path),
    applicationArea = empowered.applicationArea,
    isPrivate = empowered.isPrivate
)

@Composable
fun Bronckhorst() {
    SectionContainer {
        SubHeaderText(nlText = bronckhorstModel.label.nl)
        P {
            LangText(
                nl = "Kom binnenkort terug om meer te zien.",
                en = "Come back soon to see more.",
            )
        }
    }
}