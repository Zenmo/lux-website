package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.kronenberg
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

@OptIn(DelicateApi::class)
@Composable
fun KronenbergIndex() {
    LuxSubdomainPageLayout(
        title = kronenberg.label.nl,
    ) {
        val breakpoint = rememberBreakpoint()
        SubdomainModelPage(
            modelId = kronenberg.modelId,
            introContent = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Img(
                        src = "/lux/images/kronenberg/Energie-Kronenberg-4-1024x465.png",
                        alt = "EnergieKronenberg logo",
                        attrs = Modifier
                            .margin(bottom = 2.cssRem)
                            .maxWidth(30.cssRem).toAttrs()
                    )
                    P(
                        Modifier.thenIf(
                            breakpoint >= Breakpoint.MD, Modifier.width(60.percent)
                        )
                            .textAlign(TextAlign.Center)
                            .toAttrs()
                    ) {
                        LangText(
                            en = """
                                Zenmo is developing a digital twin for the citizen collective EnergieKronenberg to
                                explore how participants can collectively cover their entire energy demand.
                            """,
                            nl = """
                                Voor het burgercollectief EnergieKronenberg omtwikkelt Zenmo een digital twin om
                                te bekijken hoe de deelnemers samen hun volledige energiebehoefte kunnen afdekken.
                            """,
                        )
                    }
                }
            },
            footerContent = { ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS) }
        )
    }
}
