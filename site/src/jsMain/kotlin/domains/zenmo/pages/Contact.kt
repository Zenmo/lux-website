package energy.lux.frontend.domains.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.domains.zenmo.widgets.ContactForm

@Composable
fun ContactPage() {
    PageLayout("Contact") {
        Column(
            modifier = HeroContainerStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ContactForm()
        }
    }
}
