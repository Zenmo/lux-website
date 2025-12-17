package energy.lux.site.frontend.domains.zenmo.navigation

import com.zenmo.web.zenmo.core.services.localization.LocalizedText

object DrechtstedenMenu {
    val items = listOf(
        MenuItem.Simple(path = "/", title = LocalizedText("Home", "Thuis")),
        MenuItem.Simple(path = "/res-region", title = LocalizedText("Res Region", "Res Regio")),
        MenuItem.Simple(path = "/res-neighborhoods", title = LocalizedText("Res Neighborhoods", "Woonwijken")),
        MenuItem.Simple(path = "/business-parks", title = LocalizedText("Business Parks", "Bedrijventerreinen"))
    )
}