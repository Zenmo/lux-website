package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import com.zenmo.web.zenmo.core.services.localization.LocalizedText

/**
 * Logical classification of a twin model  (e.g. Energy Hub, Lux Company, Business Parks, etc).
 * Can be used for filtering and navigation.
 * @see com.zenmo.web.zenmo.domains.lux.sections.nav_header.luxNavMenu
 */
sealed interface ApplicationArea {
    val areaTitle: LocalizedText
}
