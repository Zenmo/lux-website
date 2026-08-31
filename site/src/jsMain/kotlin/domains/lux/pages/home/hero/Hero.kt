package energy.lux.frontend.domains.lux.pages.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.style.toModifier

@Composable
fun LuxHero() {
    Box(
        LuxHeroStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        ClippedHeroVideoBackground()
        HeroParagraphAndVideoContent()
    }
}