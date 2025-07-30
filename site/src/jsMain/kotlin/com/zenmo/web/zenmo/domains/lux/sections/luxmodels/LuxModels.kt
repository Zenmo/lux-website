package com.zenmo.web.zenmo.domains.lux.sections.luxmodels

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiFilterAlt
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


enum class FilterType {
    ALL,
    PUBLIC,
    PRIVATE
}

@Composable
fun LuxModels() {
    SectionContainer(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier =
            Modifier
                .then(TopDividerLineStyle.toModifier())
                .background(SitePalette.light.overlay)
                .position(Position.Relative)
                .gap(5.cssRem),
        variant = LuxSectionContainerStyleVariant
    ) {
        var luxModels by remember { mutableStateOf(publicLuxModels.plus(privateLuxModels)) }
        var filterType by remember { mutableStateOf(FilterType.ALL) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HeaderText(
                enText = "Models",
                nlText = "Models",
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(0.px)
                    .textAlign(TextAlign.Center)
            )
            P(
                Modifier.textAlign(TextAlign.Center).toAttrs(),
            ) {
                LangText(
                    en = "Find out more about our models.",
                    nl = "Lees meer over onze modellen."
                )
                Br { }
                LangText(
                    en = "This includes both our public and private models.",
                    nl = "Dit omvat zowel onze openbare als privémodellen."
                )
            }
            FilterChip(
                onClick = {
                    when (filterType) {
                        FilterType.ALL -> {
                            filterType = FilterType.PUBLIC
                            luxModels = publicLuxModels
                        }

                        FilterType.PUBLIC -> {
                            filterType = FilterType.PRIVATE
                            luxModels = privateLuxModels
                        }

                        FilterType.PRIVATE -> {
                            filterType = FilterType.ALL
                            luxModels = publicLuxModels.plus(privateLuxModels)
                        }
                    }
                },
                filterType = filterType
            )
        }

        val LUX_DOMAIN = SiteGlobals.LUX_DOMAIN
        val protocol = window.location.protocol
        SimpleGrid(
            numColumns = numColumns(base = 2, sm = 2, md = 4, lg = 4, xl = 4),
            modifier = Modifier
                .gap(2.cssRem)
                .padding(bottom = 3.cssRem)
        ) {
            luxModels.forEach { (subdomain, imageUrl) ->
                val domainName = subdomain.domainName.replaceFirstChar { it.uppercase() }
                CardLink(
                    url = "${protocol}//${subdomain.domainName}.$LUX_DOMAIN",
                    imageUrl = imageUrl,
                    imageAltText = domainName,
                    nlTitle = domainName,
                    enTitle = domainName,
                    modifier = Modifier.fillMaxHeight(),
                )
            }
        }
    }
}

//todo use appropriate image for each model
private val publicLuxModels = listOf(
    LuxSubdomains.LOENEN to "/lux/images/models/loenen.png",
    LuxSubdomains.NEDERLAND to "/lux/images/models/nederland.png",
    LuxSubdomains.BRABANT to "/lux/images/models/brabant.png",
    LuxSubdomains.HILVERSUM to "/lux/images/models/hilversum.png",
    LuxSubdomains.BUNDERBUURTEN to "/lux/images/models/bunderbuurten.png",
    LuxSubdomains.ROTTERDAM_DEN_HAAG to "/lux/images/models/rotterdam.png",
    LuxSubdomains.VRUCHTENBUURT to "/lux/images/models/vruchtenbuurt.png"
)

private val privateLuxModels = listOf(
    LuxSubdomains.DRECHTSTEDEN to "/img/drechtsteden-rivier.jpg",
    LuxSubdomains.GENIUS to "/lux/images/models/genius.png",
    LuxSubdomains.HESSENPOORT to "/lux/images/models/hessenpoort.png",
    LuxSubdomains.KAS_ALS_ENERGIEBRON to "/lux/images/models/kasals.png",
)


@Composable
private fun FilterChip(
    onClick: () -> Unit,
    filterType: FilterType = FilterType.ALL,
) {
    Div(
        Modifier
            .display(DisplayStyle.Flex)
            .gap(0.05.cssRem)
            .padding(0.5.cssRem, 1.cssRem)
            .textAlign(TextAlign.Center)
            .background(SitePalette.light.primary)
            .color(SitePalette.light.onPrimary)
            .borderRadius(16.px)
            .cursor(Cursor.Pointer)
            .onClick { onClick() }
            .toAttrs()
    ) {
        when (filterType) {
            FilterType.ALL -> LangText(en = "All", nl = "Alle")
            FilterType.PUBLIC -> LangText(en = "Public", nl = "Openbaar")
            FilterType.PRIVATE -> LangText(en = "Private", nl = "Privé")
        }
        MdiFilterAlt()
    }
}