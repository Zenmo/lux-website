package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.icons.mdi.MdiAutoGraph
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBiotech
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDirectionsCar
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHub
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLan
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTroubleshoot
import energy.lux.frontend.core.services.localization.LocalizedText

data class ServiceItem(
    val icon: @Composable () -> Unit,
    val titleText: LocalizedText,
)

val zenmoServices = listOf(
    ServiceItem(
        icon = { MdiBiotech() },
        titleText = LocalizedText(
            en = "Research Projects",
            nl = "Onderzoeksprojecten",
        )
    ),
    ServiceItem(
        icon = { MdiTroubleshoot() },
        titleText = LocalizedText(
            en = "Energy Consulting",
            nl = "Energieadvies",
        ),
    ),
    ServiceItem(
        icon = { MdiLan() },
        titleText = LocalizedText(
            en = "Interactive Models",
            nl = "Interactieve Modellen",
        ),
    ),
    ServiceItem(
        icon = { MdiAutoGraph() },
        titleText = LocalizedText(
            en = "Grid Optimization",
            nl = "Netoptimalisatie",
        ),
    ),
    ServiceItem(
        icon = { MdiHub() },
        titleText = LocalizedText(
            en = "Digital Twins",
            nl = "Digital twins",
        ),
    ),
    ServiceItem(
        icon = { MdiDirectionsCar() },
        titleText = LocalizedText(
            en = "Smart Mobility",
            nl = "Slimme mobiliteit",
        ),
    ),
)