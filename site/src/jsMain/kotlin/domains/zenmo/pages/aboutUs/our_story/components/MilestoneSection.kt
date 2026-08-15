package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.utils.PublicRes
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

private data class Milestone(val year: String, val enDesc: String, val nlDesc: String)

private val milestones = listOf(
    Milestone("2018", "Zenmo simulations founded in Herpt", "Zenmo simulations opgericht in Herpt"),
    Milestone("2019", "NEON research project", "NEON onderzoeksproject"),
    Milestone("2022", "The HOLON project", "Het HOLON-project"),
    Milestone("2024", "40+ projects delivered", "40+ projecten geleverd"),
)

@Composable
fun MilestoneSection() {
    SectionContainer(modifier = Modifier.backgroundColor(SitePalette.light.overlay)) {
        SubHeaderText(enText = "Major milestones", nlText = "Belangrijke mijlpalen")
        Div(
            MilestoneTimelineContainerStyle.toModifier()
                .constrainedWidth(70.percent).toAttrs()
        ) {
            Div(MilestoneTimelineVerticalLineStyle.toModifier().toAttrs())
            Div(MilestoneTimelineHorizontalLineStyle.toModifier().toAttrs())
            milestones.forEach { milestone ->
                Div(MilestoneItemStyle.toModifier().toAttrs()) {
                    Div(
                        Modifier
                            .size(12.px)
                            .flexShrink(0)
                            .backgroundColor(SitePalette.light.primary)
                            .borderRadius(50.percent)
                            .zIndex(1)
                            .toAttrs()
                    )
                    Column(
                        MilestoneContentStyle.toModifier()
                    ) {
                        SubHeaderText(
                            enText = milestone.year,
                            nlText = milestone.year,
                            textColor = SitePalette.light.primary,
                            modifier = Modifier.fontFamily(PublicRes.FontFamilies.MONTSERRAT_BLACK)
                        )
                        P(Modifier.margin(0.px).toAttrs()) {
                            LangText(en = milestone.enDesc, nl = milestone.nlDesc)
                        }
                    }
                }
            }
        }
    }
}