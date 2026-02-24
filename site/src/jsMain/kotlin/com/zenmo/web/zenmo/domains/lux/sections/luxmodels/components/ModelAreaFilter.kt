package com.zenmo.web.zenmo.domains.lux.sections.luxmodels.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.Language
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.widgets.MultiSelectRow

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