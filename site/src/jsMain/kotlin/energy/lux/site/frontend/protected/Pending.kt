package energy.lux.site.frontend.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.site.frontend.components.widgets.LangText
import energy.lux.site.frontend.components.widgets.LoadingSpinner
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Pending() {
    Column(
        modifier = Modifier.fillMaxWidth().gap(0.05.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingSpinner()
        LangText(
            en = "Hang on, just a moment.",
            nl = "Even geduld, een momentje."
        )
    }
}
