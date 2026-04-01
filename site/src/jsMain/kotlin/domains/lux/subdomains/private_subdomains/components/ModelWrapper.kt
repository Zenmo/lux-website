package energy.lux.frontend.domains.lux.subdomains.private_subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.ErrorWidget
import energy.lux.frontend.protected.AccessStatus
import energy.lux.frontend.protected.Login
import energy.lux.frontend.protected.NotEnoughPrivileges
import energy.lux.frontend.protected.Pending
import energy.lux.frontend.protected.ProtectedWrapper
import energy.lux.frontend.theme.isZenmoDomain
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

val ProtectedWrapperStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(rgba(0, 0, 0, 0.4f))
            .thenIf(!isZenmoDomain, Modifier.luxBorderRadius(LuxCornerRadius.lg))
            .color(Colors.White)
            .position(Position.Absolute)
            .top(50.percent)
            .left(50.percent)
            .transform { translate((-50).percent, (-50).percent) }
            .padding(topBottom = 20.px, leftRight = 10.px)
    }
    Breakpoint.ZERO {
        Modifier.width(95.percent)
    }

    Breakpoint.SM {
        Modifier.width(95.percent)
    }

    Breakpoint.MD {
        Modifier.width(60.percent)
    }

    Breakpoint.LG {
        Modifier.width(40.percent)
    }

    Breakpoint.XL {
        Modifier.width(40.percent)
    }
}

val BlurModelImageStyle = CssStyle.base {
    Modifier
        .boxSizing(BoxSizing.BorderBox)
        .filter(blur(10.px))
        .styleModifier { property("-webkit-filter", "blur(10px)") }
        .fillMaxWidth()
        .fillMaxHeight()
        .objectFit(ObjectFit.Cover)
}

val ModelWrapperStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .position(Position.Relative)
        .height(80.vh)
        .padding(bottom = 3.cssRem)
}

@Composable
fun ModelWrapper(
    imgUrl: String,
    entryPoint: String,
    modifier: Modifier = Modifier.padding(topBottom = 3.cssRem)
) {
    Box(
        Modifier
            .fillMaxWidth()
            .position(Position.Relative)
            .height(80.vh).then(modifier),
        contentAlignment = Alignment.Center
    ) {
        ProtectedWrapper(
            entryPoint = entryPoint,
            display = { status ->
                if (status is AccessStatus.Success) {
                    Div(ModelWrapperStyle.toModifier().toAttrs()) {
                        status.protectedComponent()
                    }
                } else {
                    Image(
                        src = imgUrl,
                        alt = "$entryPoint model teaser",
                        modifier = BlurModelImageStyle.toModifier()
                    )
                    Div(ProtectedWrapperStyle.toModifier().toAttrs()) {
                        when (status) {
                            AccessStatus.Pending -> Pending()
                            AccessStatus.NotLoggedIn -> Login()
                            AccessStatus.NotEnoughPrivileges -> NotEnoughPrivileges(actionContent = {})
                            is AccessStatus.Error -> {
                                ErrorWidget(errorMessage = status.errorMessage, actionContent = {
                                    // todo trigger a retry or something
                                })
                            }
                        }
                    }
                }
            },
        )
    }
}
