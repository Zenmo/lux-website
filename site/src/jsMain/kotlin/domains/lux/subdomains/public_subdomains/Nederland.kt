package energy.lux.frontend.domains.lux.subdomains.public_subdomains


import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.MediaContentLayout
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.nederland
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.dom.P


@Composable
fun NederlandIndex() {
    LuxSubdomainPageLayout(
        title = nederland.label.nl,
    ) {
        SubdomainModelPage(
            modelId = nederland.modelId,
            introContent = {
                MediaContentLayout(
                    imageUrl = nederland.imageUrl,
                    title = {
                        HeaderText(
                            enText = nederland.label.en,
                            nlText = nederland.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                en = "Below is a mock-up of the digital twin for the Netherlands",
                                nl = "Bekijk hieronder de mock-up van de digital twin voor Nederland",
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
