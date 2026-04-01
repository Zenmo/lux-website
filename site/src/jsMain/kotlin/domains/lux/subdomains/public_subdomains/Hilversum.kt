package energy.lux.frontend.domains.lux.subdomains.public_subdomains


import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.MediaContentLayout
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.hilversum
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.dom.P


@Composable
fun HilversumIndex() {
    LuxSubdomainPageLayout(
        title = hilversum.label.nl,
    ) {
        SubdomainModelPage(
            modelId = hilversum.modelId,
            introContent = {
                MediaContentLayout(
                    imageUrl = hilversum.imageUrl,
                    title = {
                        HeaderText(
                            enText = hilversum.label.en,
                            nlText = hilversum.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                en = """
                            View the digital twin for the Werfgebied Hilversum sustainability project. 
                            The digital twin assists in designing these sustainable energy systems and making the 
                            right decisions.
                        """.trimIndent(),
                                nl = """
                            Bekijk de digitale tweeling voor het Werfgebied Hilversum duurzaamheid project.
                            De digitale tweeling helpt bij het ontwerpen van deze duurzame energiesystemen en het maken
                            van de juiste beslissingen.
                        """.trimIndent(),
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
            }
        )
    }
}
