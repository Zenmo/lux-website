package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.objectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.VerticalProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Col
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

@Composable
fun KronenbergIndex() {
    LuxSubdomainPageLayout(
        title = "EnergieKronenberg"
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

            P {
                LangText(
                    en = "Come back soon to see more.",
                    nl = "Kom binnenkort terug om meer te zien.",
                )
            }

//         AnyLogicEmbed(
//             modelId = Uuid.parse("00000000-0000-0000-0000-000000000000"),
//             apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
//          )

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
