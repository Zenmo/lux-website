package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun OurStoryHero() {
    Box(
        modifier = OurStoryHeroStyle.toModifier()
            .fillMaxWidth()
            .position(Position.Relative)
            .overflow(Overflow.Hidden),
    ) {
        Image(
            src = "/zenmo/images/Adventure-ball-resized.jpg",
            alt = "Hand holding a globe",
            modifier = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover),
        )
        Box(
            modifier = Modifier
                .position(Position.Absolute)
                .top(0.px).left(0.px).right(0.px).bottom(0.px)
                .background(
                    Background.of(
                        image = linearGradient(LinearGradient.Direction.ToBottom) {
                            add(Colors.Transparent, 0.percent)
                            add(Colors.White.copyf(alpha = 0.2f), 50.percent)
                            add(Colors.White, 100.percent)
                        }.toImage()
                    )
                )
        )
    }
}