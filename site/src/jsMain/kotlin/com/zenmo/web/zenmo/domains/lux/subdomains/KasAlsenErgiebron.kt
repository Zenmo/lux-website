package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun KasAlsenErgiebron() {
    val kasalsenergiebron = PrivateSubdomainModel.KASALSENERGIEBRON
    LuxSubdomainPageLayout(
        title = kasalsenergiebron.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = kasalsenergiebron.entryPoint,
            imageUrl = "/lux/images/models/kasals.png",
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}