package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.dom.svg.Defs
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.ClipPath
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Video


private const val CLIP_PATH_ID = "heroSVGClipPath"


val LuxHeroMediaContentInnerStyle = CssStyle {
    base {
        Modifier
            .padding(0.px, 0.px, 16.px, 12.px)
            .margin(0.px)
    }
    Breakpoint.LG {
        Modifier.padding(0.px, 0.px, 24.px, 16.px)
    }
}

val AllStyle = CssStyle.base {
    Modifier
        .outline(style = LineStyle.None)
}

val LuxMaskedBlockStyle = CssStyle.base {
    Modifier
        .position(Position.Relative)
        .borderRadius(24.px)
}
val LuxHeroMediaContentStyle = CssStyle.base {
    Modifier
        .maxWidth(30.percent)
        .width(Width.MaxContent)
        .textAlign(TextAlign.Right)
}

val MaskedContentAtTopRightStyle = CssStyle.base {
    Modifier
        .position(Position.Absolute)
        .top(0.px)
        .right(0.px)
        .left(auto)
        .bottom(auto)
}

val LuxHeroContentStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
            .objectFit(ObjectFit.Cover)
            .display(DisplayStyle.Block)
            .background(
                Background.of(
                    image = linearGradient(rgba(0, 0, 0, 0.5f), rgba(0, 0, 0, 0.5f)).toImage()
                )
            )
    }
    Breakpoint.ZERO {
        Modifier.height(425.px)
    }
    Breakpoint.SM {
        Modifier.height(425.px)
    }
    Breakpoint.MD {
        Modifier.height(500.px)
    }
    Breakpoint.LG {
        Modifier.height(600.px)
    }
    Breakpoint.XL {
        Modifier.height(700.px)
    }
}

@Composable
fun Hero() {
    Div(
        Modifier
            .id("hero-container")
            .fillMaxWidth()
            .position(Position.Relative)
            .then(AllStyle.toModifier())
            .toAttrs()
    ) {
        Div(
            LuxMaskedBlockStyle.toModifier()
                .then(AllStyle.toModifier())
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .toAttrs()
        ) {

            HeaderText(
                enText = "THIS IS LUX.",
                nlText = "DIT IS LUX.",
                modifier = Modifier
                    .color(SitePalette.light.primary)
            )

            Div(
                LuxMaskedBlockStyle.toModifier()
                    .toAttrs()
            ) {
                Box(
                    Modifier
                        .aspectRatio(2, 1)
                        .styleModifier {
                            property(
                                "clip-path", "url(#$CLIP_PATH_ID)"
                            )
                        }
                ) {
                    Video(
                        attrs = Modifier
                            .objectFit(ObjectFit.Cover)
                            .display(DisplayStyle.Block)
                            .fillMaxSize()
                            .borderRadius(24.px)
                            .toAttrs {
                                ref {
                                    // muted doesn't work when set via attr()
                                    it.muted = true
                                    onDispose { }
                                }
                                // todo replace this with a LUX video
                                attr("src", "/lux/videos/hero_vid.mp4")
                                attr("autoplay", "true")
                                attr("loop", "true")
                                attr("preload", "true")
                                attr("width", "100%")
                                attr("height", "100%")
                            })
                }

                Div(
                    Modifier
                        .id("hero-content")
                        .then(LuxHeroMediaContentStyle.toModifier())
                        .then(MaskedContentAtTopRightStyle.toModifier())
                        .then(AllStyle.toModifier())
                        .displayIfAtLeast(Breakpoint.LG)
                        .toAttrs()
                ) {
                    P(
                        LuxHeroMediaContentInnerStyle.toModifier()
                            .then(TextStyle.toModifier(HolonLineTextStyle))
                            .toAttrs()
                    ) {
                        LangText(
                            en = "With LUX, the integration of sustainable energy becomes fun and lucrative.",
                            nl = "Met LUX wordt de integratie van duurzame energie leuk en lucratief.",
                        )
                    }
                }
            }

            SvgPath(
                containerId = "hero-container",
                contentId = "hero-content",
                modifier = Modifier
                    .position(Position.Absolute)
                    .left(0.px)
                    .top(0.px)
                    .opacity(0)
            )
        }
    }
}


@Composable
private fun SvgPath(
    containerId: String = "hero-container",
    contentId: String = "hero-content",
    modifier: Modifier = Modifier
) {

    var path by remember { mutableStateOf("") }


    val br = 24 // Default border radius
    val ibr = 24 // Inner border radius


    fun computePath(): String {
        val container = document.getElementById(containerId) ?: return ""
        val content = document.getElementById(contentId) ?: return ""

        val containerRect = container.getBoundingClientRect()
        val contentRect = content.getBoundingClientRect()

        val tw = containerRect.width
        val th = containerRect.height
        val cw = contentRect.width
        val ch = contentRect.height

        return """
            M 0 $br
            a $br $br 0 0 1 $br -${br}
            L ${tw - cw - br} 0
            a $br $br 0 0 1 $br $br
            L ${tw - cw} ${ch - ibr}
            a $ibr $ibr 0 0 0 $ibr $ibr
            L ${tw - br} $ch
            a $br $br 0 0 1 $br $br
            L $tw ${th - br}
            a $br $br 0 0 1 -$br $br
            L $br $th
            a $br $br 0 0 1 -$br -${br}
            Z
        """.trimIndent()
    }

    val resizeListener: (Any) -> Unit = { path = computePath() }
    LaunchedEffect(Unit) {
        path = computePath()
    }

    // we need this to update the path when the window is resized
    DisposableEffect(resizeListener) {
        window.addEventListener("resize", resizeListener)
        onDispose {
            window.removeEventListener("resize", resizeListener)
        }
    }

    Svg(
        attrs = modifier.toAttrs {
            attr("width", "0")
            attr("height", "0")
        }
    ) {
        Defs {
            ClipPath(attrs = { id(CLIP_PATH_ID) }) {
                Path { d(path) }
            }
        }
    }
}