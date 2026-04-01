package energy.lux.frontend.domains.lux.sections.luxmodels.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLock
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.luxmodels.FilterType
import energy.lux.frontend.domains.lux.widgets.RadioRow
import org.jetbrains.compose.web.css.px

@Composable
fun ModelAccessFilter(
    filterType: FilterType,
    onFilterChange: (FilterType) -> Unit
) {
    ModelFilter(
        filterLabel = LocalizedText(en = "Access", nl = "Toegang")
    ) {
        RadioRow(
            value = filterType,
            options = FilterType.entries.associateWith { it.name },
            onChange = onFilterChange
        ) { option, _ ->
            when (option) {
                FilterType.ALL -> LangText(en = "All", nl = "Alle")
                FilterType.PUBLIC -> LangText(en = "Public", nl = "Openbaar")
                FilterType.PRIVATE -> Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.px)
                ) {
                    MdiLock(Modifier.fontSize(16.px))
                    LangText(en = "Private", nl = "Privé")
                }
            }
        }
    }
}