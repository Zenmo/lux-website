package com.zenmo.web.zenmo.domains.lux.sections

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.zenmo.web.zenmo.theme.SitePalette

val DeEmphasizedTextStyle = CssStyle.base {
    Modifier.color(
        SitePalette.light.onBackground.lightened(0.5f)
    )
}