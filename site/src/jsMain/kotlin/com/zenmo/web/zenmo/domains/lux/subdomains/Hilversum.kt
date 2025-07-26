package com.zenmo.web.zenmo.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
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
                ProfileContactCard(
                    name = ZenmoTeam.NAUD_LOOMANS.memberName,
                    imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                    email = ZenmoTeam.NAUD_LOOMANS.email,
                    telephoneNumber = "+31 6 15 249535",
                    enSubtitle = "Website and model development",
                    nlSubtitle = "Website en model ontwikkeling",
                )
            }
        }
    }
}
