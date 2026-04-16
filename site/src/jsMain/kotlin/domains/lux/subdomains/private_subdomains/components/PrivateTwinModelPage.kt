package energy.lux.frontend.domains.lux.subdomains.private_subdomains.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import kotlin.uuid.Uuid

@Composable
fun PrivateTwinModelPage(
    entryPoint: String,
    imageUrl: String,
    modelId: Uuid,
    introContent: @Composable () -> Unit = {},
    mediaContent: @Composable () -> Unit = {},
    extraContent: @Composable () -> Unit = {},
    footerContent: @Composable () -> Unit,
) = SubdomainModelPage(
    modelId = modelId,
    introContent = introContent,
    mediaContent = mediaContent,
    anylogicRender = {
        ModelWrapper(
            imgUrl = imageUrl,
            entryPoint = entryPoint,
            modelId = modelId,
        )
    },
    extraContent = extraContent,
    footerContent = footerContent,
)