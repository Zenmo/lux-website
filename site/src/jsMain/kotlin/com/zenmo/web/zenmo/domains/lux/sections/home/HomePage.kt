package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.domains.lux.sections.home.hero.LuxHero

@OptIn(DelicateApi::class)
@Composable
fun HomePage() {
    val breakpoint = rememberBreakpoint()
    Column(modifier = Modifier.fillMaxSize()) {
        LuxHero(breakpoint)
        StatsSection(breakpoint)
        LuxBasicsSection(breakpoint)
    }
}
