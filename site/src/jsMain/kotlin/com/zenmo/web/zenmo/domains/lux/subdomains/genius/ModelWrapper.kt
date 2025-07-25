package com.zenmo.web.zenmo.domains.lux.subdomains.genius

import androidx.compose.runtime.*
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
import com.zenmo.web.zenmo.components.widgets.ErrorWidget
import com.zenmo.web.zenmo.protected.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

val ProtectedWrapperStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(rgba(0, 0, 0, 0.4f))
            .color(Colors.White)
            .position(Position.Companion.Absolute)
            .top(50.percent)
            .left(50.percent)
            .transform { translate((-50).percent, (-50).percent) }
            .width(40.percent)
            .padding(topBottom = 20.px, leftRight = 10.px)
    }

    Breakpoint.SM {
        Modifier.width(80.percent)
    }

    Breakpoint.MD {
        Modifier.width(50.percent)
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
        .boxSizing(BoxSizing.Companion.BorderBox)
        .filter(blur(10.px))
        .styleModifier { property("-webkit-filter", "blur(10px)") }
        .fillMaxWidth()
        .fillMaxHeight()
        .objectFit(ObjectFit.Companion.Cover)
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
    var wrapperStatus by remember { mutableStateOf<AccessStatus>(AccessStatus.Success) }
    Box(
        Modifier.Companion
            .fillMaxWidth()
            .position(Position.Companion.Relative)
            .height(80.vh).then(modifier),
        contentAlignment = Alignment.Center
    ) {
        if (wrapperStatus != AccessStatus.Success) {
            Image(
                src = imgUrl,
                alt = "$entryPoint model teaser",
                modifier = BlurModelImageStyle.toModifier()
            )
        }
        Div(
            Modifier.Companion
                .thenIf(wrapperStatus != AccessStatus.Success, ProtectedWrapperStyle.toModifier())
                .thenIf(wrapperStatus == AccessStatus.Success, ModelWrapperStyle.toModifier())
                .toAttrs()
        ) {
            ProtectedWrapper(
                entryPoint = entryPoint,
                fallbackContent = { status ->
                    // we don't need to recompose the content if the status hasn't changed
                    if (wrapperStatus != status) {
                        wrapperStatus = status
                    }

                    when (status) {
                        AccessStatus.Pending -> Pending()
                        AccessStatus.NotLoggedIn -> Login()
                        AccessStatus.NotEnoughPrivileges -> NotEnoughPrivileges(actionContent = {})
                        is AccessStatus.Error -> {
                            ErrorWidget(errorMessage = status.errorMessage, actionContent = {
                                // todo trigger a retry or something
                            })
                        }

                        AccessStatus.Success -> {}
                    }
                })
        }
    }
}