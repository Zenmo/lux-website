package energy.lux.frontend.domains.zenmo.pages.home.contact

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.ZenmoContactDetails
import energy.lux.frontend.domains.zenmo.components.ZenmoLocationMap
import energy.lux.frontend.domains.zenmo.pages.contact.ContactLocationLayoutStyle
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun ContactSection() {
    SectionContainer {
        Div(
            ContactLocationLayoutStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .constrainedWidth()
                .toAttrs()
        ) {
            ContactInfo()
            ZenmoLocationMap()
        }
    }
}

@Composable
private fun ContactInfo() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(1.5.cssRem),
    ) {
        HeaderText(enText = "Get In Touch", nlText = "Neem Contact Op")
        P {
            LangText(
                en = """
                    Feel free to email us for a talk without any obligations about what Zenmo can do for you. 
                """.trimIndent(),
                nl = """
                    Mail ons gerust voor een vrijblijvend gesprek over de mogelijkheden. 
                """.trimIndent()
            )
        }
        ZenmoContactDetails()
    }
}