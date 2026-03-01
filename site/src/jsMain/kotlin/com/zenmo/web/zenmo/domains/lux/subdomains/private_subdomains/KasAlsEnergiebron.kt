package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.theme.SitePalette
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
