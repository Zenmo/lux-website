package energy.lux.frontend.domains.lux.subdomains.public_subdomains.amersfoort

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.components.widgets.ImageContent
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.HorizontalLine
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.amersfoort
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.subdomains.components.StartAnylogicSimulationOverlay
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.widgets.ModelCard
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
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
            modelId = selectedModel?.modelId ?: Uuid.NIL,
            introContent = {
                Div {
                    HeaderText(
                        enText = "Digital Twins Amersfoort",
                        nlText = "Digital Twins Amersfoort",
                        textColor = SitePalette.light.primary,
                    )

                    P {
                        LangText(
                            en = """
                                The municipality of Amersfoort was interested in the differences in energy dynamics 
                                per neighborhood and used LUX Neighbourhood to explore some scenarios. These public 
                                models only include public data. 
                            """.trimIndent(),
                            nl = """
                                De gemeente Amersfoort was geïnteresseerd in de verschillen in energiedynamiek per 
                                wijk en heeft LUX Woonwijk gebruikt om enkele scenario's te verkennen. Deze publieke 
                                modellen bevatten alleen openbare data.
                            """.trimIndent()
                        )
                        Br { }
                        LangText(
                            en = """
                                They allowed the municipality to explore the potential of solar panels on rooftops and 
                                to what the impact in terms of grid-load with certain electrification scenarios. 
                            """.trimIndent(),
                            nl = """
                                Ze stelden de gemeente in staat om het potentieel van zonnepanelen op daken te 
                                verkennen en wat de impact zou zijn in termen van netbelasting bij bepaalde 
                                elektrificatiescenario's.
                            """.trimIndent()
                        )
                    }
                }
            },
            mediaContent = {
                ImageContent(
                    imageUrl = amersfoort.imageUrl
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().gap(1.cssRem)
                ) {
                    HorizontalLine()
                    SubHeaderText(
                        enText = "Select a model to explore:",
                        nlText = "Selecteer een model om te verkennen:",
                    )
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
                            .fillMaxSize()
                            .position(Position.Relative),
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