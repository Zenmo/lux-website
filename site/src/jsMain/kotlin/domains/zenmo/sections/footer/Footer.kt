package energy.lux.frontend.domains.zenmo.sections.footer

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainerStyle
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.styles.DeEmphasizedTextStyle
import energy.lux.frontend.domains.zenmo.components.ZENMO_EMAIL
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.*
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


private val footerLinks = listOf(
    zenmoHomeMenuItem,
    zenmoProjectsMenuItem,
    zenmoModelsMenuItem,
    zenmoStoryMenuItem,
    workingAtZenmoMenuItem,
    contactZenmoMenuItem,
)

@Composable
fun ZenmoFooter(modifier: Modifier = Modifier) {
    Footer(
        SectionContainerStyle
            .toModifier()
            .backgroundColor(SitePalette.light.primary.darkened(0.85f))
            .then(modifier).toAttrs()
    ) {
        Div(FooterContentStyle.toModifier().toAttrs()) {
            FooterBrand()
            Div(FooterColumnsStyle.toModifier().toAttrs()) {
                FooterNavigation()
                FooterContact()
            }
        }
    }
}


@Composable
private fun FooterBrand() {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            src = "/icons/zenmo-logo-white.svg",
            alt = "Zenmo Simulations",
            modifier = Modifier.height(54.px).width(autoLength)
        )
        P(
            DeEmphasizedTextStyle.toModifier()
                .constrainedWidth(60.percent)
                .toAttrs()
        ) {
            LangText(
                en = "Scientific insight, translated into interactive models for the real world.",
                nl = "Wetenschappelijk inzicht, vertaald naar interactieve modellen voor de echte wereld.",
            )
        }
    }
}


@Composable
private fun FooterSectionItem(title: LocalizedText, content: @Composable () -> Unit) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.gap(1.cssRem)
    ) {
        P(
            Modifier
                .margin(0.px)
                .fontWeight(FontWeight.SemiBold)
                .letterSpacing(0.24.em)
                .textTransform(TextTransform.Uppercase)
                .color(SitePalette.light.primary.lightened(0.2f))
                .toAttrs()
        ) {
            LangText(title)
        }
        content()
    }
}

@Composable
private fun FooterNavigation() {
    FooterSectionItem(
        title = LocalizedText(
            en = "Navigation",
            nl = "Navigatie"
        )
    ) {
        Nav(
            Modifier
                .display(DisplayStyle.Grid)
                .gridTemplateColumns { repeat(2) { size(1.fr) } }
                // fill top-to-bottom first, so the list order reads down each column
                .gridTemplateRows { repeat((footerLinks.size + 1) / 2) { size(minContent) } }
                .gridAutoFlow(GridAutoFlow.Column)
                .columnGap(0.5.cssRem)
                .rowGap(0.75.cssRem)
                .toAttrs()
        ) {
            footerLinks.forEach { item ->
                Link(
                    path = item.route.url,
                    variant = FooterLinkStyle.then(UndecoratedLinkVariant),
                ) {
                    LangText(item.route.label)

                    if(item == workingAtZenmoMenuItem)
                        Text(" Zenmo")
                }
            }
        }
    }
}

@Composable
private fun FooterContact() {
    FooterSectionItem(
        title = LocalizedText(en = "Get in touch", nl = "Neem contact op")
    ) {
        A(href = "mailto:$ZENMO_EMAIL", attrs = FooterEmailStyle.toModifier().toAttrs()) {
            Text(ZENMO_EMAIL)
        }
        P(
            DeEmphasizedTextStyle.toModifier()
                .toAttrs()
        ) {
            Text("Eindhoven & Herpt")
            Br()
            LangText(en = "The Netherlands", nl = "Nederland")
        }
    }
}