package energy.lux.frontend.domains.zenmo.pages.home.clients

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem

data class ClientItem(
    val logoSrc: String = "",
    val clientName: String = "",
    val siteUrl: String = "",
)

private val zenmoClients = listOf(
    ClientItem(
        logoSrc = "https://genius.lux.energy/lux/logos/genius/tu_e.jpg",
        clientName = "TU/e",
        siteUrl = "http://www.tue.nl/",
    ),
    ClientItem(
        logoSrc = "https://genius.lux.energy/lux/logos/genius/logo_genius.png",
        clientName = "GENIUS",
        siteUrl = "https://genius.lux.energy/en/",
    ),
    ClientItem(
        logoSrc = "https://isie.energy/isie-logo.png",
        clientName = "ISIE",
        siteUrl = "https://isie.energy/",
    ),
    ClientItem(
        logoSrc = "https://resourcefully.nl/wp-content/uploads/2023/07/resourcefully-logo_full-purple.svg",
        clientName = "Resourcefully",
        siteUrl = "https://resourcefully.nl/",
    ),
    ClientItem(
        logoSrc = "https://coco.local4local.nu/local4local-logo.svg",
        clientName = "Local4Local",
        siteUrl = "https://coco.local4local.nu/",
    ),
    ClientItem(
        logoSrc = "https://www.energiekronenberg.nl/wp-content/uploads/2025/11/image-2.png",
        clientName = "Energie Kronenberg",
        siteUrl = "https://www.energiekronenberg.nl/",
    ),
    ClientItem(
        logoSrc = "https://holons.energy/imgs/logo_homepagina.png",
        clientName = "Holons Energy",
        siteUrl = "https://holons.energy/",
    ),
    ClientItem(),
)

@Composable
fun ClientsSection() {
    SectionContainer(
        modifier = Modifier.backgroundColor(SitePalette.light.overlay),
    ) {
        HeaderText(enText = "Our Clients", nlText = "Onze Klanten")
        SimpleGrid(
            numColumns(base = 2, sm = 2, md = 3, lg = 4, xl = 4, xxl = 4),
            modifier = Modifier.gap(1.cssRem).fillMaxWidth(),
        ) {
            zenmoClients.forEach { client ->
                Link(
                    path = client.siteUrl,
                    variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = ClientLogoContainerStyle.toModifier().fillMaxWidth()
                    ) {
                        Image(
                            src = client.logoSrc,
                            alt = "${client.clientName} logo",
                            modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Contain),
                        )
                    }
                }
            }
        }
    }
}