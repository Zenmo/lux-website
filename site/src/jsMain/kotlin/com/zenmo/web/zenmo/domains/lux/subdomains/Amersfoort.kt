package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.AmersfoortTwinModel
import com.zenmo.web.zenmo.domains.lux.components.model.ModelCardLink
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P


@Composable
fun Amersfoort() {
    LuxSubdomainPageLayout(
        title = "Home",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            var activeModelTabIndex by remember { mutableStateOf(0) }
            val activeModel = AmersfoortTwinModel.amersfoortTwinModels[activeModelTabIndex]

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

            AmersfoortModelsTabRow(
                activeModelTabIndex = activeModelTabIndex,
                onTabSelected = { newIndex ->
                    activeModelTabIndex = newIndex
                }
            )

            AnyLogicEmbed(
                modelId = activeModel.modelId,
                apiKey = activeModel.modelApiKey,
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


@Composable
private fun AmersfoortModelsTabRow(
    activeModelTabIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    val models = AmersfoortTwinModel.amersfoortTwinModels
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 2, md = 3, lg = 3, xl = 3),
        modifier = Modifier.Companion.gap(2.cssRem)
    ) {
        models.forEachIndexed { index, model ->
            val isActive = index == activeModelTabIndex
            ModelCardLink(
                url = "",
                model = model,
                modifier = Modifier.fillMaxHeight()
                    .onClick {
                        onTabSelected(index)
                    }
                    .thenIf(
                        isActive,
                        Modifier.border(
                            width = 3.px,
                            style = LineStyle.Solid,
                            color = SitePalette.light.primary
                        )
                            .borderRadius(24.px)
                    )
            )
        }
    }
}