package energy.lux.frontend.domains.zenmo.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.components.widgets.SectionContainerStyle
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.domains.zenmo.sections.component_demo.AnyLogicDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.CardLinkDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.EmbedVideoDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.ImageWithCaptionDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.InlineLinkDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.MediaContentLayoutDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.OrderedListDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.PageHeadingsDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.SubHeadingsDemo
import energy.lux.frontend.domains.zenmo.sections.component_demo.TextParagraphsDemo
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

val DemoPageContainerVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 2.cssRem)
            .padding(leftRight = 4.cssRem)
    }

    Breakpoint.MD {
        Modifier
            .width(90.percent)
    }
    Breakpoint.LG {
        Modifier
            .width(75.percent)
    }

    Breakpoint.XL {
        Modifier
            .width(75.percent)
    }
}


/**
 * Page to demo the usage of components
 */
@Composable
fun ComponentDemoPage() {
    PageLayout(
        title = "Components Demo",
        header = {},
        footer = {}
    ) {
        SectionContainer {
            Span(
                TextStyle.toModifier(HeaderTextStyle)
                    .padding(top = 2.cssRem)
                    .toAttrs()
            ) {
                LangText(
                    en = "Demo of Components",
                    nl = "Demo van Componenten",
                )
            }
            SectionContainer(
                modifier = Modifier
                    .margin(topBottom = 2.cssRem)
                    .padding(leftRight = 4.cssRem),
                variant = DemoPageContainerVariant,
                verticalArrangement = Arrangement.spacedBy(4.cssRem)
            ) {
                PageHeadingsDemo()
                SubHeadingsDemo()
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomizationNotes(
                        enCustomizationNotes = """
                    You can add some styling to these text components, give it a color maybe. 
                    Do this with the color modifier like shown below:
                """.trimIndent(),
                        nlCustomizationNotes = """
                    Je kunt wat styling toevoegen aan deze tekstcomponenten, geef het misschien een kleur.
                    Doe dit met de kleur-modifier zoals hieronder getoond:
                """.trimIndent(),
                    )
                    Pre(
                        attrs = Modifier
                            .margin(top = 0.5.cssRem)
                            .then(PreCodeStyle.toModifier()).toAttrs()
                    ) {
                        Text(
                            """
                    import .HeaderText
                    import com.varabyte.kobweb.compose.ui.modifiers.color
                    import .SitePalette
                    import com.varabyte.kobweb.compose.ui.Modifier
                    import com.varabyte.kobweb.silk.style.toModifier

                    HeaderText(
                        enText = "This text is styled with a color",
                        nlText = "Deze tekst is gestyled met een kleur",
                        modifier = Modifier.color(SitePalette.light.primary)
                    ) 
                    """.trimIndent()
                        )
                    }
                    LangText(
                        en = "NB: SitePalette contains custom color palette defined for the site's theme.",
                        nl = "NB: SitePalette bevat een aangepast kleurenpalet dat is gedefinieerd voor het thema van de site",
                    )
                }
                TextParagraphsDemo()
                AnyLogicDemo()
                MediaContentLayoutDemo()
                InlineLinkDemo()
                OrderedListDemo()
                ImageWithCaptionDemo()
                EmbedVideoDemo()
                CardLinkDemo()
            }
        }
    }
}
