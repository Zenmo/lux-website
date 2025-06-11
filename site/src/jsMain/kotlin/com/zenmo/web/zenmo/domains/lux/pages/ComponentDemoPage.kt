package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextOverflow
import com.varabyte.kobweb.compose.css.WordBreak
import com.varabyte.kobweb.compose.css.textOverflow
import com.varabyte.kobweb.compose.css.wordBreak
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.widgets.ColorPaletteDemo
import com.zenmo.web.zenmo.domains.lux.widgets.DataVizualitationColorDemo
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.overflowY
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun ComponentDemoPage() {
    LuxSubdomainPageLayout(
        title = "Componenten"
    ) {
        DataVizualitationColorDemo()

        ColorPaletteDemo()
    }
}
