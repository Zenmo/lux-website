package energy.lux.frontend.domains.lux.subdomains.public_subdomains

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.HorizontalLine
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.veenendaal
import energy.lux.frontend.domains.lux.subdomains.components.StartAnylogicSimulationOverlay
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.widgets.RadioItem
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid


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
        SubdomainModelPage(
            modelId = Uuid.NIL,
            introContent = {
                Column(
                    modifier = Modifier.gap(1.cssRem),
                ) {
                    HeaderText(
                        enText = veenendaal.label.en,
                        nlText = veenendaal.label.nl,
                        textColor = SitePalette.light.primary,
                    )
                    P {
                        LangText(
                            en = """
                                The municipality of Veenendaal wanted to explore the energy dynamics of the 
                                ‘Schepenbuurt’. We intended to get a detailed picture of the installed solar-panels,
                                 charging points, and the consumption of the households in this neighborhood. 
                            """.trimIndent(),
                            nl = """
                                De gemeente Veenendaal wilde de energiedynamiek van de Schepenbuurt verkennen. We 
                                wilden een gedetailleerd beeld krijgen van de geïnstalleerde zonnepanelen, laadpalen, 
                                en het energieverbruik van de huishoudens in deze wijk.
                            """.trimIndent()
                        )
                        Br { }
                        Br { }
                        LangText(
                            en = """
                                 The municipality was interested in the differences in energy dynamics of different 
                                 parts of this neighborhood (oost, west, zuid) and used LUX Neighbourhood to 
                                 explore some scenarios.  
                            """.trimIndent(),
                            nl = """
                                De gemeente was geïnteresseerd in de verschillen in energiedynamiek van 
                                verschillende delen van deze wijk (oost, west, zuid) en gebruikte LUX Woonwijk om 
                                enkele scenario's te verkennen.
                            """.trimIndent()
                        )
                    }
                    ImageContent(
                        imageUrl = veenendaal.imageUrl
                    )
                    P {
                        LangText(
                            en = """
                            This public model only includes public data. It allowed the municipality to explore the 
                            potential of solar panels on rooftops and to what the impact in terms of grid-load with 
                            certain electrification scenarios.
                        """.trimIndent(),
                            nl = """
                            Dit publieke model bevat alleen openbare data. Het stelde de gemeente in staat om het 
                            potentieel van zonnepanelen op daken te verkennen en wat de impact zou zijn qua
                            netbelasting bij bepaalde elektrificatiescenario's.
                        """.trimIndent()
                        )
                    }
                }
            },
            mediaContent = {
            },
            anylogicRender = {
                Column(
                    modifier = Modifier.fillMaxWidth().gap(1.cssRem),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    HorizontalLine()
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
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
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