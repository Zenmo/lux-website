package com.zenmo.web.ModelSearch

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.FilterType
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components.filterAndSearchModels
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
                applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA,
                isPrivate = false
            ),
            TwinModelCardItem(
                label = LocalizedText("Rotterdam"),
                imageUrl = "",
                url = "",
                applicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA,
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