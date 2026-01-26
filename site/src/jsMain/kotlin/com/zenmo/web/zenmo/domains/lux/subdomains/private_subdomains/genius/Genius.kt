package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components.GeniusHeader
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components.GeniusIntroTextBlock
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components.GeniusTextGrid
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components.PartnerLogos
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

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