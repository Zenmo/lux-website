package energy.lux.site.frontend.domains.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.zenmo.widgets.ContactForm

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
