package energy.lux.site.frontend.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericNamespacedElementBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.css.masking.SVGClipPathElement

val clipPathElementBuilder: ElementBuilder<SVGClipPathElement> = GenericNamespacedElementBuilder
    .create("http://www.w3.org/2000/svg", "clipPath") as ElementBuilder<SVGClipPathElement>

@Composable
fun ClipPath(
    attrs: AttrBuilderContext<SVGClipPathElement>? = null,
    content: ContentBuilder<SVGClipPathElement>? = null
) = TagElement(elementBuilder = clipPathElementBuilder, applyAttrs = attrs, content = content)
