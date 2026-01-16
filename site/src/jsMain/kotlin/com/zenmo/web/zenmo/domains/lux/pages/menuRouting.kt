package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.core.models.MenuItem

fun InitKobwebContext.menuRouting(
    menu: List<MenuItem>,
    layoutWrapper: @Composable (@Composable () -> Unit) -> Unit = { it() }
) {
    with(this.router) {
        menu
            .flatMap { item ->
                when (item) {
                    is MenuItem.Simple -> listOf(item)
                    is MenuItem.WithSubs -> item.subItems
                }
            }
            .forEach { item ->
                register(item.nav.path) {
                    layoutWrapper {
                        item.nav.pageComponent()
                    }
                }
            }
    }
}