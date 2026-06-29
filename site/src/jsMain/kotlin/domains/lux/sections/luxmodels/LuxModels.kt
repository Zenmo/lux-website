package energy.lux.frontend.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.luxmodels.components.*
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


enum class FilterType {
    ALL,
    PUBLIC,
    PRIVATE
}

@Composable
fun LuxModels() {
    SectionContainer(
        modifier =
            Modifier
                .background(SitePalette.light.overlay)
    ) {
        val ctx = rememberPageContext()
        val areaParam = ctx.route.queryParams["area"]
        var query by remember { mutableStateOf("") }
        var selectedAreaOptions by remember {
            mutableStateOf(
                areaParam
                    ?.let { runCatching { LuxApplicationArea.valueOf(it) }.getOrNull() }
                    ?.let { setOf(it) }
                    ?: emptySet()
            )
        }
        var filterType by remember { mutableStateOf(FilterType.ALL) }

        val luxModels = remember(query, filterType, selectedAreaOptions) {
            filterAndSearchModels(
                models = allLuxModels,
                query = query,
                filterType = filterType,
                areas = selectedAreaOptions
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(1.cssRem),
        ) {
            HeaderText(
                enText = "Models",
                nlText = "Modellen",
            )
            Div(
                Modifier
                    .alignItems(AlignItems.Center)
                    .textAlign(TextAlign.Center)
                    .width(80.percent)
                    .maxWidth(100.percent)
                    .toAttrs()
            ) {
                P(
                    Modifier
                        .margin(0.px)
                        .toAttrs()
                ) {
                    LangText(
                        en = """
                            Discover our collection of energy models with LUX in various application areas.
                        """.trimIndent(),
                        nl = """
                            Ontdek onze collectie van energiemodellen met LUX op de verschillende toepassingsgebieden.
                        """.trimIndent()
                    )
                }
                P {
                    LangText(
                        en = """
                            There are a number of public models accessible to everyone. Most models are restricted to 
                            specific users. You can log in with your username and password. Some model pages have 
                            subpages that you can navigate to view various models.
                        """.trimIndent(),
                        nl = """
                            Er zijn een aantal publieke modellen toegankelijk voor iedereen. De meeste modellen zijn 
                            afgeschermd voor specifieke gebruikers. Met uw gebruikersnaam en wachtwoord kunt u 
                            inloggen. Sommige modelpagina's hebben nog subpagina's waarheen u kunt navigeren om 
                            verschillende modellen te bekijken.
                        """.trimIndent()
                    )
                }
            }

            SearchBar(
                query = query,
                onQueryChange = { query = it }
            )

            ModelAccessFilter(
                filterType = filterType,
                onFilterChange = { filterType = it }
            )
            ModelAreaFilter(
                selectedOptions = selectedAreaOptions,
                onSelectionChange = { selectedAreaOptions = it }
            )
        }

        if (luxModels.isNotEmpty()) {
            TwinModelsGrid(
                models = luxModels,
            )
        } else {
            EmptyResults()
        }
    }
}