package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Li

@Composable
fun MenuSectionItem(
    href: String,
    enTitle: String,
    nlTitle: String,
    isActive: Boolean = false,
) {
    Li {
        A(
            href = href,
            attrs = Modifier
                .thenIf(isActive, ActiveMenuStyle.toModifier())
                .toAttrs()
        ) {
            LangText(
                en = enTitle,
                nl = nlTitle,
            )
        }
    }
}
