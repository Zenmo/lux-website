package com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components

import com.zenmo.web.zenmo.domains.lux.components.model.TwinModel
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.FilterType


/**
 * Filters and searches a list of models based on visibility and title.
 *
 * Applies the selected [filterType] and
 * optionally narrows the result by matching the [query] against
 * each model’s title (case-insensitive).
 */
fun filterAndSearchModels(
    models: List<TwinModel>,
    query: String,
    filterType: FilterType
): List<TwinModel> {
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
        .toList()
}