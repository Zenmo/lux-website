package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.amersfoort

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.subdomains.components.StartAnylogicSimulationOverlay
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.widgets.ModelCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid


@Composable
fun Amersfoort() {
    val amersfoortModels = AmersfoortTwinModel.amersfoortTwinModels
    LuxSubdomainPageLayout(
        title = "Home",
    ) {
        var selectedModel by remember { mutableStateOf<AmersfoortTwinModel?>(null) }
        var runningModelId by remember { mutableStateOf<Uuid?>(null) }

        SubdomainModelPage(
            modelId = Uuid.NIL,
            introContent = {
                HeaderText(
                    enText = "Digital Twins Amersfoort",
                    nlText = "Digital Twins Amersfoort",
                    modifier = Modifier.margin(0.cssRem)
                )

                P {
                    LangText(
                        en = """
                        This is an overview page of all digital twins created in collaboration with Amersfoort.
                    """.trimIndent(),
                        nl = """
                        Dit is een overzichtspagina van alle digital twins gemaakt in samenwerking met de Amersfoort
                    """.trimIndent()
                    )
                }
            },
            mediaContent = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    P {
                        LangText(
                            en = "Select a model to explore:",
                            nl = "Selecteer een model om te verkennen:",
                        )
                    }
                    AmersfoortModelsTabRow(
                        models = amersfoortModels,
                        selectedModel = selectedModel,
                        onModelSelected = { model ->
                            selectedModel = model
                            /**
                             * First-ever selection starts the simulation immediately.
                             * Subsequent selections only change the active tab, this way
                             * the [StartAnylogicSimulationOverlay] will appear if the
                             * running model differs.
                             */
                            if (runningModelId == null) {
                                runningModelId = model.modelId
                            }
                        }
                    )
                }
            },
            anylogicRender = {
                selectedModel?.let { model ->
                    val isOutOfSync = runningModelId != null && runningModelId != model.modelId

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .position(Position.Relative)
                            .height(80.vh)
                            .margin(topBottom = 3.cssRem),
                        contentAlignment = Alignment.Center
                    ) {
                        AnyLogicEmbed(
                            modelId = runningModelId ?: model.modelId,
                        )

                        if (isOutOfSync) {
                            StartAnylogicSimulationOverlay(
                                onSimulateClick = {
                                    runningModelId = model.modelId
                                },
                                enabled = true
                            )
                        }
                    }
                }
            },
            footerContent = { ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN) }
        )
    }
}


@Composable
private fun AmersfoortModelsTabRow(
    models: List<AmersfoortTwinModel>,
    selectedModel: AmersfoortTwinModel?,
    onModelSelected: (AmersfoortTwinModel) -> Unit,
) {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 2, md = 3, lg = 3, xl = 3),
        modifier = Modifier.gap(2.cssRem)
    ) {
        models.forEach { model ->
            val isActive = model == selectedModel
            ModelCard(
                model = model.toTwinModelCardItem(),
                modifier = Modifier
                    .onClick { onModelSelected(model) }
                    .thenIf(
                        isActive,
                        Modifier.border(
                            width = 3.px,
                            style = LineStyle.Solid,
                            color = SitePalette.light.primary
                        )
                    )
            )
        }
    }
}