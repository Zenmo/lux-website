package energy.lux.frontend.domains.zenmo.pages.home.hero

import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px

val HeroIllustrationStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(auto)
            .objectFit(ObjectFit.Contain)
    }
    Breakpoint.MD {
        Modifier
            .height(320.px)
    }
    Breakpoint.XL {
        Modifier
            .height(340.px)
    }
}