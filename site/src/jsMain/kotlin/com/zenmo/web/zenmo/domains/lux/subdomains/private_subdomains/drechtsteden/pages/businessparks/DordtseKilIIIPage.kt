package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.BusinessParkModelPageText
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun DordtseKilIIIPage() {
    ModelInDevelopmentInfoWidget(
        enDescription = "Note, this model is still in development.",
        nlDescription = "Let op, dit model is nog in ontwikkeling.",
    )
    DrechtstedenTwinModelPage(
        twin = dordtseKil34,
        introContent = { BusinessParkModelPageText() },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}