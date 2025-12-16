package com.zenmo.web.zenmo.domains.zenmo.navigation

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea

object LuxMenu {
    val items = listOf(
        MenuItem.WithSubs(
            title = LocalizedText("Application Areas", "Toepassingsgebieden"),
            subItems = ApplicationArea.entries.map { field ->
                MenuItem.Simple(title = field.areaTitle, descriptionParagraph = field.shortDescription)
            }
        ).withGeneratedPaths(),
        MenuItem.Simple(title = LocalizedText("Example Models", "Voorbeeldmodellen")),
        MenuItem.Simple(title = LocalizedText("About Us", "Over Ons")),
    )
}