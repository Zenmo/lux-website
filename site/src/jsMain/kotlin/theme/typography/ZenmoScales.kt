package energy.lux.frontend.theme.typography

import energy.lux.frontend.theme.typography.core.ResponsiveScale
import energy.lux.frontend.theme.typography.core.TextRole

object ZenmoScales {
    val header = ResponsiveScale(sm = 2.0, md = 2.4, lg = 2.8, xl = 3.5)
    val title = ResponsiveScale(sm = 1.35, md = 1.35, lg = 1.5, xl = 1.75)
    val body = ResponsiveScale(sm = 1.0, md = 1.0, lg = 1.1, xl = 1.25)
    val label = ResponsiveScale(sm = 0.9, md = 0.9, lg = 0.9, xl = 0.9)

    fun forRole(role: TextRole) = when (role) {
        TextRole.HEADER -> header
        TextRole.TITLE -> title
        TextRole.BODY -> body
        TextRole.LABEL -> label
    }
}