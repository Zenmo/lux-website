package com.zenmo.web.zenmo.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.widgets.SelectableItemStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div


data class TabContent(
    val label: LocalizedText,
    val content: @Composable () -> Unit
)

@Composable
fun <T> DemoTabLayout(
    selectedTab: T,
    tabs: Map<T, TabContent>,
    onChange: (T) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.5.cssRem)
    ) {
        TabHeader(
            selectedTab = selectedTab,
            tabs = tabs.mapValues { it.value.label },
            onChange = onChange
        )
        tabs[selectedTab]?.content?.invoke()
    }
}


@Composable
private fun <T> TabHeader(
    selectedTab: T,
    tabs: Map<T, LocalizedText>,
    onChange: (T) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(450.px)
            .padding(0.25.cssRem)
            .luxBorderRadius()
            .background(SitePalette.light.overlay.darkened(0.05f))
    ) {
        tabs.forEach { (tab, label) ->
            val isSelected = tab == selectedTab
            TabItem(
                label = label,
                isSelected = isSelected,
                onClick = { onChange(tab) }
            )
        }
    }
}


@Composable
private fun TabItem(
    label: LocalizedText,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Div(
        SelectableItemStyle.toModifier()
            .thenIf(
                isSelected,
                Modifier
                    .background(Colors.White)
                    .luxBorderRadius()
            )
            .display(DisplayStyle.InlineBlock)
            .padding(topBottom = 0.35.cssRem)
            .flex(1, 0, 0.percent)
            .border(0.px, LineStyle.None)
            .onClick { onClick() }
            .toAttrs()
    ) {
        LangText(
            en = label.en,
            nl = label.nl
        )
    }
}
