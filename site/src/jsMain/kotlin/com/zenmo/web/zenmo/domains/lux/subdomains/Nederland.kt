package com.zenmo.web.zenmo.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid


@Composable
fun NederlandIndex() {
    LuxSubdomainPageLayout(
        title = "Nederland",
    ) {
        SectionContainer(
            modifier = Modifier.gap(5.cssRem).margin(topBottom = 5.cssRem),
        ) {
            MediaContentLayout(
                imageUrl = "/lux/images/Model-nederland.png",
                imageModifier = Modifier.borderRadius(30.px).border(
                    width = 2.px,
                    color = SitePalette.light.primary,
                    style = LineStyle.Solid
                ),
                reversed = true,
                keepImageAsIs = true,
                description = {
                    P {
                        LangText(
                            en = "Below is a mock-up of the digital twin for the Netherlands",
                            nl = "Bekijk hieronder de mock-up van de digital twin voor Nederland"
                        )
                    }
                }
            )
            AnyLogicEmbed(
                modelId = Uuid.parse("0853040a-824d-4341-9d50-26bf4a3deb8f"),
                apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 5.cssRem)
            )
        }
    }
}
