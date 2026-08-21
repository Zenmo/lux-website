package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.models.ZenmoTeamMember
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.core.isPrivate
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.regiofoodvalleyBusinessParksMenuItem
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.regiofoodvalleyNeighbourhoodsMenuItem
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.regiofoodvalleyRegioMenuItem
import energy.lux.frontend.domains.lux.widgets.ModelCard
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid

@Composable
fun RegioFoodValleyHomePage() {
    SubdomainModelPage(
        introContent = {
            HeaderText(PrivateSubdomainModel.REGIOFOODVALLEY.label)
        },
        mediaContent = { RegioFoodValleyAreas() },
        modelId = Uuid.NIL,
        anylogicRender = {},
        footerContent = { ZenmoModellerProfileCard(ZenmoTeamMember.PETER_HOGEVEEN) }
    )
}

private val regioFoodValleyAreas = listOf(
    regiofoodvalleyRegioMenuItem,
    regiofoodvalleyBusinessParksMenuItem,
    regiofoodvalleyNeighbourhoodsMenuItem
)

@Composable
private fun RegioFoodValleyAreas() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .gap(1.5.cssRem)
    ) {
        regioFoodValleyAreas.forEach { area ->
            ModelCard(
                model = TwinModelCardItem(
                    label = area.route.label,
                    url = area.route.url,
                    applicationArea = PrivateSubdomainModel.REGIOFOODVALLEY.applicationArea,
                    imageUrl = PrivateSubdomainModel.REGIOFOODVALLEY.imageUrl,
                    isPrivate = PrivateSubdomainModel.REGIOFOODVALLEY.isPrivate,
                ),
                showLock = PrivateSubdomainModel.REGIOFOODVALLEY.isPrivate
            )
        }
    }
}