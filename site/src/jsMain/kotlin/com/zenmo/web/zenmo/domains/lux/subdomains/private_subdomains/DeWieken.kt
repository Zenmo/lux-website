package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P

@Composable
fun DeWieken() {
    val deWieken = PrivateSubdomainModel.DE_WIEKEN
    LuxSubdomainPageLayout(
        title = deWieken.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = deWieken.entryPoint,
            imageUrl = deWieken.imageUrl,
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.LUC)
            }
        )
    }
}
