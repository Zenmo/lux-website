package energy.lux.frontend.domains.lux.sections.application_fields

import energy.lux.frontend.core.services.localization.LocalizedText

/**
 * Logical classification of a twin model  (e.g. Energy Hub, Lux Company, Business Parks, etc).
 * Can be used for filtering and navigation.
 * @see energy.lux.frontend.domains.lux.sections.nav_header.luxNavMenu
 */
sealed interface ApplicationArea {
    val areaTitle: LocalizedText
}
