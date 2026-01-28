package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import kotlin.uuid.Uuid

@Composable
fun NijmegenHengstdal() {
    SubdomainModelPage(
        modelId = Uuid.parse("3801076e-44db-4b42-a27f-5be2b6c82a5c"),
        introContent = {
            SubHeaderText(
                enText = "Nijmegen Hengstdal",
                nlText = "Nijmegen Hengstdal",
            )
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
        },
    )
}
