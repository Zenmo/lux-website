package energy.lux.frontend.domains.zenmo.pages.aboutUs.working_at_zenmo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SiteFluidSpacing
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span

@Composable
fun WorkingHero() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(480.px)
            .position(Position.Relative)
            .overflow(Overflow.Hidden),
        contentAlignment = Alignment.BottomStart,
    ) {
        Image(
            src = "/zenmo/images/wind-farm.jpg",
            alt = "wind turbines",
            modifier = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover),
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Background.of(
                        image = linearGradient(LinearGradient.Direction.ToBottom) {
                            add(Colors.Transparent, 0.percent)
                            add(Colors.Black.copyf(alpha = 0.5f), 60.percent)
                            add(Colors.Black.copyf(alpha = 0.85f), 100.percent)
                        }.toImage()
                    )
                )
        )
        SectionContainer(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .gap(0.75.cssRem)
                .padding(
                    leftRight = SiteFluidSpacing.current.horizontalPadding,
                    bottom = 2.cssRem
                ),
        ) {
            Span(
                TextStyle.toModifier(LabelTextStyle)
                    .color(SitePalette.light.primary)
                    .letterSpacing(3.px)
                    .textTransform(TextTransform.Uppercase)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                LangText(en = "Working at Zenmo", nl = "Werken bij Zenmo")
            }
            HeaderText(
                enText = "Join our mission",
                nlText = "Doe mee aan ons missie",
                textColor = Colors.White,
            )
        }
    }
}