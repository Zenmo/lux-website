package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLan
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLayers
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.ZenmoLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun BusinessParksText() {
    Column(Modifier.gap(1.cssRem)) {
        Div {
            P {
                LangText(
                    en = """
                    In the Drechtsteden region, companies are forming energy cooperatives to transform how they manage 
                    and trade power. 
                """.trimIndent(),
                    nl = """
                    In de regio Drechtsteden bundelen bedrijven hun krachten door energiecoöperaties op te richten. 
                """.trimIndent()
                )
            }
            P {
                LangText(
                    en = """
                    Using our Lux Energy Twin, these cooperatives establish local energy trading networks, implement 
                    shared energy management systems, and negotiate collective grid connections—optimizing 
                    infrastructure, preventing grid congestion, and maximizing local renewable energy use.
                """.trimIndent(),
                    nl = """
                     Met behulp van onze Lux Energy Twin-technologie werken deze coöperaties aan lokale 
                     energie-uitwisseling, implementeren zij gedeelde energiemanagementsystemen en onderhandelen zij 
                     over groepscontracten voor netaansluitingen. Hiermee optimaliseren ze hun infrastructuur, dragen 
                     ze bij aan het verminderen van netcongestie, en maximalizeren ze het gebruik van lokaal opgewekte 
                     duurzame energie.
                """.trimIndent()
                )
            }
        }
        FeatureDescription()
        Div {
            P {
                ZenmoLink()
                Text(" ")
                LangText(
                    en = """
                            has developed energy twins for all seven Drechtsteden municipalities, mapping every 
                            business park in the region. For select parks, we've created detailed energy twins that 
                            address specific challenges around energy hub design and management systems.
                        """.trimIndent(),
                    nl = """
                            heeft energietwins ontwikkeld voor alle zeven gemeenten in de Drechtsteden, waarbij 
                            alle bedrijventerreinen in de regio in kaart zijn gebracht.Voor geselecteerde terreinen 
                            hebben we gedetailleerde energy twins gecreëerd die specifieke vraagstukken rondom 
                            energiehub-ontwerp en managementsystemen adresseren. 
                        """.trimIndent()
                )
            }
            P {
                LangText(
                    en = """
                    Through this work, Zenmo has helped over 20 business parks launch their energy hub initiatives.
                """.trimIndent(),
                    nl = """
                    Met dit werk heeft Zenmo meer dan 20 bedrijventerreinen geholpen hun energy hub initiatieven te 
                    lanceren.
                """.trimIndent()
                )
            }
        }
    }
}

@Composable
private fun FeatureDescription() {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3, xl = 4),
        modifier = Modifier.gap(1.5.cssRem)
    ) {
        FeatureItem(
            text = LocalizedText(
                en = "Local energy trading networks",
                nl = "Lokale energie-uitwisseling"
            ),
            icon = { MdiLan() }
        )
        FeatureItem(
            text = LocalizedText(
                en = "Shared energy management systems",
                nl = "Energiemanagementsystemen"
            ),
            icon = { MdiElectricBolt() }
        )
        FeatureItem(
            text = LocalizedText(
                en = "Collective grid connections",
                nl = "Groepscontracten voor netaansluitingen"
            ),
            icon = { MdiLayers() }
        )
    }
}

