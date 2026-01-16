package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ModelWrapper
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.borchwerf
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun Borchwerf() {
    LuxSubdomainPageLayout(
        title = "Borchwerf",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            ModelWrapper(
                imgUrl = borchwerf.imageUrl,
                entryPoint = borchwerf.entryPoint,
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