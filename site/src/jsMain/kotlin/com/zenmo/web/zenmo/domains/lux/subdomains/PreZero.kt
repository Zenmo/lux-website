package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ModelWrapper
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun PreZero() {
    val prezero = PrivateSubdomainModel.PREZERO
    LuxSubdomainPageLayout(
        title = prezero.label.nl,
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            ModelWrapper(
                imgUrl = prezero.imageUrl,
                entryPoint = prezero.entryPoint
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