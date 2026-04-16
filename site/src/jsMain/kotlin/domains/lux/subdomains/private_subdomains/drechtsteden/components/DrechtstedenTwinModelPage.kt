package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.ModelWrapper
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModelBase
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.PublicDrechtstedenTwinModel
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.domains.zenmo.widgets.anylogic.anyLogicPublicApiKey
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun DrechtstedenTwinModelPage(
    twin: DrechtstedenTwinModelBase,
    introContent: @Composable () -> Unit = {},
    mediaContent: @Composable () -> Unit = {},
    footerContent: @Composable () -> Unit,
) = SubdomainModelPage(
    modelId = Uuid.NIL,
    introContent = {
        Column(
            Modifier.fillMaxWidth()
                .gap(1.cssRem)
        ) {
            HeaderText(
                enText = twin.label.en,
                nlText = twin.label.nl,
            )
            introContent()
        }
    },
    anylogicRender = {
        when (twin) {
            is PublicDrechtstedenTwinModel -> {
                AnyLogicEmbed(
                    modelId = twin.modelId,
                    apiKey = anyLogicPublicApiKey,
                )
            }

            is DrechtstedenTwinModel -> {
                ModelWrapper(
                    imgUrl = twin.imageUrl,
                    entryPoint = twin.entryPoint,
                    modelId = twin.modelId,
                )
            }
        }
    },
    mediaContent = mediaContent,
    footerContent = footerContent,
)