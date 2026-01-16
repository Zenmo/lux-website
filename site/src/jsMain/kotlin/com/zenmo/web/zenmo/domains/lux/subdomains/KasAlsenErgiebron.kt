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
fun KasAlsenErgiebron() {
    val kasalsenergiebron = PrivateSubdomainModel.KASALSENERGIEBRON
    LuxSubdomainPageLayout(
        title = kasalsenergiebron.label.nl,
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            ModelWrapper(
                imgUrl = kasalsenergiebron.imageUrl,
                entryPoint = kasalsenergiebron.entryPoint
            )

            ProfileContactCard(
                name = ZenmoTeam.PETER_HOGEVEEN.memberName,
                imageUrl = ZenmoTeam.PETER_HOGEVEEN.image,
                email = ZenmoTeam.PETER_HOGEVEEN.email,
                telephoneNumber = "+31 652381249",
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}