package energy.lux.frontend.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.core.model.subdomain.subdomainModels
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.drechtstedenModels
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.domains.lux.sections.luxmodels.components.EmptyResults
import energy.lux.frontend.domains.lux.sections.luxmodels.components.ModelAccessFilter
import energy.lux.frontend.domains.lux.sections.luxmodels.components.ModelAreaFilter
import energy.lux.frontend.domains.lux.sections.luxmodels.components.SearchBar
import energy.lux.frontend.domains.lux.sections.luxmodels.components.filterAndSearchModels
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P


enum class FilterType {
    ALL,
    PUBLIC,
    PRIVATE
}


@Composable
fun LuxModels() {
    LuxSectionContainer(
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
        val allModels = (subdomainModels + drechtstedenModels)
            .map { it.toTwinModelCardItem() }
        var filterType by remember { mutableStateOf(FilterType.ALL) }

        val luxModels = remember(query, filterType, selectedAreaOptions) {
            filterAndSearchModels(
                models = allModels,
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
            P(
                Modifier
                    .margin(0.px)
                    .toAttrs()
            ) {
                LangText(
                    en = "Explore our collection of energy models for different regions and applications.",
                    nl = "Ontdek onze collectie energiemodellen voor verschillende regio's en toepassingen."
                )
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