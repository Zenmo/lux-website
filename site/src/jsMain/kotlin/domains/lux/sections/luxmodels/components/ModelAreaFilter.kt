package energy.lux.frontend.domains.lux.sections.luxmodels.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.widgets.MultiSelectRow

@Composable
fun ModelAreaFilter(
    selectedOptions: Set<LuxApplicationArea>,
    onSelectionChange: (Set<LuxApplicationArea>) -> Unit,
) {
    val currentLanguage = LocalLanguage.current
    ModelFilter(
        filterLabel = LocalizedText(en = "Application Area", nl = "Toepassingsgebied")
    ) {
        MultiSelectRow(
            selectedValues = selectedOptions,
            options = LuxApplicationArea.entries.associateWith {
                when (currentLanguage) {
                    Language.Dutch -> it.label.nl
                    Language.English -> it.label.en
                }
            },
            onChange = onSelectionChange
        )
    }
}