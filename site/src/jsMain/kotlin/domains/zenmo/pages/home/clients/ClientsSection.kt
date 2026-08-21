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
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
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
        logoSrc = "/zenmo/clients/TUe.png",
        clientName = "TU/e",
        siteUrl = "http://tue.nl/",

    ),
    ClientItem(
        logoSrc = "/zenmo/clients/Drechtsteden.jpeg",
        clientName = "Drechtsteden",
        siteUrl = PrivateSubdomainModel.DRECHTSTEDEN.url,

    ),
    ClientItem(
        logoSrc = "/zenmo/clients/energy-innovation-nl-light.svg",
        clientName = "Energie Innovation",
        siteUrl = "https://energy-innovation.nl/nl/",
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/energie_samen.svg",
        clientName = "Energie Samen",
        siteUrl = "https://energiesamen.nu/",
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/hollands_kroon.svg",
        clientName = "Hollands Kroon",
        siteUrl = "https://hollandskroon.nl/",
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/Genius.png",
        clientName = "Genius",
        siteUrl = PrivateSubdomainModel.GENIUS.url,
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/roosendaal.png",
        clientName = "Roosendaal",
        siteUrl = "https://roosendaal.nl/",
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/oss.png",
        clientName = "OSS",
        siteUrl = PrivateSubdomainModel.OSS.url,
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/amersfoort.png",
        clientName = "Amersfoort",
        siteUrl = "https://amersfoort.nl/",
    ),
    ClientItem(
        logoSrc = "/zenmo/clients/Energieke-Regio-150.png",
        clientName = "Energieke Regio",
        siteUrl = "https://energiekeregio.nl/",
    ),

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