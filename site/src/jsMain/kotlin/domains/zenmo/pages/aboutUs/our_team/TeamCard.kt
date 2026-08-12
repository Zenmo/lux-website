package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_team

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.models.ZenmoTeamMember
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun TeamMemberCard(zenmoTeam: ZenmoTeamMember) {
    Column(
        modifier = TeamCardStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.px)
                .overflow(Overflow.Hidden)
                .position(Position.Relative),
        ) {
            Image(
                src = zenmoTeam.image.takeIf { it.isNotBlank() } ?: "/avatars/blank.png",
                alt = "${zenmoTeam.memberName} photo",
                modifier = Modifier
                    .classNames("team-card-image")
                    .fillMaxSize()
                    .objectFit(ObjectFit.Cover),
            )
            Box(
                modifier = Modifier
                    .classNames("team-card-overlay")
                    .padding(1.5.cssRem),
                contentAlignment = Alignment.BottomStart,
            ) {
                if (zenmoTeam.enBio.isNotBlank()) {
                    P(
                        Modifier.color(Colors.White).margin(0.px).toAttrs()
                    ) {
                        LangText(en = zenmoTeam.enBio, nl = zenmoTeam.nlBio)
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(1.5.cssRem)
                .textAlign(TextAlign.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.5.cssRem),
        ) {
            SubHeaderText(nlText = zenmoTeam.memberName)
            Span(
                TextStyle.toModifier(LabelTextStyle)
                    .color(SitePalette.light.primary)
                    .toAttrs()
            ) {
                LangText(en = zenmoTeam.enTitle, nl = zenmoTeam.nlTitle)
            }
            TeamMemberSocials(
                email = zenmoTeam.email,
                linkedin = zenmoTeam.linkedIn,
                twitter = zenmoTeam.twitter,
            )
        }
    }
}

@Composable
private fun TeamMemberSocials(
    email: String,
    linkedin: String,
    twitter: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.7.cssRem),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SocialIconLink(iconSrc = "/img/linkedin.svg", linkUrl = linkedin)
        SocialIconLink(iconSrc = "/img/mail.svg", linkUrl = "mailto:$email")
        SocialIconLink(iconSrc = "/img/x.svg", linkUrl = twitter)
    }
}

@Composable
private fun SocialIconLink(
    iconSrc: String,
    linkUrl: String,
) {
    Link(
        path = linkUrl,
        modifier = SocialLinkStyle.toModifier(),
        variant = UncoloredLinkVariant.then(UndecoratedLinkVariant)
    ) {
        Image(src = iconSrc)
    }
}