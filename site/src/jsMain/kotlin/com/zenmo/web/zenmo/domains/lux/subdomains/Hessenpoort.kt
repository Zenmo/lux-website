package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ModelWrapper
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.hessenpoort
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun Hessenpoort() {
    LuxSubdomainPageLayout(
        title = hessenpoort.label.nl,
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            ModelWrapper(
                imgUrl = hessenpoort.imageUrl,
                entryPoint = hessenpoort.entryPoint
            )

            ProfileContactCard(
                name = ZenmoTeam.ATE.memberName,
                imageUrl = ZenmoTeam.ATE.image,
                email = ZenmoTeam.ATE.email,
                telephoneNumber = "+31 6 14910380",
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}