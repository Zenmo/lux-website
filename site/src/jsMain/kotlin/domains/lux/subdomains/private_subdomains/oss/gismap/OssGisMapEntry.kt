package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.gismap

import energy.lux.site.shared.AccessPolicy
import org.w3c.dom.HTMLElement

@JsModule("@zenmo/oss-gis-map")
private external object OssGisMapJs {
    fun showOssMap(element: HTMLElement)
}

@JsExport
val accessPolicy = AccessPolicy.Public()

@JsExport
fun showOssMap(element: HTMLElement) = OssGisMapJs.showOssMap(element)
