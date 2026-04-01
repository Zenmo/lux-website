package energy.lux.frontend.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.vh


@Composable
fun LuxHero() {
    Box(
        Modifier
            .fillMaxWidth()
            .position(Position.Relative)
            .height(100.vh),
        contentAlignment = Alignment.Center
    ) {
        ClippedHeroVideoBackground()
        HeroParagraphAndVideoContent()
    }
}

