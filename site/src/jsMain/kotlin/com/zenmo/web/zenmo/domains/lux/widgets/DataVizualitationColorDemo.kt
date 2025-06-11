package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.whiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.overflowY
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun DataVizualitationColorDemo() {
    SectionContainer {
        SubHeaderText(
            enText = "Data visualization color palette",
            nlText = "Kleurenpalet voor data visualisatie",
        )

        Column {
            SimpleGrid(
                numColumns(base = 2),
                Modifier.gridTemplateColumns {
                    size(10.cssRem)
                    size(21.cssRem)
                }
            ) {
                SitePalette.light.luxDataVizColors.forEach {
                    val randomValue = Random.nextDouble(1.0, 20.0)
                    Div {
                        Text(it.toRgb().toString())
                    }
                    Div(
                        attrs = {
                            style {
                                backgroundColor(it)
                                width(randomValue.cssRem)
                                overflowY(Overflow.Visible.toString())
                                whiteSpace(WhiteSpace.NoWrap)
                                padding(.2.cssRem)
                                paddingLeft(1.cssRem)
                            }
                        }
                    ) {
                        val displayValue = randomValue.times(10).roundToInt()
                        Text("$displayValue kW")
                    }
                }
            }
        }
    }
}
