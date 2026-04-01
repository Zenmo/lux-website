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
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.widgets.ComponentDemo
import energy.lux.frontend.domains.zenmo.widgets.DemoContentWrapperStyle
import org.jetbrains.compose.web.dom.Span

@Composable
fun SubHeadingsDemo() {
    ComponentDemo(
        enTitle = "Sub Headings",
        nlTitle = "Sub koppen",
        enDescription = "You typically use this when you want to display a subheading on a page.",
        nlDescription = "Je gebruikt dit meestal wanneer je een subkop op een pagina wilt tonen.",
        codeExample = """
                    import .SubHeaderText
                    
                    SubHeaderText(
                        enText = "Explore",
                        nlText = "Verken",
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
                    en = "This results in the following:",
                    nl = "Dit resulteert in het volgende:",
                )
            }
            SubHeaderText(
                enText = "Explore",
                nlText = "Verken",
                modifier = DemoContentWrapperStyle.toModifier()
            )
        }
    }
}