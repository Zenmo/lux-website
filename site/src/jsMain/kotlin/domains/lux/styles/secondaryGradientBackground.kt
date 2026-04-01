package energy.lux.frontend.domains.lux.styles

import com.varabyte.kobweb.compose.ui.Modifier
import energy.lux.frontend.theme.SitePalette

fun Modifier.secondaryGradientBackground(): Modifier =
    verticalLinearBackground(
        topColor = SitePalette.light.secondary,
        bottomColor = SitePalette.light.secondary.darkened(0.2f)
    )