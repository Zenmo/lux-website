package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.OssGisMapModule.showOssMap
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLElement

@JsModule("@zenmo/oss-gis-map")
external object OssGisMapModule {
    fun showOssMap(element: HTMLElement)
}

@Composable
fun OssGisMap() {
    Box(
        modifier = Modifier
            .height(500.px)
            .width(100.percent),
        ref = ref { showOssMap(it) }
    )
}
