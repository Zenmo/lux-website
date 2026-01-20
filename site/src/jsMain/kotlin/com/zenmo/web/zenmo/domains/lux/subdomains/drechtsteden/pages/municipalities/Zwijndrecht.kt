package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ModelWrapper
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun Zwijndrecht() {
    DrechtstedenTwinLayout(
        title = zwijndrecht.label.nl,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = zwijndrecht.label.en,
        nlTwinPageHeaderTitle = zwijndrecht.label.nl,
    ) {

        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {

            ModelWrapper(
                imgUrl = zwijndrecht.imageUrl,
                entryPoint = zwijndrecht.entryPoint,
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