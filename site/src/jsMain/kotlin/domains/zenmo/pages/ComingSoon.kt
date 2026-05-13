package energy.lux.frontend.domains.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiCode
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.components.widgets.SectionContainerStyle
import energy.lux.frontend.domains.lux.components.HorizontalLine
import energy.lux.frontend.domains.lux.sections.DeEmphasizedTextStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

val ComingSoonPageVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .padding(clamp(32.px, 5.vw, 120.px))
            .fillMaxSize()
    }
}

@Composable
fun ComingSoon() {
    PageLayout(
        title = "Coming Soon"
    ) {
        SectionContainer(
            variant = ComingSoonPageVariant,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.gap(1.cssRem)
                .textAlign(TextAlign.Center),
        ) {
            Box(
                Modifier
                    .size(64.px)
                    .background(SitePalette.light.primary.lightened(0.85f))
                    .color(SitePalette.light.primary)
                    .clip(shape = Circle()),
                contentAlignment = Alignment.Center
            ) {
                MdiCode()
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HeaderText(
                    enText = "Coming Soon",
                    nlText = "Binnenkort beschikbaar",
                    fontWeight = FontWeight.Black
                )
                P {
                    LangText(
                        en = "We're working on this page. Check back soon!",
                        nl = "We werken aan deze pagina. Kom binnenkort terug!",
                    )
                }
            }

            HorizontalLine(Modifier.width(50.percent))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Span(DeEmphasizedTextStyle.toAttrs()) {
                    LangText(
                        en = "Questions in the meantime?",
                        nl = "Heb je in de tussentijd nog vragen?",
                    )
                }

                B(
                    attrs = Modifier
                        .color(SitePalette.light.primary)
                        .toAttrs()
                ) {
                    LangText(
                        en = "Mail us at ",
                        nl = "Mail ons op ",
                    )
                    InlineLink(
                        destinationUrl = "mailto:hallo@zenmo.com",
                        enLinkText = "hallo@zenmo.com",
                        nlLinkText = "hallo@zenmo.com",
                        textColor = SitePalette.light.primary
                    )
                }
            }
        }
    }
}