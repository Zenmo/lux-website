package energy.lux.frontend.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Text

@Composable
fun <T> MultiSelectRow(
    selectedValues: Set<T>,
    options: Map<T, String>,
    onChange: (Set<T>) -> Unit,
    modifier: Modifier = Modifier.Companion,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.gap(0.5.cssRem)
    ) {
        options.forEach { (optionValue, displayName) ->
            val isSelected = optionValue in selectedValues
            RadioItem(
                onClick = {
                    val selection = selectedValues.toMutableSet()
                    if (isSelected) {
                        selection.remove(optionValue)
                    } else {
                        selection.add(optionValue)
                    }
                    onChange(selection)
                },
                isSelected = isSelected,
            ) {
                Text(displayName)
            }
        }
    }
}