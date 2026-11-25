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
import energy.lux.frontend.domains.zenmo.widgets.orchestrator.OrchestratorModelEmbed
import energy.lux.frontend.core.models.ZenmoTeamMember
import kotlin.uuid.Uuid


val nijmegenHengstdalModel = TwinModelCardItem(
    label = nijmegenHengstdalMenuItem.route.label,
    imageUrl = "/lux/images/nijmegenHengstdal.png",
    url = localizedUrl(empoweredDomain, nijmegenHengstdalMenuItem.route.path),
    applicationArea = empowered.applicationArea,
    modelId = Uuid.parse("3801076e-44db-4b42-a27f-5be2b6c82a5c"),
    isPrivate = empowered.isPrivate
)

/** EmPowerED model as configured in the LUX Orchestrator: container image name and tag */
private const val EMPOWERED_ORCHESTRATOR_MODEL_ID = "ghcr.io/zenmo/empowered"
private const val EMPOWERED_ORCHESTRATOR_VERSION_ID = "main-latest"

@Composable
fun NijmegenHengstdal() {
    SubdomainModelPage(
        modelId = nijmegenHengstdalModel.modelId,
        introContent = {
            SubHeaderText(nijmegenHengstdalModel.label)
        },
        modelContent = {
            OrchestratorModelEmbed(
                modelId = EMPOWERED_ORCHESTRATOR_MODEL_ID,
                versionId = EMPOWERED_ORCHESTRATOR_VERSION_ID,
            )
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeamMember.NAUD_LOOMANS)
        },
    )
}