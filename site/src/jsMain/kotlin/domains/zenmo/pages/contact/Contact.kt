package energy.lux.frontend.domains.zenmo.pages.contact

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.ZenmoContactDetails
import energy.lux.frontend.domains.zenmo.components.ZenmoLocationMap
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.contactZenmoMenuItem
import energy.lux.frontend.domains.zenmo.widgets.ContactForm
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun ContactPage() {
    ZenmoPageLayout(contactZenmoMenuItem.route.label) {
        SectionContainer(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderSection()
            ContactLocationSection()
        }
        SectionContainer(
            modifier = Modifier.backgroundColor(SitePalette.light.overlay),
        ) { ContactForm() }
    }
}

@Composable
private fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderText(
            enText = "Contact Us", nlText = "Neem Contact Op",
            modifier = Modifier.textAlign(TextAlign.Center),
        )
        P(
            Modifier.textAlign(TextAlign.Center).toAttrs()
        ) {
            LangText(
                en = """
                    Feel free to email us for a talk without any obligations about what Zenmo can do for you. 
                """.trimIndent(),
                nl = """
                    Mail ons gerust voor een vrijblijvend gesprek over de mogelijkheden. 
                """.trimIndent()
            )
        }
    }
}

@Composable
private fun ContactLocationSection() {
    Div(
        ContactLocationLayoutStyle
            .toModifier()
            .constrainedWidth(70.percent)
            .toAttrs()
    ) {
        ZenmoContactDetails(Modifier.width(auto))
        ZenmoLocationMap()
    }
}