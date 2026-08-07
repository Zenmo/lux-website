package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.pages.application_fields.components.PeterContactCard
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid

@Composable
fun RegioFoodValleyHomePage() {
    SubdomainModelPage(
        introContent = {
            HeaderText(nlText = PrivateSubdomainModel.REGIOFOODVALLEY.label.nl)
            P {
                LangText(
                    nl = "Kom binnenkort terug om meer te zien.",
                    en = "Come back soon to see more.",
                )
            }
        },
        modelId = Uuid.NIL,
        anylogicRender = {},
        footerContent = { ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN) }
    )
}