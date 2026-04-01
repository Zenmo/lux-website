package energy.lux.frontend.domains.lux.sections.luxmodels.components

import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.luxmodels.FilterType


/**
 * Filters and searches a list of models based on visibility, matching title, and application area.
 *
 * Applies the selected [filterType], filters by [areas] if specified, and
 * optionally narrows the result by matching the [query] against
 * each model’s title (case-insensitive).
 */
fun filterAndSearchModels(
    models: List<TwinModelCardItem>,
    query: String,
    filterType: FilterType,
    areas: Set<LuxApplicationArea>
): List<TwinModelCardItem> {
    val queryString = query.trim().lowercase()

    return models
        .asSequence()
        .filter { model ->
            when (filterType) {
                FilterType.ALL -> true
                FilterType.PUBLIC -> !model.isPrivate
                FilterType.PRIVATE -> model.isPrivate
            }
        }
        .filter { model ->
            if (queryString.isEmpty()) return@filter true

            model.searchTokens.any { sTokens ->
                sTokens.lowercase().contains(queryString)
            }
        }
        .filter { model ->
            if (areas.isEmpty()) return@filter true
            model.applicationArea in areas
        }
        .toList()
}