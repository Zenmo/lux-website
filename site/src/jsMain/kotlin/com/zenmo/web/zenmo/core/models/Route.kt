package com.zenmo.web.zenmo.core.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.PageMethod

typealias PageComponent = @Composable () -> Unit

interface Route {
    val path: String
    val pageComponent: PageComponent
}
