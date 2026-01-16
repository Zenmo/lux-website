package com.zenmo.web.zenmo.core.models

import com.zenmo.web.zenmo.core.services.localization.LocalizedText

interface SimpleMenuItem {
    val url: String
    val label: LocalizedText
}