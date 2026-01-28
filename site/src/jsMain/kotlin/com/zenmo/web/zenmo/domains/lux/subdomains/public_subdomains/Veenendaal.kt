package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.veenendaal
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.components.StartAnylogicSimulationOverlay
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.widgets.RadioItem
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text


@Composable
fun Veenendaal() {
    LuxSubdomainPageLayout(
        title = veenendaal.label.nl,
    ) {
        var selectedOptions by remember { mutableStateOf(setOf(selectableInputsOptions.keys.first())) }
        var currentSimulationOptions by remember { mutableStateOf(selectedOptions) }
        var simulationOutOfSync by remember { mutableStateOf(false) }

        LaunchedEffect(selectedOptions) {
            if (selectedOptions != currentSimulationOptions) {
                simulationOutOfSync = true
            }
        }

        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            HeaderText(
                enText = "Digital Twins Veenendaal",
                nlText = "Digital Twins Veenendaal",
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SubHeaderText(enText = "Schepenbuurt", nlText = "Schepenbuurt")
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.gap(1.cssRem)
                ) {
                    LangText(
                        en = "Select the areas:",
                        nl = "Selecteer de gebieden:"
                    )
                    MultiSelectRow(
                        selectedValues = selectedOptions,
                        options = selectableInputsOptions,
                        onChange = { newValues ->
                            selectedOptions = newValues
                        }
                    )
                }

                Box(
                    Modifier
                        .fillMaxWidth()
                        .position(Position.Relative)
                        .height(80.vh)
                        .margin(topBottom = 3.cssRem),
                    contentAlignment = Alignment.Center
                ) {
                    AnyLogicEmbed(
                        modelId = veenendaal.modelId,
                        inputs = selectableInputsOptions.keys.associateWith { option ->
                            (option in currentSimulationOptions)
                        },
                    )

                    if (simulationOutOfSync) {
                        StartAnylogicSimulationOverlay(
                            onSimulateClick = {
                                currentSimulationOptions = selectedOptions
                                simulationOutOfSync = false
                            },
                            enabled = selectedOptions.isNotEmpty()
                        )
                    }
                }
            }
            ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
        }
    }
}

private val selectableInputsOptions = mapOf(
    "Schepenbuurt-Oost" to "Oost",
    "Schepenbuurt-West" to "West",
    "Schepenbuurt-Zuid" to "Zuid"
)

@Composable
private fun <T> MultiSelectRow(
    selectedValues: Set<T>,
    options: Map<T, String>,
    onChange: (Set<T>) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.gap(0.5.cssRem)
    ) {
        options.forEach { (optionValue, displayName) ->
            val isSelected = optionValue in selectedValues
            RadioItem(
                onClick = {
                    val selection = selectedValues.toMutableSet()
                    if (isSelected) {
                        selection.remove(optionValue)
                    } else {
                        selection.add(optionValue)
                    }
                    onChange(selection)
                },
                isSelected = isSelected,
            ) {
                Text(displayName)
            }
        }
    }
}