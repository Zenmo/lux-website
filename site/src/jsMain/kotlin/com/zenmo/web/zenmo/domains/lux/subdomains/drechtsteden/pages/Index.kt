package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.protected.ProtectedWrapper

@Composable
fun DrechtstedenHomePage() {
    DrechtstedenContent(LuxSubdomains.DRECHTSTEDEN.domainName)
}

@Composable
fun DrechtstedenContent(subdomain: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProtectedWrapper("drechtsteden")
    }
}
