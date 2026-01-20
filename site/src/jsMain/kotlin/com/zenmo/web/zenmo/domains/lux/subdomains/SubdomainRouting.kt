package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.subdomains


@Composable
fun LuxSubdomainRoutingComponent(subdomain: String) =
    subdomains
        .first { it.subdomain == subdomain }
        .subdomainComponent()
