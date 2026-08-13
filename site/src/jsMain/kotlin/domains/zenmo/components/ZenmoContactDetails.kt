package energy.lux.frontend.domains.zenmo.components

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
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun ZenmoContactDetails(
    modifier: Modifier = Modifier.fillMaxWidth(),
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.gap(1.cssRem)
            .then(modifier),
    ) {
        Row(
            modifier = Modifier.gap(0.5.cssRem),
        ) {
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
                icon = {},
                infoTitleText = LocalizedText("Eindhoven"),
                info = { Text("Horsten 1, 5612AX") }
            )
        }
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