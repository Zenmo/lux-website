package com.zenmo.web.zenmo.protected.entrypoints.kasalsenergiebron

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
val accessPolicy = AccessPolicy.RoleBased("Kas als Energiebron")

@JsExport
@Composable
fun ProtectedComponent() {
    LuxSubdomainPageLayout(
        title = "Kas als Energiebron",
        enSubtitle = "Broekpolder",
        nlSubtitle = "Broekpolder",
        backgroundColor = SitePalette.light.secondary,
        fontColor = SitePalette.light.primary,
    ) {
        SectionContainer(
            modifier = Modifier.gap(5.cssRem).margin(topBottom = 5.cssRem),
        ) {
            AnyLogicEmbed(
                modelId = Uuid.parse("7dfd7bdd-9882-4c58-bfc2-5aa6e5aac938"),
                apiKey = Uuid.parse("aec12288-c1ec-4dee-89f6-ef4238fd860c"),
                modifier = Modifier.maxWidth(90.cssRem).margin(bottom = 4.cssRem)
            )

            MediaContentLayout(
                imageUrl = "",
                visualContent = {
                    Box(TeamCardImageContainerStyle.toModifier().size(22.cssRem)) {
                        Image(
                            modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                            src = ZenmoTeam.PETER_HOGEVEEN.image,
                            alt = "${ZenmoTeam.PETER_HOGEVEEN.memberName} photo",
                        )
                    }
                },
                title = {
                    HeaderText(
                        enText = ZenmoTeam.PETER_HOGEVEEN.memberName,
                        nlText = ZenmoTeam.PETER_HOGEVEEN.memberName,
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
                    Column {
                        Row {
                            MdiPhone(Modifier.padding(right = 0.25.cssRem))
                            Text("+31 6 52 38 12 49")
                        }

                        Row {
                            MdiMail(Modifier.padding(right = 0.25.cssRem))
                            Text(ZenmoTeam.PETER_HOGEVEEN.email)
                        }
                    }
                },
                actionText = {},
                reversed = false,
            )
        }
    }
}