package com.zenmo.web.ModelSearch

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.luxmodels.FilterType
import energy.lux.frontend.domains.lux.sections.luxmodels.components.filterAndSearchModels
import kotlin.test.Test
import kotlin.test.assertEquals


class ModelSearchTest {
    @Test
    fun `search finds model by title`() {
        val models = listOf(
            TwinModelCardItem(
                label = LocalizedText("Amsterdam"),
                imageUrl = "",
                url = "",
                applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
                isPrivate = false
            ),
            TwinModelCardItem(
                label = LocalizedText("Rotterdam"),
                imageUrl = "",
                url = "",
                applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
                isPrivate = false
            ),
        )

        val result = filterAndSearchModels(
            models = models,
            query = "ams",
            filterType = FilterType.ALL
        )

        assertEquals(1, result.size)
        assertEquals("Amsterdam", result.first().label.en)
    }
}