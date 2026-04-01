package energy.lux.frontend.theme.typography.fontstyles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.theme.typography.core.TextRole
import energy.lux.frontend.theme.typography.typography

fun <K : ComponentKind> CssStyle<K>.typographyVariants(role: TextRole) = addVariant {
    Breakpoint.entries.forEach { bp ->
        bp {
            Modifier.typography(role, bp)
        }
    }
}