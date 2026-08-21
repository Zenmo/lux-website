package energy.lux.frontend.domains.zenmo.pages.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent

private val LgWidthVar by StyleVariable<CSSLengthOrPercentageNumericValue>()

val ConstrainedWidthStyle = CssStyle {
    base { Modifier.fillMaxWidth() }
    Breakpoint.LG { Modifier.width(LgWidthVar.value()) }
}

@Composable
fun Modifier.constrainedWidth(
    lg: CSSLengthOrPercentageNumericValue = 80.percent,
) = this
    .setVariable(LgWidthVar, lg)
    .then(ConstrainedWidthStyle.toModifier())