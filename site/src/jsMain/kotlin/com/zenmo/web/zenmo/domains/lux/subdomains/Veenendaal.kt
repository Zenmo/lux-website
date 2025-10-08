package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.RadioRow
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid


@Composable
fun Veenendaal() {
    LuxSubdomainPageLayout(
        title = "Home",
    ) {
        var selectedOption by remember { mutableStateOf(selectableInputsOptions.keys.first()) }
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            HeaderText(
                enText = "Digital Twins Veenendaal",
                nlText = "Digital Twins Veenendaal",
                modifier = Modifier.margin(0.cssRem)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SubHeaderText(enText = "Schepenbuurt", nlText = "Schepenbuurt")
                RadioRow(
                    value = selectedOption,
                    options = selectableInputsOptions,
                    onChange = { newValue ->
                        selectedOption = newValue
                    }
                )
                AnyLogicEmbed(
                    modelId = Uuid.parse("0bec54a4-af5d-47fd-8af1-dfb3af0457f6"),
                    inputs = mapOf(
                        selectedOption to true
                    ),
                )
            }
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

private val selectableInputsOptions = mapOf(
    "Schepenbuurt-Oost" to "Oost",
    "Schepenbuurt-West" to "West",
    "Schepenbuurt-Zuid" to "Zuid"
)

