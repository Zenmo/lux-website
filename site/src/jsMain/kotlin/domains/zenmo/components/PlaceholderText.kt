package energy.lux.frontend.domains.zenmo.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText


@Composable
fun PlaceholderText(
    repeat: Int = 1,
    text: String = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 
        magna aliqua. 
    """.trimIndent(),
) {
    val placeHolderText = text.repeat(repeat)
    LangText(
        en = placeHolderText,
        nl = placeHolderText
    )
}