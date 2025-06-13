package com.zenmo.web.zenmo.protected.entrypoints.hessenpoort


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPhone
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCardImageContainerStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Hessenpoort")


@JsExport
@Composable
fun ProtectedComponent() {
    LuxSubdomainPageLayout(
        title = "Hessenpoort",
        backgroundColor = SitePalette.light.secondary,
        fontColor = SitePalette.light.primary,
    ) {
        SectionContainer(
            modifier = Modifier.gap(5.cssRem).margin(topBottom = 5.cssRem),
        ) {
            AnyLogicEmbed(
                modelId = Uuid.parse("ebade042-5518-4162-8eb5-f55439c67c64"), //todo replace with actual model ID
                apiKey = Uuid.parse("7c9ad7bc-3189-4796-a34e-9f3caa5c117a"),
                modifier = Modifier.maxWidth(90.cssRem).margin(bottom = 4.cssRem)
            )

            MediaContentLayout(
                imageUrl = "",
                visualContent = {
                    Box(TeamCardImageContainerStyle.toModifier().size(22.cssRem)) {
                        Image(
                            modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                            src = ZenmoTeam.ATE.image,
                            alt = "${ZenmoTeam.ATE.memberName} photo",
                        )
                    }
                },
                title = {
                    HeaderText(
                        enText = ZenmoTeam.ATE.memberName,
                        nlText = ZenmoTeam.ATE.memberName,
                        modifier = Modifier.margin(0.cssRem)
                    )
                },
                subtitle = {
                    SubHeaderText(
                        enText = "Website and model development",
                        nlText = "Website en model ontwikkeling",
                        modifier = Modifier.color(SitePalette.light.primary)
                            .margin(0.cssRem)
                    )
                },
                description = {
                    Column(Modifier.gap(0.5.cssRem)) {
                        Row {
                            MdiPhone(Modifier.padding(right = 0.25.cssRem))
                            Text("+31 6 14910380")
                        }

                        Row {
                            MdiMail(Modifier.padding(right = 0.25.cssRem))
                            Text(ZenmoTeam.ATE.email)
                        }
                    }
                },
                actionText = {},
                reversed = false,
            )
        }
    }
}