package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.core.isPrivate
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.empoweredDomain
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.nijmegenHengstdalMenuItem
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import kotlin.uuid.Uuid


val nijmegenHengstdalModel = TwinModelCardItem(
    label = nijmegenHengstdalMenuItem.route.label,
    imageUrl = "/lux/images/nijmegenHengstdal.png",
    url = localizedUrl(empoweredDomain, nijmegenHengstdalMenuItem.route.path),
    applicationArea = empowered.applicationArea,
    modelId = Uuid.parse("3801076e-44db-4b42-a27f-5be2b6c82a5c"),
    isPrivate = empowered.isPrivate
)

@Composable
fun NijmegenHengstdal() {
    SubdomainModelPage(
        modelId = nijmegenHengstdalModel.modelId,
        introContent = {
            SubHeaderText(nlText = nijmegenHengstdalModel.label.nl)
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        },
    )
}