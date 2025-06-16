package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.brabant.BrabantRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.GeniusIndex
import com.zenmo.web.zenmo.protected.ProtectedWrapper


enum class LuxSubdomains(val domainName: String) {
    DRECHTSTEDEN("drechtsteden"),
    GENIUS("genius"),
    HESSENPOORT("hessenpoort"),
    BRABANT("brabant"),
    NEDERLAND("nederland"),
    HILVERSUM("hilversum"),
    BUNDERBUURTEN("bunderbuurten"),
    LOENEN("loenen"),
    KAS_ALS_ENERGIEBRON("kas-als-energiebron"),
}

@Composable
fun LuxSubdomainRoutingComponent(subdomain: LuxSubdomains) {
    when (subdomain) {
        LuxSubdomains.DRECHTSTEDEN -> DrechtstedenRouting()
        LuxSubdomains.GENIUS -> GeniusIndex()
        LuxSubdomains.HESSENPOORT -> ProtectedWrapper("hessenpoort")
        LuxSubdomains.BRABANT -> BrabantRouting()
        LuxSubdomains.NEDERLAND -> NederlandIndex()
        LuxSubdomains.HILVERSUM -> HilversumIndex()
        LuxSubdomains.BUNDERBUURTEN -> BunderbuurtenIndex()
        LuxSubdomains.LOENEN -> LoenenIndex()
        LuxSubdomains.KAS_ALS_ENERGIEBRON -> ProtectedWrapper("kasalsenergiebron")
    }
}
