package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.ModelWrapper
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun PreZero() {
    LuxSubdomainPageLayout(
        title = "PreZero",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            ModelWrapper(
                imgUrl = SubdomainModel.PreZero.image,
                entryPoint = SubdomainModel.PreZero.entryPoint!!
            )

            ProfileContactCard(
                name = ZenmoTeam.LUC.memberName,
                imageUrl = ZenmoTeam.LUC.image,
                email = ZenmoTeam.LUC.email,
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}