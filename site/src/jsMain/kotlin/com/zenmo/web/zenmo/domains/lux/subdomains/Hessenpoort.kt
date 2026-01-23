package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun Hessenpoort() {
    val hessenpoort = PrivateSubdomainModel.HESSENPOORT
    LuxSubdomainPageLayout(
        title = hessenpoort.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = hessenpoort.entryPoint,
            imageUrl = "/lux/images/models/hessenpoort.png",
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.ATE)
            }
        )
    }
}