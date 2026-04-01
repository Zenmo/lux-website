package energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import energy.lux.frontend.utils.PublicRes
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div

@Composable
fun EnergyHubProcessBlock(
    step: String,
    title: LocalizedText,
    content: @Composable ColumnScope.() -> Unit
) {
    Div(
        ResponsiveFlexStyle.toModifier()
            .background(SitePalette.light.overlay)
            .gap(24.px)
            .alignItems(AlignItems.FlexStart)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(clamp(24.px, 5.vw, 40.px))
            .toAttrs()
    ) {
        Box(
            Modifier
                .size(64.px)
                .background(SitePalette.light.primary)
                .luxBorderRadius()
                .color(Colors.White)
                .flexShrink(0),
            contentAlignment = Alignment.Center
        ) {
            SpanText(
                text = step,
                modifier = Modifier
                    .fontFamily(PublicRes.FontFamilies.HOLON_BLOCK)
                    .fontSize(1.5.cssRem)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SubHeaderText(
                enText = title.en,
                nlText = title.nl,
                textColor = SitePalette.light.primary
            )
            content()
        }
    }
}