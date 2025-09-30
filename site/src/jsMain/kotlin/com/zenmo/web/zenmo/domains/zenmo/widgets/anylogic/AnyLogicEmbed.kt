package com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.dom.svg.Image
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.dom.svg.SvgId
import com.varabyte.kobweb.compose.dom.svg.Symbol
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LoadingSpinner
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals.LUX_DOMAIN
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import kotlin.uuid.Uuid

/**
 * API key of user publiek@zenmo.com for use with publicly available models
 */
val anyLogicPublicApiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710")

val AnyLogicEmbedStyle = CssStyle {
    base {
        Modifier
            // AnyLogic elements use absolute positioning.
            // This makes those elements relative to this parent.
            .position(Position.Relative)
            // Make sure it fits on the screen.
            // Reserve space for site header.
            .maxHeight(80.vh)
            .width(100.percent)
            // 8:5 Approaches the default aspect ratio in AnyLogic.
            // It is possible to create a model for a different aspect ratio.
            .aspectRatio(8, 5)
            .boxShadow(
                BoxShadow.of(0.px, 4.px, 8.px, 0.px, rgba(0, 0, 0, 0.2f)),
                BoxShadow.of(0.px, 6.px, 20.px, 0.px, rgba(0, 0, 0, 0.19f))
            )
    }
}

enum class AnyLogicModelStatus {
    IDLE,
    LOADING,
    RUNNING,
    FAILED
}

/**
 * Embed a simulation from AnyLogic Cloud
 */
@Composable
fun AnyLogicEmbed(
    modifier: Modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 4.cssRem),
    modelId: Uuid,
    apiKey: Uuid = anyLogicPublicApiKey,
    cloudUrl: String = "${AppGlobals.getValue("BACKEND_URL")}/anylogic-proxy",
) {
    val containerId = remember { "anylogic-embed-${randomString(4u)}" }
    var status by remember { mutableStateOf(AnyLogicModelStatus.IDLE) }

    LaunchedEffect(modelId) {
        status = AnyLogicModelStatus.LOADING
        try {
            val client = CloudClient.create(apiKey.toHexDashString(), cloudUrl)
            val model = client.getModelById(modelId.toHexDashString()).await()
            val modelVersion = client.getLatestModelVersion(model).await()
            val inputs = client.createDefaultInputs(modelVersion)
            // need to mark status as running to render model before starting animation, because
            // startAnimation(...).await() suspends for as long as the animation runs.
            status = AnyLogicModelStatus.RUNNING
            client.startAnimation(inputs, containerId).await()
        } catch (e: Exception) {
            console.error("Failed to load AnyLogic model", e)
            status = AnyLogicModelStatus.FAILED
        }
    }


    Box(
        modifier = AnyLogicEmbedStyle
            .toModifier().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        when (status) {
            AnyLogicModelStatus.IDLE -> Unit

            AnyLogicModelStatus.LOADING -> LoadingSpinner()

            AnyLogicModelStatus.FAILED -> SubHeaderText(
                enText = "Failed to load model",
                nlText = "Laden van model mislukt",
            )

            AnyLogicModelStatus.RUNNING -> {
                AnyLogicImageOverride()

                Div(
                    attrs = Modifier.fillMaxSize().toAttrs {
                        id(containerId)
                    }
                )
            }
        }
    }
}

/**
 * AnyLogic uses the SVG elements "symbol" and "use" to embed images.
 * We can override the default images by giving a symbol the same ID
 * and rendering it earlier in the DOM.
 */
@Composable
fun AnyLogicImageOverride() {
    Svg(
        attrs = {
            style {
                display(DisplayStyle.None)
            }
        }
    ) {
        Symbol(
            id = SvgId("control-panel-icon-anylogic-logo-full"),
            attrs = {
                viewBox(0, 0, 150, 50)
            },
        ) {
            Image {
                width(150)
                height(50)
                // need to set the domain or it will reference the AnyLogic Cloud domain.
                href("${window.location.protocol}//$LUX_DOMAIN/lux/logos/lux-energy-twin.png")
            }
        }
    }
}

fun randomString(length: UInt): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

    return buildString {
        repeat(length.toInt()) {
            append(chars.random())
        }
    }
}
