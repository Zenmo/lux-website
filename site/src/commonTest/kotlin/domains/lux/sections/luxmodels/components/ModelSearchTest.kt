package energy.lux.frontend.domains.lux.sections.luxmodels.components

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.luxmodels.FilterType
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
            filterType = FilterType.ALL,
            areas = setOf(LuxApplicationArea.LUX_NEIGHBOURHOOD),
        )

        assertEquals(1, result.size)
        assertEquals("Amsterdam", result.first().label.en)
    }
}
