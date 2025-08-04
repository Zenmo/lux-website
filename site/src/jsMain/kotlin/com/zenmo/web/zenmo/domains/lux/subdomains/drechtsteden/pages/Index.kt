package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P

@OptIn(DelicateApi::class)
@Composable
fun DrechtstedenHomePage() {
    DrechtstedenTwinLayout(
        title = "Home",
    ) {
        val breakpoint = rememberBreakpoint()
        Column {
            SectionContainer(
                modifier = Modifier.gap(2.cssRem),
                variant = LuxSectionContainerStyleVariant
            ) {
                HeaderText(
                    enText = "Digital twins Drechtsteden",
                    nlText = "Digital twins Drechtsteden",
                    modifier = Modifier.margin(0.cssRem)
                )
                P(
                    Modifier
                        .width(if (breakpoint < Breakpoint.MD) 100.percent else 60.percent)
                        .textAlign(TextAlign.Center)
                        .toAttrs()
                ) {
                    LangText(
                        en = """
                        This is an overview page of all digital twins created in collaboration with the RES Regio 
                        Drechtsteden. Starting with the twin at the RES Region level, followed by all municipal models, 
                        and ultimately all individual business parks.
                    """.trimIndent(),
                        nl = """
                        Dit is een overzichtspagina van alle digital twins gemaakt in samenwerking met de RES Regio 
                        Drechtsteden. Beginnende met de twin op RES Regio niveau, gevolgd door alle gemeente modellen, 
                        en uiteindelijk alle individuele bedrijventerreinen.
                    """.trimIndent()
                    )
                }
            }

            //todo put the RES Region twin, municipal models, and business parks here
        }
    }
}