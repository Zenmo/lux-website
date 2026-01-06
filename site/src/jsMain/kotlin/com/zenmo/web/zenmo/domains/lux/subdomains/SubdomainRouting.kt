package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.brabant.BrabantRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.Genius


@Composable
fun LuxSubdomainRoutingComponent(subdomain: SubdomainModel) {
    when (subdomain) {
        SubdomainModel.Drechtsteden -> DrechtstedenRouting()
        SubdomainModel.Genius -> Genius()
        SubdomainModel.Hessenpoort -> Hessenpoort()
        SubdomainModel.Brabant -> BrabantRouting()
        SubdomainModel.Nederland -> NederlandIndex()
        SubdomainModel.Hilversum -> HilversumIndex()
        SubdomainModel.Bunderbuurten -> BunderbuurtenIndex()
        SubdomainModel.Loenen -> LoenenIndex()
        SubdomainModel.RotterdamDenHaag -> RotterdamDenHaagIndex()
        SubdomainModel.KasAlsEnergiebron -> KasAlsenErgiebron()
        SubdomainModel.Kronenberg -> KronenbergIndex()
        SubdomainModel.Vruchtenbuurt -> VruchtenbuurtIndex()
        SubdomainModel.Cognizant -> Cognizant()
        SubdomainModel.PreZero -> PreZero()
        SubdomainModel.Amersfoort -> Amersfoort()
        SubdomainModel.Borchwerf -> Borchwerf()
        SubdomainModel.Veenendaal -> Veenendaal()
    }
}
