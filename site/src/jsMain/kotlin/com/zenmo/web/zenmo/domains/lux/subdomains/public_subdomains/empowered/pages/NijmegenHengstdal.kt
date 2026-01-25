package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun NijmegenHengstdal() {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant
    ) {
        SubHeaderText(
            enText = "Nijmegen Hengstdal",
            nlText = "Nijmegen Hengstdal",
        )
    }

    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        modifier = Modifier.padding(leftRight = 1.cssRem)
    ) {
        AnyLogicEmbed(
            modelId = Uuid.parse("3801076e-44db-4b42-a27f-5be2b6c82a5c"),
        )
    }
}
