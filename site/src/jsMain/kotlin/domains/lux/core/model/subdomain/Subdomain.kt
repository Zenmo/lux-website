package energy.lux.frontend.domains.lux.core.model.subdomain

import androidx.compose.runtime.Composable

interface Subdomain {
    val subdomain: String
    val subdomainComponent: @Composable () -> Unit
}