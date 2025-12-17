package energy.lux.site.frontend.domains.lux.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast

@Composable
fun WideScreenHeaderComponents(
    content: @Composable () -> Unit,
) =
    LuxHeaderComponent(
        content = content,
        modifier = Modifier
            .displayIfAtLeast(Breakpoint.MD)
    )
