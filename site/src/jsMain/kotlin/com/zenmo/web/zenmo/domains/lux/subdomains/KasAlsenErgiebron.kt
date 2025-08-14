package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.ModelWrapper
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem

@Composable
fun KasAlsenErgiebron() {
    LuxSubdomainPageLayout(
        title = "Kas als Energiebron",
    ) {
        SectionContainer(
            modifier = Modifier.gap(5.cssRem),
            variant = LuxSectionContainerStyleVariant
        ) {
            ModelWrapper(
                imgUrl = SubdomainModel.KasAlsEnergiebron.image,
                entryPoint = SubdomainModel.KasAlsEnergiebron.entryPoint!!
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