package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ModelWrapper
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun Kerkbuurt() {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant
    ) {
        ModelWrapper(
            imgUrl = kerkbuurt.imageUrl,
            entryPoint = kerkbuurt.entryPoint,
        )
        ProfileContactCard(
            name = ZenmoTeam.NAUD_LOOMANS.memberName,
            imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
            email = ZenmoTeam.NAUD_LOOMANS.email,
            enSubtitle = "Website and model development",
            nlSubtitle = "Website en model ontwikkeling",
        )
    }
}