package energy.lux.frontend.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ProfileImageStyle
import energy.lux.frontend.domains.zenmo.sections.team.TeamCardImageContainerStyle
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Div

enum class ProfileCardArrangementDirection {
    HORIZONTAL, VERTICAL
}

//todo put this on component demo
@OptIn(DelicateApi::class)
@Composable
fun ProfileContactCard(
    name: String,
    imageUrl: String,
    email: String,
    phoneNumberImageSrc: String = "",
    captionText: LocalizedText = LocalizedText(
        en = "Website and model development",
        nl = "Website en model ontwikkeling"
    ),
    captionRender: @Composable () -> Unit = {
        SubHeaderText(
            enText = captionText.en,
            nlText = captionText.nl,
            textColor = SitePalette.light.primary,
            modifier = Modifier.fontSize(1.15.cssRem)
        )
    },
    cardArrangementDirection: ProfileCardArrangementDirection,
) {
    val breakpoint = rememberBreakpoint()
    val isVertical = cardArrangementDirection == ProfileCardArrangementDirection.VERTICAL ||
            breakpoint < Breakpoint.MD
    Div(
        ResponsiveFlexStyle.toModifier()
            .width(auto)
            .justifyContent(JustifyContent.Start)
            .thenIf(
                isVertical,
                Modifier.flexDirection(FlexDirection.Column)
            )
            .toAttrs(),
    ) {
        Box(
            TeamCardImageContainerStyle.toModifier().size(18.cssRem),
        ) {
            Image(
                modifier = ProfileImageStyle.toModifier(),
                src = imageUrl,
                alt = "$name photo",
            )
        }
        Column(
            Modifier.gap(0.5.cssRem)
                .textAlign(TextAlign.Center),
            horizontalAlignment = if (isVertical)
                Alignment.CenterHorizontally else Alignment.Start
        ) {
            captionRender()
            HeaderText(
                enText = name,
                nlText = name,
                modifier = Modifier.fontSize(2.5.cssRem)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (email.isNotBlank()) {
                    MdiMail(Modifier.padding(right = 0.5.cssRem))
                    InlineLink(
                        destinationUrl = "mailto:$email",
                        enLinkText = email,
                        nlLinkText = email,
                        textColor = Colors.Black,
                    )
                }

                if (phoneNumberImageSrc.isNotBlank()) {
                    Image(
                        modifier = Modifier.padding(left = 0.75.cssRem),
                        src = phoneNumberImageSrc,
                        alt = "$name phone number",
                    )
                }
            }
        }
    }
}