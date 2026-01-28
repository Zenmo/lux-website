package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.empowered
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.EmpoweredHeader
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.EmpoweredTextGrid
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.LearnMoreAboutEmpowered
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import kotlin.uuid.Uuid

@Composable
fun EmpoweredIndex() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        anylogicRender = {},
        introContent = {
            EmpoweredHeader()
        },
        mediaContent = {
            ImageContent(
                imageUrl = empowered.imageUrl
            )
        },
        extraContent = {
            EmpoweredTextGrid()
            LearnMoreAboutEmpowered()
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        },
    )
}