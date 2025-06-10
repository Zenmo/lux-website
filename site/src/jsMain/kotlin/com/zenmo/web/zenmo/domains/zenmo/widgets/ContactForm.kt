package com.zenmo.web.zenmo.domains.zenmo.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.InputStyle
import com.varabyte.kobweb.silk.style.addVariantBase
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.Space
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.defaultFonts
import com.zenmo.web.zenmo.utils.paddingVertical
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.onSubmit
import org.jetbrains.compose.web.attributes.required
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea
import org.w3c.dom.HTMLFormElement
import org.w3c.xhr.FormData

val ZenmoInputStyle = InputStyle.addVariantBase {
    Modifier
        .borderBottom(
            width = 1.px,
            color = Color.black,
            style = LineStyle.Solid,
        )
        .paddingVertical(.5.cssRem)
        .fontWeight(FontWeight.Bold)
        // this is just for textarea
        .width(100.percent)
        .fontSize(1.cssRem)
        .then(defaultFonts)
}

@Composable
fun ContactForm() {
    Form(attrs = {
        onSubmit { event ->
            window.alert("Not implemented yet")
            val formData = FormData(event.currentTarget as HTMLFormElement)
            event.preventDefault()
        }
    }) {
        HeaderText(
            enText = "Send us a message",
            nlText = "Stuur ons een bericht",
        )
        Br()
        Column(Modifier.gap(2.cssRem)) {
            LabelColumn {
                Row {
                    LangText(
                        nl = "Naam",
                        en = "Name",
                    )
                    MandatoryTag()
                }
                Input(
                    type = InputType.Text,
                    attrs = InputStyle.toModifier(ZenmoInputStyle).toAttrs {
                        name("name")
                        required()
                    }
                )
            }
            LabelColumn {
                LangText(
                    nl = "Bedrijfsnaam",
                    en = "Company name",
                )
                Input(
                    type = InputType.Text,
                    attrs = InputStyle.toModifier(ZenmoInputStyle).toAttrs {
                        name("companyName")
                    }
                )
            }
            LabelColumn {
                LangText(
                    nl = "Telefoonnummer",
                    en = "Telephone number",
                )
                Input(
                    type = InputType.Tel,
                    attrs = InputStyle.toModifier(ZenmoInputStyle).toAttrs {
                        name("telephoneNumber")
                    }
                )
            }
            LabelColumn {
                LangText(
                    nl = "E-mailadres",
                    en = "E-mail address",
                )
                Input(
                    type = InputType.Email,
                    attrs = InputStyle.toModifier(ZenmoInputStyle).toAttrs {
                        name("emailAddress")
                    }
                )
            }
            LabelColumn {
                Row {
                    LangText(
                        nl = "Bericht",
                        en = "Message",
                    )
                    MandatoryTag()
                }
                TextArea(
                    attrs = InputStyle.toModifier(ZenmoInputStyle).toAttrs {
                        name("message")
                        required()
                        rows(4)
                    }
                )
            }
            PrimaryButton(
                modifier = Modifier.alignSelf(AlignSelf.FlexEnd),
                type = ButtonType.Submit,
                nlText = "Opsturen",
                enText = "Send",
            )
        }
    }
}

@Composable
fun LabelColumn(content: @Composable ColumnScope.() -> Unit) {
    Label(attrs = Modifier.width(100.percent).toAttrs()) {
        Column(Modifier.width(100.percent)) {
            content()
        }
    }
}

@Composable
fun MandatoryTag() {
    Span(attrs = {
        style {
            color(Color.red)
        }
    }) {
        Space()
        Text("*")
    }
}
