package energy.lux.frontend.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.ZenmoLink
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangBlock
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


const val LUX_GITHUB_REPO_URL = "https://github.com/Zenmo/zero_engine.git"

data class FaqItem(
    val question: LocalizedText,
    val answerBlock: @Composable () -> Unit = {},
) {
    companion object {
        val faqs = listOf(
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a business?",
                    nl = "Hoe pas ik LUX toe als bedrijf?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                For businesses, LUX company will provide you the valuable insight of how your company 
                                consumes, produces and stores all forms of energy.  Don’t stick with the current 
                                situation, the purpose of LUX is to realize your future scenarios in a digital 
                                environment. Explore an optimal charging strategy for your trucks when you electrify, 
                                the battery capacity you need to realize your growth while remaining within your 
                                grid capacity, or how much it benefits your business by installing solar panels or wind 
                                turbines.
                            """.trimIndent(),
                            nl = """
                                LUX Bedrijf biedt waardevolle inzichten in hoe een bedrijf alle vormen van energie 
                                verbruikt, produceert en opslaat. Blijf niet hangen in de huidige situatie; met LUX kan je 
                                jouw toekomstscenario's in een digitale omgeving realiseren. Ontdek de optimale 
                                laadstrategie voor je vrachtwagens bij elektrificatie, de benodigde batterijcapaciteit 
                                om je groei te realiseren binnen de grenzen van je netaansluiting, of hoeveel 
                                voordeel je bedrijf behaalt door zonnepanelen of windturbines te installeren.
                            """.trimIndent()
                        )
                    }

                    P {
                        LangBlock(
                            en = {
                                Text("You can either download the model yourself at our ")
                                InlineLink(
                                    destinationUrl = LUX_GITHUB_REPO_URL,
                                    enLinkText = "GitHub repo",
                                    nlLinkText = "GitHub repo",
                                )
                                Text(" and create the required input files, or you can request an offer from ")
                                ZenmoLink()
                                Text(
                                    """
                                    . In both cases, you can tweak LUX to go into as much detail you desire for the 
                                    analysis. For example, add production lines, new KPIs, or load in a floor plan of 
                                    your business.
                                """.trimIndent()
                                )
                            },
                            nl = {
                                Text("Je kunt het model zelf downloaden via onze ")
                                InlineLink(
                                    destinationUrl = LUX_GITHUB_REPO_URL,
                                    enLinkText = "GitHub repo",
                                    nlLinkText = "GitHub repo",
                                )
                                Text(" en de benodigde invoerbestanden aanmaken, of je kunt een offerte aanvragen bij ")
                                ZenmoLink()
                                Text(
                                    """
                                    . In beide gevallen kun je LUX aanpassen om de analyse zo gedetailleerd te maken als je 
                                    wilt. Voeg bijvoorbeeld productielijnen, nieuwe KPI's toe of laad een plattegrond van 
                                    je bedrijf in.
                                """.trimIndent()
                                )
                            }
                        )
                    }
                }
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a policy maker?",
                    nl = "Hoe pas ik LUX toe als beleidsmaker?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                As a policy maker, do you want to explore the heat transition in neighborhoods? Do a 
                                first analysis different forms of district heating? See the impact of ‘going off the 
                                gas grid’? Want to see how much grid congestion there is and explore how many 
                                transformer stations and neighborhood batteries are required in public space? These 
                                questions can be answered with LUX Neighborhood.
                            """.trimIndent(),
                            nl = """
                                Wil jij als beleidsmaker de warmtetransitie in wijken verkennen? Een eerste analyse 
                                maken van verschillende vormen van stadsverwarming? Wil je de impact zien van ‘van het 
                                gas af gaan’? Wilt je zien hoeveel netcongestie er is en hoeveel transformatorstations 
                                en buurtbatterijen er nodig zijn in de openbare ruimte? Deze vragen kunnen beantwoord 
                                worden met LUX Woonwijk.
                            """.trimIndent()
                        )
                    }
                    P {
                        LangText(
                            en = """
                                With LUX Energy Hub, policy makers explore how they can assist their local businesses 
                                and facilitate workshops to further the energy transition. With LUX region they 
                                get an overall view of the municipality, connecting all neighborhoods and business 
                                parks and exploring the impact on the Medium-Voltage grid.   
                            """.trimIndent(),
                            nl = """
                                Met LUX Energie Hub onderzoeken beleidsmakers hoe ze hun lokale bedrijven kunnen helpen 
                                en workshops kunnen faciliteren die de energietransitie vooruit helpen. Met LUX regio 
                                krijgen ze een totaalbeeld van de gemeente, verbinden ze alle woonwijk en 
                                bedrijventerreinen en verkennen ze de impact op het middenspanningsnet.

                            """.trimIndent()
                        )
                        Br { }
                        Br { }

                        InlineLink(
                            destinationUrl = "/book-demo",
                            enLinkText = "Contact Zenmo",
                            nlLinkText = "Neem contact op met Zenmo",
                        )
                        LangText(
                            en = "  to get a better idea of how this could work.",
                            nl = "  om een beter idee te krijgen van hoe dit zou kunnen werken."
                        )
                    }
                }
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a energy cooperation?",
                    nl = "Hoe pas ik LUX toe als energiecoöperatie?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a researcher/consultant?",
                    nl = "Hoe pas ik LUX toe als onderzoeker/adviseur?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How is LUX updated and maintained?",
                    nl = "Hoe wordt LUX bijgewerkt en onderhouden?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                LUX is continuously in progress. Zenmo develops LUX and adds new features every month. 
                                Sometimes there are small updates, sometimes completely new modules are added. Previous 
                                models can be updated with newer versions. However, in some cases new input is also 
                                required. In that case, an update does require additional work.  
                            """.trimIndent(),
                            nl = """
                                LUX is voortdurend in ontwikkeling. Zenmo ontwikkelt LUX en voegt elke maand nieuwe 
                                functies toe. Soms zijn er kleine updates, soms worden er compleet nieuwe modules 
                                toegevoegd. Eerdere modellen kunnen worden geactualiseerd naar een nieuwe versie. In 
                                sommige gevallen is echter ook nieuwe input nodig. In dat geval vergt een update wel 
                                extra werk.
                            """.trimIndent()
                        )
                    }
                }
            ),
            FaqItem(
                question = LocalizedText(
                    en = "Where can I find the code base?",
                    nl = "Waar kan ik de codebase vinden?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                LUX is an open-source model. Feel free to download it and adjust it to your needs. 
                                Find it at   
                            """.trimIndent(),
                            nl = """
                                LUX is een opensource-model. Download hem gerust en pas hem aan naar jouw wensen. 
                                Vind het op 
                            """.trimIndent()
                        )
                        InlineLink(
                            destinationUrl = LUX_GITHUB_REPO_URL,
                            enLinkText = "LUX GitHub Repository",
                            nlLinkText = "LUX GitHub Repository",
                        )
                    }
                }
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How does the LUX model work?",
                    nl = "Hoe werkt het LUX-model?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                All LUX models are agent-based models, simulating energy systems from the bottom-up. 
                                That means that, all the behavior of the energy system is the result of behavior of the 
                                assets that are connected to it. For example, how much load is there currently on this 
                                specific LV-transformer depends on the behavior of all buildings and charging points 
                                connected to it, which in turn is the result of all cars, heat pumps, solar panels, and 
                                other assets connected to those. Their behavior is modelled in timesteps of 15-minutes 
                                (other options are also possible). The model is heterogeneous, meaning that e.g. each 
                                household has different characteristics (such as isolation level, electricity demand, 
                                hot water demand, potential for solar panels, etc.) and thus different behavior, just 
                                like in practice. The heterogeneity is dependent on statistics, which are input 
                                parameters for the model and can be tweaked to the local situation. 
                            """.trimIndent(),
                            nl = """
                                Alle LUX-modellen zijn agent-based modellen die energiesystemen van onderaf 
                                simuleren. Dat betekent dat al het gedrag van het energiesysteem het resultaat is van 
                                het gedrag van de aangesloten apparaten. De belasting van een specifieke 
                                laagspanningstransformator hangt bijvoorbeeld af van het gedrag van alle gebouwen en 
                                laadpunten die erop zijn aangesloten, wat op zijn beurt weer het gevolg is van alle 
                                auto's, warmtepompen, zonnepanelen en andere apparaten die daarop zijn aangesloten. Hun 
                                gedrag wordt gemodelleerd in tijdstappen van 15 minuten (andere opties zijn ook 
                                mogelijk). Het model is heterogeen, wat betekent dat bijvoorbeeld elk huishouden andere 
                                kenmerken heeft (zoals isolatieniveau, elektriciteitsvraag, warmwatervraag, potentieel 
                                voor zonnepanelen, enz.) en dus ander gedrag vertoont, net als in de praktijk. De 
                                heterogeniteit is afhankelijk van statistieken, die als invoerparameters voor het model 
                                dienen en kunnen worden aangepast aan de lokale situatie.
                            """.trimIndent()
                        )
                    }
                    P {
                        LangBlock(
                            en = {
                                Text("To run a LUX model locally, you need to download the code and install ")
                                InlineLink(
                                    destinationUrl = "https://www.anylogic.com/downloads/",
                                    enLinkText = "Anylogic",
                                    nlLinkText = "Anylogic",
                                )
                                Text(". ")
                                ZenmoLink()
                                Text(" ")
                                Text(
                                    """
                                    can also do this step for you, and in that case you can get an online environment 
                                    to run the model from a cloud. This can be done through an open or completely 
                                    secured link. 
                                """.trimIndent()
                                )
                            },
                            nl = {
                                Text("Om een LUX-model lokaal uit te voeren, moet je de code downloaden en ")
                                InlineLink(
                                    destinationUrl = "https://www.anylogic.com/downloads/",
                                    enLinkText = "AnyLogic",
                                    nlLinkText = "AnyLogic",
                                )
                                Text(" installeren. ")
                                ZenmoLink()
                                Text(" ")
                                Text(
                                    """
                                        kan deze stap ook voor je uitvoeren, je krijgt dan een online omgeving om het 
                                        model vanuit de cloud uit te voeren. Dit kan via een open of volledig 
                                        beveiligde verbinding.
                                    """.trimIndent()
                                )
                            }
                        )
                    }
                }
            ),
            FaqItem(
                question = LocalizedText(
                    en = "What data goes into LUX?",
                    nl = "Welke gegevens worden in LUX verwerkt?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                That really depends on the application area. But typically, one can upload a lot of 
                                measurement data such as quarterly profiles from: grid nodes, buildings/companies, 
                                charging points and production assets. There is also a lot of open-source data involved 
                                such as: GIS objects, grid layout, building areas, Postcode6 energy consumption, etc. Each 
                                model can be enriched with detailed data. However, all that data is optional. If not 
                                available, LUX will use default profiles, characteristics and estimates based on Dutch 
                                or local averages.  
                            """.trimIndent(),
                            nl = """
                                Dat hangt echt af van het toepassingsgebied. Maar doorgaans kan men veel meetgegevens 
                                uploaden, zoals kwartaalprofielen van: netknooppunten, gebouwen/bedrijven, laadpunten 
                                en productie-installaties. Er is ook veel open-source data beschikbaar, zoals: 
                                GIS-objecten, netplattegronden, bebouwde oppervlakten, Postcode6-energieverbruik, enzovoort. 
                                Elk model kan worden verrijkt met gedetailleerde gegevens. Al deze gegevens zijn echter 
                                optioneel. Als het niet beschikbaar is, gebruikt LUX standaardprofielen, 
                                kenmerken en schattingen gebaseerd op Nederlandse of lokale gemiddelden.
                            """.trimIndent()
                        )
                    }
                    P {
                        LangText(
                            en = """
                                LUX Neighbourhood can be enriched with data per house about solar production, heating 
                                dynamics, car ownership, hot water consumption, isolation levels, and more. Also, data 
                                of elements in public space such as; district heating characteristics, wind turbines 
                                and shared batteries.  
                            """.trimIndent(),
                            nl = """
                                LUX Woonwijk kan worden verrijkt met gegevens per woning over zonne-energieproductie,  
                                verwarmingsdynamiek, autobezit, warmwaterverbruik, isolatieniveaus en meer. Ook 
                                gegevens over elementen in de openbare ruimte, zoals kenmerken van stadsverwarming, 
                                windturbines en gedeelde batterijen, kunnen worden toegevoegd.
                            """.trimIndent()
                        )
                        Br { }
                        Br { }

                        LangText(
                            en = """
                                LUX energy hub can be enriched with detailed scenarios of the companies. What will each 
                                company do the following years? Install new solar panels, increase consumption, add a 
                                new building, electrify heating or transport, etc. These scenarios can be defined 
                                through an online questionnaire that can be connected to LUX energy hub. 
                            """.trimIndent(),
                            nl = """
                                LUX Energie Hub kan worden verrijkt met gedetailleerde scenario's van de bedrijven. Wat 
                                gaat elk bedrijf de komende jaren doen? Nieuwe zonnepanelen installeren, het verbruik 
                                verhogen, een nieuw gebouw toevoegen, verwarming of transport elektrificeren, 
                                enzovoort. Deze scenario's kunnen worden gedefinieerd via een online vragenlijst die 
                                aan LUX Energie Hub kan worden gekoppeld.
                            """.trimIndent()
                        )

                        Br { }
                        Br { }

                        LangText(
                            en = """
                                LUX region can be enriched with energy related policy plans per neighborhood and data 
                                per area that is more detailed than the CBS data. 
                            """.trimIndent(),
                            nl = """
                                LUX-regio kan worden verrijkt met energiegerelateerde beleidsplannen per woonwijk en 
                                gegevens per gebied die gedetailleerder zijn dan de gegevens van het CBS.
                            """.trimIndent()
                        )
                    }
                }
            ),

            FaqItem(
                question = LocalizedText(
                    en = "How is the electricity grid implemented in LUX?",
                    nl = "Hoe is het elektriciteitsnet geïmplementeerd in LUX?"
                ),
                answerBlock = {
                    P {
                        LangText(
                            en = """
                                In the Netherlands, the locations of transformer stations and the grid cables is open 
                                data. Those are always loaded into LUX models. However, you won’t know what buildings 
                                are connected to which stations, what the capacity of those stations are, and what the 
                                load profiles are. If that data is available in your project (e.g. because the 
                                grid operator is also involved) it can also be added. If not, one can choose which 
                                buildings to connect to which part of the grid.   
                            """.trimIndent(),
                            nl = """
                                In Nederland zijn de locaties van transformatorstations en netkabels openbaar. Deze 
                                gegevens worden altijd in LUX-modellen ingevoerd. Je weet echter niet welke gebouwen op 
                                welke stations zijn aangesloten, wat de capaciteit van die stations is en wat de 
                                belastingprofielen zijn. Als deze gegevens beschikbaar zijn in jouw project (bijvoorbeeld 
                                omdat de netbeheerder erbij betrokken is), kunnen ze worden toegevoegd. Zo niet, dan 
                                kan je zelf kiezen welke gebouwen op welk deel van het net worden aangesloten.
                            """.trimIndent()
                        )
                    }
                }
            ),
        )
    }
}