package com.zenmo.web.ModelSearch

import com.zenmo.web.zenmo.domains.lux.components.model.SimpleTwin
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.FilterType
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components.filterAndSearchModels
import kotlin.test.Test
import kotlin.test.assertEquals


class ModelSearchTest {
    @Test
    fun `search finds model by title`() {
        val models = listOf(
            SimpleTwin("Amsterdam", ""),
            SimpleTwin("Rotterdam", "")
        )

        val result = filterAndSearchModels(
            models = models,
            query = "ams",
            filterType = FilterType.ALL
        )

        assertEquals(1, result.size)
        assertEquals("Amsterdam", result.first().title)
    }
}