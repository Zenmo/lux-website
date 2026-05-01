package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.euterpepark
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.moleneind
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P

@Composable
fun Euterpepark() {
    PrivateTwinModelPage(
        entryPoint = euterpepark.entryPoint,
        imageUrl = euterpepark.imageUrl,
        modelId = euterpepark.modelId,
        introContent = {
            HeaderText(
                enText = euterpepark.label.en,
                nlText = euterpepark.label.nl,
            )

            P {
                LangText(
                    en = "Come back soon to see the model and more!",
                    nl = "Kom snel terug om het model en meer te zien!"
                )
            }
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}