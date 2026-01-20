package com.zenmo.web.zenmo.core.models

import androidx.compose.runtime.Composable

interface Route {
    val path: String
    val pageComponent: @Composable () -> Unit
}