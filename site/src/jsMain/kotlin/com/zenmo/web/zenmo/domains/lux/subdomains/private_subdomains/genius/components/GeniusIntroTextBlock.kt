package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.genius.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun GeniusIntroTextBlock() {
    Column {
        Div {
            LangBlock(
                en = {
                    H1(
                        TextStyle.toModifier(HeaderTextStyle)
                            .fontFamily(PublicRes.FontFamilies.HOLON_LINE)
                            .textTransform(TextTransform.Companion.None)
                            .toAttrs()
                    ) {
                        HeaderText(
                            enText = "GENIUS - ",
                            nlText = "",
                            modifier = Modifier.Companion.margin(0.px)
                                .display(DisplayStyle.Companion.InlineBlock)
                        )
                        Text(" Grid Efficiency Network Integration for Universal Sustainability")
                    }
                },
                nl = {
                    H1(
                        TextStyle.toModifier(HeaderTextStyle)
                            .fontFamily(PublicRes.FontFamilies.HOLON_LINE)
                            .textTransform(TextTransform.Companion.None)
                            .toAttrs()
                    ) {
                        HeaderText(
                            enText = "",
                            nlText = "GENIUS - ",
                            modifier = Modifier.Companion.margin(0.px)
                                .display(DisplayStyle.Companion.InlineBlock)
                        )
                        Text(" Grid Efficiency Network Integratie voor Universele Duurzaamheid")
                    }
                }
            )
        }
        P {
            LangText(
                en = """
                    In the three-year European innovation project GENIUS, a consortium of partners led by TU/e will 
                    optimize the campus’ energy infrastructure and usage in order to address the growing problem of 
                    network congestion. The project will act as a blueprint for the energy management of other 
                    campus-like environments, such as industrial sites.
                """.trimIndent(),
                nl = """
                    In het driejarige Europese innovatieproject GENIUS zal een consortium van partners onder leiding 
                    van de TU/e de energie-infrastructuur en het energieverbruik van de campus optimaliseren om het 
                    groeiende probleem van netwerkcongestie aan te pakken. Het project zal dienen als blauwdruk voor 
                    het energiebeheer van andere campusachtige omgevingen, zoals industrieterreinen.
                """.trimIndent()
            )
        }

        P(
            DeEmphasizedTextStyle.toModifier().toAttrs()
        ) {
            LangText(
                en = """
                    The GENIUS-project is funded by a strategic European OPZuid grant worth 1,375,000 euros, 
                    supplemented by investments by the national and regional government. The total project budget 
                    amounts approximately 3 million euros. The aim of the project is to solve the problem of net 
                    congestion on campus, and to serve as a testing ground for innovations, shortening their time to 
                    market.
                """.trimIndent(),
                nl = """
                    Het GENIUS-project wordt gefinancierd door een strategische Europese OPZuid-subsidie van 1,375,000 
                    euro, aangevuld met investeringen van de nationale en regionale overheid. Het totale projectbudget 
                    bedraagt ongeveer 3 miljoen euro. Het doel van het project is om het probleem van netwerkcongestie 
                    op de campus op te lossen en te dienen als testomgeving voor innovaties, waardoor de tijd tot 
                    marktverkrijging wordt verkort.
                """.trimIndent()
            )
        }
    }
}