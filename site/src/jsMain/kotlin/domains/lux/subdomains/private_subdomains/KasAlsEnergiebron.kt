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
fun KasAlsEnergiebron() {
    val kasAlsEnergiebron = PrivateSubdomainModel.KAS_ALS_ENERGIEBRON
    LuxSubdomainPageLayout(
        title = kasAlsEnergiebron.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = kasAlsEnergiebron.entryPoint,
            imageUrl = "/lux/images/models/kasals.png",
            introContent = {
                MediaContentLayout(
                    imageUrl = kasAlsEnergiebron.imageUrl,
                    title = {
                        HeaderText(
                            enText = kasAlsEnergiebron.label.en,
                            nlText = kasAlsEnergiebron.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                nl = """
                            LTO Noord wilt bij de verduurzaming van de glastuinbouw aansluiten 
                            op de behoeften van lokale wijken en bedrijventerreinen.
                            Zenmo het gebied Broekpolder inzichtelijk gemaakt door inzet van de Lux Energy Twin.
                        """,
                                en = """
                            LTO Noord aims to align efforts to make greenhouses more sustainable 
                            with the needs of local neighborhoods and business parks.
                            Zenmo has provided insight into the Broekpolder area through the use of the Lux Energy Twin.
                        """,
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}
