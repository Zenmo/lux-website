package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun Cognizant() {
    LuxSubdomainPageLayout(
        title = "Cognizant",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            AnyLogicEmbed(
                modelId = Uuid.parse("7cfc3e4a-608c-4e2c-a834-4d290174ee9e"),
                apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 5.cssRem)
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