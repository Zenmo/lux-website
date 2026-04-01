package energy.lux.frontend.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiSchedule
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.widgets.localizedDateText
import energy.lux.frontend.theme.LuxSpecificColorHues
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import kotlin.js.Date

@Composable
fun ModelLastUpdatedLabel(
    lastModifiedDate: Date,
) {
    Row(
        modifier = Modifier
            .padding(6.px, 8.px)
            .margin(bottom = 1.5.cssRem)
            .gap(8.px)
            .backgroundColor(LuxSpecificColorHues().luxBlue.lightened(0.85f))
            .color(LuxSpecificColorHues().luxBlue)
            .luxBorderRadius(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MdiSchedule()
        val modelDate = lastModifiedDate.localizedDateText(
            js("{ month: 'long', day: 'numeric', year: 'numeric' }")
        )
        LangText(
            en = "Last updated: $modelDate",
            nl = "Laatst bijgewerkt: $modelDate",
        )
    }
}