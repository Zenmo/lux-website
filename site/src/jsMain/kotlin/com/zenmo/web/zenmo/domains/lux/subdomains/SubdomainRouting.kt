package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.brabant.BrabantRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.DrechtstedenContent
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.GeniusIndex


enum class LuxSubdomains(val domainName: String) {
    DRECHTSTEDEN("drechtsteden"),
    GENIUS("genius"),
    HESSENPOORT("hessenpoort"),
    BRABANT("brabant"),
    BUNDERBUURTEN("bunderbuurten"),
}

@Composable
fun LuxSubdomainRoutingComponent(subdomain: LuxSubdomains) {
    when (subdomain) {
        LuxSubdomains.DRECHTSTEDEN -> DrechtstedenRouting()
        LuxSubdomains.GENIUS -> GeniusIndex()
        LuxSubdomains.HESSENPOORT -> DrechtstedenContent(subdomain.domainName)
        LuxSubdomains.BRABANT -> BrabantRouting()
        LuxSubdomains.BUNDERBUURTEN -> BunderbuurtenIndex()
    }
}
