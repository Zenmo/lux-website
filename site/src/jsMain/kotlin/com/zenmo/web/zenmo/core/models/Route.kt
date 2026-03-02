package com.zenmo.web.zenmo.core.models

import androidx.compose.runtime.Composable

typealias PageComponent = @Composable () -> Unit

interface Route {
    /**
     * Path to be passed to the router.
     * Does not include the locale prefix such as /en/ or /nl/
     */
    val path: String
    val pageComponent: PageComponent
}
