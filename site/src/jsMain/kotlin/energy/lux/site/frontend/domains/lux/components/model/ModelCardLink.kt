package energy.lux.site.frontend.domains.lux.components.model

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLock
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span

@Composable
fun ModelCardLink(
    model: TwinModel,
    url: String,
    modifier: Modifier = Modifier.fillMaxHeight(),
) {
    CardLink(
        url = url,
        imageUrl = model.image,
        imageAltText = model.title,
        nlTitle = model.title,
        enTitle = model.title,
        modifier = modifier,
        description = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Span(
                    Modifier.color(SitePalette.light.primary)
                        .toAttrs()
                ) {
                    LangText(
                        nl = "Bekijk »",
                        en = "View »",
                    )
                }

                if (model.isPrivate) LockIcon()
            }
        },
        metaContent = {
            if (model is SubdomainModel) {
                ApplicationFieldLabel(model.applicationArea)
            }
        }
    )
}


val ApplicationFieldLabelStyle = CssStyle.base {
    Modifier
        .background(Colors.White)
        .padding(leftRight = 0.5.cssRem, topBottom = 0.25.cssRem)
        .borderRadius(3.cssRem)
        .fontFamily(PublicRes.FontFamilies.HOLON_LINE)
        .boxShadow(0.px, 0.px, 5.px, 0.px, rgba(0, 0, 0, 0.3f))
}

@Composable
private fun ApplicationFieldLabel(field: ApplicationArea) {
    Div(
        Modifier.padding(1.cssRem)
            .toAttrs()
    ) {
        Span(
            ApplicationFieldLabelStyle.toModifier()
                .toAttrs()
        ) {
            LangText(
                nl = field.areaTitle.nl,
                en = field.areaTitle.en,
            )
        }
    }
}

@Composable
private fun LockIcon() {
    Box(
        Modifier.width(auto)
            .height(auto)
            .background(SitePalette.light.primary)
            .color(Color.white)
            .padding(0.25.cssRem)
            .borderRadius(50.percent),
        contentAlignment = Alignment.Center
    ) {
        MdiLock(Modifier.scale(0.75))
    }
}