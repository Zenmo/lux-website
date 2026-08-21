package energy.lux.frontend.protected

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import js.promise.Promise

@Composable
fun <T : Any> LazyModule(
    load: () -> Promise<T>,
    content: @Composable T.() -> Unit,
) {
    var module by remember { mutableStateOf<T?>(null) }
    LaunchedEffect(Unit) {
        load().then { m -> module = m }
    }
    if (module == null) { Pending(); return }
    module!!.content()
}