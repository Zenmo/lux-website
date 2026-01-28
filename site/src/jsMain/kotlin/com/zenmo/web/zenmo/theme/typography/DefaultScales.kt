package com.zenmo.web.zenmo.theme.typography

import com.zenmo.web.zenmo.theme.typography.core.ResponsiveScale
import com.zenmo.web.zenmo.theme.typography.core.TextRole

object DefaultScales {
    val header = ResponsiveScale(sm = 2.5, md = 3.0, lg = 3.3, xl = 3.7)
    val title = ResponsiveScale(sm = 1.35, md = 1.35, lg = 1.5, xl = 2.0)
    val body = ResponsiveScale(sm = 1.0, md = 1.0, lg = 1.15, xl = 1.25)
    val label = ResponsiveScale(sm = 0.9, md = 0.9, lg = 0.9, xl = 0.9)

    fun forRole(role: TextRole) = when (role) {
        TextRole.HEADER -> header
        TextRole.TITLE -> title
        TextRole.BODY -> body
        TextRole.LABEL -> label
    }
}