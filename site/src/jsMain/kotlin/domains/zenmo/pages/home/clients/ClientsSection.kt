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
        logoSrc = "https://energiesamen.nu/wp-content/uploads/2025/08/Logo-wit.svg",
        clientName = "Energie Samen",
        siteUrl = "https://energiesamen.nu/",
    ),
    ClientItem(
        logoSrc = "https://genius.lux.energy/lux/logos/genius/tu_e.jpg",
        clientName = "TU/e",
        siteUrl = "http://www.tue.nl/",
    ),
    ClientItem(
        logoSrc = "https://www.regiofoodvalley.nl/fileadmin/regiofoodvalley.nl/assets/foodvalley-desktop.svg",
        clientName = "Regio Food Valley",
        siteUrl = "https://www.regiofoodvalley.nl/",
    ),
    ClientItem(
        logoSrc = "https://drechtsteden.lux.energy/lux/logos/lux-energy-twin.png",
        clientName = "Drechtsteden",
        siteUrl = "https://drechtsteden.lux.energy/",
    ),
    ClientItem(
        logoSrc = "",
        clientName = "Energie Innovation",
        siteUrl = "https://www.energy-innovation.nl/nl/",
    ),
    ClientItem(),
    ClientItem(),
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