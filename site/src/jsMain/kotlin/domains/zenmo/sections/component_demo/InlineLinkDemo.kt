package energy.lux.frontend.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.zenmo.widgets.ComponentDemo
import energy.lux.frontend.domains.zenmo.widgets.DemoContentWrapperStyle
import org.jetbrains.compose.web.dom.Span

@Composable
fun InlineLinkDemo() {
    ComponentDemo(
        enTitle = "Inline Links",
        nlTitle = "Inline Links",
        enDescription = "Add inline links to external pages.",
        nlDescription = "Voeg inline links toe naar externe pagina's.",
        codeExample = """
            import .InlineLink
            
            InlineLinks(
                destinationUrl = "https://zenmo.com",
                enLinkText = "Click here",
                nlLinkText = "Klik hier",
            )
            
        """.trimIndent()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Span(
                Modifier.fillMaxWidth()
                    .textAlign(TextAlign.Start)
                    .toAttrs()
            ) {
                LangText(
                    en = "This code gives a text embedded with a hyperlink.",
                    nl = "Deze code geeft een tekst met een hyperlink erin.",
                )
            }
            Span(
                DemoContentWrapperStyle.toModifier().toAttrs()
            ) {
                InlineLink(
                    destinationUrl = "https://zenmo.com",
                    enLinkText = "Click here",
                    nlLinkText = "Klik hier",
                )
            }
        }
    }
}