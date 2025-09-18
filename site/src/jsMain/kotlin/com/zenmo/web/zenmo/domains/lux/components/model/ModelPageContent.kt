package com.zenmo.web.zenmo.domains.lux.components.model

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.ModelWrapper
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

/**
 * Composable function to render the content of a model page.
 *
 * @param twin The `TwinModel` object containing information about the model, such as title, image, and entry point.
 * @param enDescriptionParagraph The English description paragraph for the model.
 * @param nlDescriptionParagraph The Dutch description paragraph for the model.
 * @param enSubDescriptionParagraph (Optional) The English sub-description paragraph for the model.
 * @param nlSubDescriptionParagraph (Optional) The Dutch sub-description paragraph for the model.
 * @param enHeaderText (Optional) The English header text for the model. Defaults to the title of the `TwinModel`.
 * @param nlHeaderText (Optional) The Dutch header text for the model. Defaults to the title of the `TwinModel`.
 * @param enSubHeaderText (Optional) The English sub-header text for the model.
 * @param nlSubHeaderText (Optional) The Dutch sub-header text for the model.
 * @param imageUrl (Optional) The URL of the image to display. Defaults to the image in the `TwinModel`.
 * @param metaContent (Optional) A composable lambda for rendering additional metadata content.
 * @param modelContent (Optional) A composable lambda for rendering the model content. Defaults to rendering a `ModelWrapper`
 *        if the `TwinModel` has an entry point.
 * @param contactContent A composable lambda for rendering the contact content.
 *
 * @see
 */
@OptIn(DelicateApi::class)
@Composable
fun ModelPageContent(
    twin: TwinModel,
    enDescriptionParagraph: String,
    nlDescriptionParagraph: String,
    enSubDescriptionParagraph: String? = null,
    nlSubDescriptionParagraph: String? = null,
    enHeaderText: String = twin.title,
    nlHeaderText: String = twin.title,
    enSubHeaderText: String? = null,
    nlSubHeaderText: String? = null,
    imageUrl: String? = null,
    metaContent: @Composable (() -> Unit)? = null,
    modelContent: @Composable () -> Unit = {
        if (twin.entryPoint != null) {
            ModelWrapper(
                imgUrl = twin.image,
                entryPoint = twin.entryPoint,
            )
        }
    },
    contactContent: @Composable () -> Unit,
) {
    val breakpoint = rememberBreakpoint()
    metaContent?.invoke()
    SectionContainer(
        modifier = Modifier.gap(
            if (breakpoint < Breakpoint.MD) 5.cssRem else 10.cssRem
        ).fillMaxWidth(),
        variant = LuxSectionContainerStyleVariant,
    ) {
        MediaContentLayout(
            title = {
                HeaderText(
                    enText = enHeaderText,
                    nlText = nlHeaderText,
                    modifier = Modifier.color(SitePalette.light.primary).margin(top = 0.cssRem)
                )
            },
            subtitle = {
                if (enSubHeaderText != null && nlSubHeaderText != null) {
                    SubHeaderText(
                        enText = enSubHeaderText,
                        nlText = nlSubHeaderText,
                        modifier = DeEmphasizedTextStyle.toModifier().margin(0.cssRem)
                    )
                }
            },
            description = {
                P(
                    DeEmphasizedTextStyle.toModifier().toAttrs()
                ) {
                    LangText(
                        en = enDescriptionParagraph,
                        nl = nlDescriptionParagraph,
                    )
                }
            },
            actionText = {
                if (enSubDescriptionParagraph != null && nlSubDescriptionParagraph != null) {
                    P(
                        DeEmphasizedTextStyle.toModifier().toAttrs()
                    ) {
                        LangText(
                            en = enSubDescriptionParagraph,
                            nl = nlSubDescriptionParagraph
                        )
                    }
                }
            },
            reversed = true,
            imageUrl = imageUrl ?: twin.image,
            visualContent = {
                ImageContent(
                    imageUrl = imageUrl ?: twin.image,
                    modifier = Modifier
                        .boxShadow(
                            BoxShadow.of(
                                offsetX = 0.px,
                                offsetY = 1.px,
                                blurRadius = 3.px,
                                spreadRadius = 1.px,
                                color = Colors.Black.copyf(alpha = 0.15f),
                            ),
                            BoxShadow.of(
                                offsetX = 0.px,
                                offsetY = 1.px,
                                blurRadius = 2.px,
                                spreadRadius = 0.px,
                                color = Colors.Black.copyf(alpha = 0.3f),
                            )
                        )
                )
            }
        )
        modelContent()
        contactContent()
    }
}