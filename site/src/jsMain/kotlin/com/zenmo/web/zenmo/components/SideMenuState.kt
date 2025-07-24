package com.zenmo.web.zenmo.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.silk.style.animation.Keyframes
import org.jetbrains.compose.web.css.percent

val SideMenuSlideInAnim = Keyframes {
    from {
        Modifier.Companion.translateX(100.percent)
    }

    to {
        Modifier.Companion
    }
}

enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}