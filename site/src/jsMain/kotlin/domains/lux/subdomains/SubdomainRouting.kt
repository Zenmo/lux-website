package energy.lux.frontend.domains.lux.subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.UnknownDomain
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.model.subdomain.subdomainModels
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.core.model.subdomain.brabant
import energy.lux.frontend.domains.lux.core.model.subdomain.nederland
import energy.lux.frontend.domains.lux.core.model.subdomain.hilversum
import energy.lux.frontend.domains.lux.core.model.subdomain.bunderbuurten
import energy.lux.frontend.domains.lux.core.model.subdomain.loenen
import energy.lux.frontend.domains.lux.core.model.subdomain.rotterdamDenHaag
import energy.lux.frontend.domains.lux.core.model.subdomain.tuinzigt
import energy.lux.frontend.domains.lux.core.model.subdomain.vruchtenbuurt
import energy.lux.frontend.domains.lux.core.model.subdomain.cognizant
import energy.lux.frontend.domains.lux.core.model.subdomain.kronenberg
import energy.lux.frontend.domains.lux.core.model.subdomain.amersfoort
import energy.lux.frontend.domains.lux.core.model.subdomain.veenendaal
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.*
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenRouting
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.genius.Genius
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.OssRouting
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.RegioFoodValleyRouting
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.BunderbuurtenIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.Cognizant
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.HilversumIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.KronenbergIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.LoenenIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.NederlandIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.PureEnergie
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.RotterdamDenHaagIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.Tuinzigt
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.Veenendaal
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.VruchtenbuurtIndex
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.amersfoort.Amersfoort
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.BrabantRouting
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.EmpoweredRouting


/**
 * The page of each subdomain lives here and not in the subdomain models,
 * so code that only needs a model's data (label, url) does not pull in every subdomain's pages.
 */
@Composable
fun LuxSubdomainRoutingComponent(subdomain: String) {
    val model = subdomainModels.find { it.subdomain.equals(subdomain, ignoreCase = true) }
    when (model) {
        PrivateSubdomainModel.DRECHTSTEDEN -> DrechtstedenRouting()
        PrivateSubdomainModel.GENIUS -> Genius()
        PrivateSubdomainModel.HESSENPOORT -> Hessenpoort()
        PrivateSubdomainModel.KAS_ALS_ENERGIEBRON -> KasAlsEnergiebron()
        PrivateSubdomainModel.PREZERO -> PreZero()
        PrivateSubdomainModel.BORCHWERF -> Borchwerf()
        PrivateSubdomainModel.DE_WIEKEN -> DeWieken()
        PrivateSubdomainModel.VAANPARK -> Vaanpark()
        PrivateSubdomainModel.BIJSTERHUIZEN -> Bijsterhuizen()
        PrivateSubdomainModel.OSS -> OssRouting()
        PrivateSubdomainModel.SLOTERDIJK -> Sloterdijk()
        PrivateSubdomainModel.BREDA_OOST -> BredaOost()
        PrivateSubdomainModel.PURE_ENERGIE -> PureEnergie()
        PrivateSubdomainModel.H4B -> H4B()
        PrivateSubdomainModel.REGIOFOODVALLEY -> RegioFoodValleyRouting()
        empowered -> EmpoweredRouting()
        brabant -> BrabantRouting()
        nederland -> NederlandIndex()
        hilversum -> HilversumIndex()
        bunderbuurten -> BunderbuurtenIndex()
        loenen -> LoenenIndex()
        rotterdamDenHaag -> RotterdamDenHaagIndex()
        tuinzigt -> Tuinzigt()
        vruchtenbuurt -> VruchtenbuurtIndex()
        cognizant -> Cognizant()
        kronenberg -> KronenbergIndex()
        amersfoort -> Amersfoort()
        veenendaal -> Veenendaal()
        else -> UnknownDomain(subdomain)
    }
}
