package energy.lux.frontend.domains.zenmo.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe

private const val ZENMO_MAP_URL =
    "https://maps.google.com/maps?q=ZEnMo%20Simulations&t=m&z=10&output=embed&iwloc=near"

@Composable
fun ZenmoLocationMap(
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Iframe(
        attrs = Modifier
            .height(320.px)
            .borderRadius(16.px)
            .then(modifier)
            .toAttrs {
                attr("src", ZENMO_MAP_URL)
                attr("title", "Zenmo Simulations")
                attr("aria-label", "Zenmo Simulations")
                attr("loading", "lazy")
                attr("frameborder", "0")
            }
    )
}