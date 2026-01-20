package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.kronenberg
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

@Composable
fun KronenbergIndex() {
    LuxSubdomainPageLayout(
        title = kronenberg.label.nl,
    ) {
        SectionContainer(
            modifier = Modifier
                .gap(2.cssRem)
                .margin(bottom = 2.cssRem),
        ) {
            Img(
                src = "/lux/images/kronenberg/Energie-Kronenberg-4-1024x465.png",
                alt = "EnergieKronenberg logo",
                attrs = Modifier.margin(
                    top = 1.cssRem, bottom = 2.cssRem
                ).maxWidth(30.cssRem).toAttrs()
            )

            MediaContentLayout(
                reversed = true,
                imageUrl = "/lux/images/kronenberg/Skyline-Kronenberg-Jan-Janssen-scaled.jpg",
                imageModifier = Modifier
                    .height(30.cssRem)
                    .styleModifier {
                        // Issue https://github.com/Zenmo/lux-website/issues/355 to add this
                        property("object-position", "50% bottom")
                    },
                description = {
                    P {
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
            )

            AnyLogicEmbed(
                modelId = kronenberg.modelId,
            )

            Column(
                modifier = Modifier.fillMaxWidth().gap(1.cssRem),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HeaderText(
                    enText = "Contact and info", nlText = "Contact en info", modifier = Modifier.margin(0.cssRem)
                )
                SubHeaderText(
                    enText = "Website and model development",
                    nlText = "Website en model ontwikkeling",
                    modifier = Modifier.margin(0.cssRem),
                )
                ProfileContactCard(
                    name = ZenmoTeam.NAUD_LOOMANS.memberName,
                    imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                    email = ZenmoTeam.NAUD_LOOMANS.email,
                    organization = { ZenmoInlineLink() },
                )
            }
        }
    }
}
