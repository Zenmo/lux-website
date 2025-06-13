package com.zenmo.web.zenmo.domains.lux.subdomains


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
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCardImageContainerStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid


@Composable
fun HilversumIndex() {
    LuxSubdomainPageLayout(
        title = "Werfgebied Hilversum"
    ) {
        Column(
            modifier = Modifier
                .gap(5.cssRem).margin(topBottom = 5.cssRem),
        ) {
            SectionContainer {
                MediaContentLayout(
                    imageUrl = "/lux/images/Werfgebied-Hilversum.png",
                    imageModifier = Modifier
                        .borderRadius(30.px).border(
                            width = 2.px,
                            color = SitePalette.light.primary,
                            style = LineStyle.Solid
                        ),
                    reversed = true,
                    keepImageAsIs = true,
                    description = {
                        P {
                            LangText(
                                en = """
                                View the digital twin for the Werfgebied Hilversum sustainability project. 
                                The digital twin assists in designing these sustainable energy systems and making the 
                                right decisions.
                            """.trimIndent(),
                                nl = """
                                Bekijk de digitale tweeling voor het Werfgebied Hilversum duurzaamheid project.
                                De digitale tweeling helpt bij het ontwerpen van deze duurzame energiesystemen en het maken
                                van de juiste beslissingen.
                            """.trimIndent()
                            )
                        }
                    }
                )
            }
            SectionContainer(
                Modifier
                    .background(Color.white)
                    .width(100.percent)
                    .maxWidth(130.cssRem),
                variant = null
            ) {
                AnyLogicEmbed(
                    modelId = Uuid.parse("00edc3d3-2942-486a-93ae-26f809872a54"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                    modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 5.cssRem)
                )
            }
            SectionContainer {
                MediaContentLayout(
                    imageUrl = "",
                    visualContent = {
                        Box(TeamCardImageContainerStyle.toModifier().size(22.cssRem)) {
                            Image(
                                modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                                src = ZenmoTeam.NAUD_LOOMANS.image,
                                alt = "${ZenmoTeam.NAUD_LOOMANS.memberName} photo",
                            )
                        }
                    },
                    title = {
                        HeaderText(
                            enText = ZenmoTeam.NAUD_LOOMANS.memberName,
                            nlText = ZenmoTeam.NAUD_LOOMANS.memberName,
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
                                Text("+31 6 15 249535")
                            }
                            Row {
                                MdiMail(Modifier.padding(right = 0.25.cssRem))
                                Text(ZenmoTeam.NAUD_LOOMANS.email)
                            }
                        }
                    },
                    actionText = {},
                    reversed = false,
                )
            }
        }
    }
}
