package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem

@Composable
fun WideScreenHeaderComponents(
    items: List<MenuItem>,
    content: @Composable () -> Unit,
) =
    LuxHeaderComponent(
        content = content,
        items = items,
        modifier = Modifier
            .displayIfAtLeast(Breakpoint.MD)
    )
