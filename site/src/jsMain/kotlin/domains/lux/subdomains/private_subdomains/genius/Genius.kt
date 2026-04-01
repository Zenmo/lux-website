package energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.components.GeniusHeader
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.components.GeniusIntroTextBlock
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.components.GeniusTextGrid
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.components.PartnerLogos
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun Genius() {
    PageLayout(
        header = { GeniusHeader() },
        footer = {},
        title = "Genius"
    ) {
        PrivateTwinModelPage(
            entryPoint = PrivateSubdomainModel.GENUIS.entryPoint,
            imageUrl = "/lux/images/models/genius.png",
            introContent = { GeniusIntroTextBlock() },
            mediaContent = {
                ImageContent(
                    imageUrl = "/lux/images/afbeelding.jpeg",
                    alt = "genius campus image",
                    modifier = Modifier.fillMaxWidth()
                )
                GeniusTextGrid()
            },
            extraContent = { PartnerLogos() },
            footerContent = { ZenmoModellerProfileCard(ZenmoTeam.ATE) },
        )
    }
}