package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import js.import.importAsync
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLElement

private external interface OssGisMapEntryModule {
    fun showOssMap(element: HTMLElement)
}

@Composable
fun OssGisMap() {
    Box(
        modifier = Modifier
            .height(500.px)
            .width(100.percent),
        ref = ref { el ->
            importAsync<OssGisMapEntryModule>("./gismap/OssGisMapEntry.export.mjs")
                .then { module -> module.showOssMap(el) }
        }
    )
}
