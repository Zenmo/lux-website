package energy.lux.frontend.protected

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import js.promise.Promise
import org.jetbrains.compose.web.dom.Div

/**
 * Marks the spinner while a page's code is loading.
 * The prerender task (PageRenderer in prerender/) waits until none is left.
 */
const val PENDING_MODULE_ATTRIBUTE = "data-pending-module"

@Composable
fun <T : Any> LazyModule(
    load: () -> Promise<T>,
    content: @Composable T.() -> Unit,
) {
    var module by remember { mutableStateOf<T?>(null) }
    LaunchedEffect(Unit) {
        load().then { m -> module = m }
    }
    if (module == null) {
        Div({ attr(PENDING_MODULE_ATTRIBUTE, "") }) { Pending() }
        return
    }
    module!!.content()
}