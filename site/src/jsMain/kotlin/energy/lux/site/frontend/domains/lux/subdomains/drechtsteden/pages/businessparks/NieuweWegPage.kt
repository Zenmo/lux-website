package energy.lux.site.frontend.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenBusinessPark
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun NieuweWegPage() {
    val twinModel = DrechtstedenBusinessPark.NieuweWeg
    DrechtstedenTwinLayout(
        title = twinModel.title,
        useTwinPageHeader = true,
        enTwinPageHeaderTitle = twinModel.title,
        nlTwinPageHeaderTitle = twinModel.title,
    ) {
        ModelInDevelopmentInfoWidget()
        ModelPageContent(
            twin = twinModel,
            enHeaderText = "Zero - Bedrijventerrein Nieuwe Weg",
            nlHeaderText = "Zero - Bedrijventerrein Nieuwe Weg",
            enDescriptionParagraph = """
                Below you can find the digital twin for the sustainability of the Nieuwe Weg business park in 
                Hardinxveld-Giesendam. The companies on this business park are exploring whether they can share energy 
                and invest in sustainable technologies together. The digital twin will help in designing these sustainable 
                energy systems and making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein Nieuwe Weg in 
                Hardinxveld-Giesendam. De bedrijven op dit bedrijventerrein zijn aan het onderzoeken of ze samen 
                energie kunnen delen en investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen 
                van deze duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
            enSubHeaderText = "Design your own energy system",
            nlSubHeaderText = "Ontwerp je eigen energiesysteem",
        ) {
            ProfileContactCard(
                name = ZenmoTeam.GILLIS.memberName,
                imageUrl = ZenmoTeam.GILLIS.image,
                email = ZenmoTeam.GILLIS.email,
                telephoneNumber = "+31 6 47171375",
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}