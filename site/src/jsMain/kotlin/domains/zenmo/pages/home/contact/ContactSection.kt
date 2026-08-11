package energy.lux.frontend.domains.zenmo.pages.home.contact

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiEmail
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLocationOn
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPhone
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.styles.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.PlaceholderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactSection() {
    SectionContainer {
        Div(
            ResponsiveFlexStyle.toModifier().toAttrs()
        ) {
            ContactInfo()
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                //todo map view
            }
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
            PlaceholderText()
        }
        Column(verticalArrangement = Arrangement.spacedBy(1.cssRem)) {
            ContactInfoRow(
                icon = { MdiLocationOn() },
                infoTitleText = LocalizedText("Herpt (municipality of Heusden)"),
                info = {
                    Text("Hoefstraat 1A")
                    Br { }
                    Text("5255 PB Herpt")
                }
            )
            ContactInfoRow(
                icon = { MdiEmail() },
                infoTitleText = LocalizedText(en = "General", nl = "Algemeen"),
                info = {
                    InlineLink(
                        destinationUrl = "mailto:hallo@zenmo.com",
                        enLinkText = "hallo@zenmo.com",
                        nlLinkText = "hallo@zenmo.com",
                        textColor = Colors.Black
                    )
                }
            )
            ContactInfoRow(
                icon = { MdiPhone() },
                infoTitleText = LocalizedText(en = "Phone", nl = "Telefoon"),
                info = {
                    Image(
                        src = "/lux/images/peter_phone.png",
                        alt = "Peter phone number",
                    )
                }
            )
        }
    }
}

@Composable
private fun ContactInfoRow(
    icon: @Composable () -> Unit,
    infoTitleText: LocalizedText,
    info: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier.gap(0.75.cssRem),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
    ) {
        Span(
            Modifier.color(SitePalette.light.primary).toAttrs()
        ) {
            icon()
        }
        Column {
            Span(
                Modifier.fontWeight(FontWeight.Bold).toAttrs()
            ) {
                LangText(infoTitleText)
            }
            info()
        }
    }
}