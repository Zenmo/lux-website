package energy.lux.site.frontend.components.widgets.private

import androidx.compose.runtime.*
import js.import.importAsync
import js.promise.catch
import org.jetbrains.compose.web.dom.Text

external interface PrivateTextModule {
    @Composable
    fun PrivateText()
}

@Composable
fun PrivateWrapper() {
    var privateModule by remember { mutableStateOf<PrivateTextModule?>(null) }
    var error by remember { mutableStateOf<Throwable?>(null) }

    LaunchedEffect(Unit) {
        /**
         * Can't use the simpler suspend variant
         * because the KotlinJS compiler puts the argument in a temporary variable
         * and Rollup can't resolve that.
         *
         * A workaround/improvement would be to put all private entrypoints in a dedicated folder.
         */
        importAsync<PrivateTextModule>("./PrivateText.export.mjs")
            .then {
                privateModule = it
            }
            .catch {
                error = it as? Throwable
            }
    }

    if (error == null) {
        Text(error.toString())
    }

    if (privateModule == null) {
        return
    }

    privateModule!!.PrivateText()
}
