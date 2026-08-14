package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.icons.mdi.MdiChevronRight
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.B

@Composable
fun ServiceCard(item: ServiceItem, showDivider: Boolean = true) {
    Row(
        modifier = ServiceCardStyle.toModifier()
            .thenIf(
                showDivider,
                Modifier
                    .borderBottom(
                        1.px,
                        LineStyle.Solid,
                        Colors.Black.copyf(alpha = 0.1f)
                    )
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(1.cssRem)
        ) {
            Box(
                modifier = Modifier
                    .classNames("service-icon-box"),
                contentAlignment = Alignment.Center,
            ) {
                item.icon()
            }
            B { LangText(item.titleText) }
        }
        MdiChevronRight(
            modifier = Modifier
                .classNames("service-chevron")
                .alignSelf(AlignSelf.Center)
                .color(SitePalette.light.primary),
        )
    }
}