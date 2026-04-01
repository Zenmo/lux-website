package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiOpenInNew
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.HorizontalLine
import energy.lux.frontend.domains.lux.sections.DeEmphasizedTextStyle
import energy.lux.frontend.domains.lux.styles.cubicBezierTransition
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span


val LearnMoreStyle = CssStyle {
    base {
        Modifier.color(SitePalette.light.primary)
            .padding(top = 0.5.cssRem)
            .gap(8.px)
            .cubicBezierTransition()
    }
    hover {
        Modifier.gap(12.px)
    }
}


@Composable
fun LearnMoreAboutEmpowered() {
    Column(
        Modifier.fillMaxWidth()
            .gap(1.cssRem),
    ) {
        HorizontalLine()
        SubHeaderText(
            enText = "Learn More",
            nlText = "Meer Informatie",
            modifier = Modifier
                .textTransform(TextTransform.Uppercase)
        )
        Span(
            DeEmphasizedTextStyle.toModifier().toAttrs()
        ) {
            LangText(
                en = "For more information see:",
                nl = "Voor meer informatie, zie:",
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = LearnMoreStyle.toModifier()
        ) {
            InlineLink(
                destinationUrl = "https://www.tue.nl/en/research/research-groups/innovation-sciences/technology-innovation-society/enabling-positive-energy-districts-through-citizen-centered-socio-technical-models-for-upscaling-of-the-heat-transition",
                enLinkText = "EmPowerED Research Project (TU/e)",
                nlLinkText = "EmPowerED Onderzoeksproject (TU/e)",
            )
            MdiOpenInNew()
        }
    }
}