package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.MediaContentLayout
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.dom.P

@Composable
fun Vaanpark() {
    val vaanpark = PrivateSubdomainModel.VAANPARK
    LuxSubdomainPageLayout(
        title = vaanpark.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = vaanpark.entryPoint,
            imageUrl = "/lux/images/vaanpark.png",
            introContent = {
                MediaContentLayout(
                    imageUrl = vaanpark.imageUrl,
                    title = {
                        HeaderText(
                            enText = vaanpark.label.en,
                            nlText = vaanpark.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                nl = """
                            Bekijk hieronder de energy twin voor de verduurzaming van bedrijventerrein Vaanpark in Barendrecht. 
                            De bedrijven op dit bedrijventerrein onderzoeken of ze samen energie kunnen delen en investeren in duurzame technieken. 
                            De energy twin helpt met het ontwerpen van deze duurzame systemen en het maken van de juiste beslissingen.
                        """,
                                en = """
                            Below is the energy twin made to improve the sustainability of business park Vaanpark in Barendrecht. 
                            The companies at this business park are investigating whether they can share energy 
                            and invest in sustainable technologies. 
                            The energy twin helps design these sustainable systems and make the right decisions.
                        """,
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            },
        )
    }
}
