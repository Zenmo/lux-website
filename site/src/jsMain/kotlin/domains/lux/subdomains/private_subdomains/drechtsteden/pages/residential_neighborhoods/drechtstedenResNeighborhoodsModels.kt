package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_neighborhoods

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.PublicDrechtstedenTwinModel
import kotlin.uuid.Uuid

val overTSpoor =
    DrechtstedenTwinModel(
        projectPath = "/overtspoor",
        label = LocalizedText(nl = "Energy Twin Over 't Spoor"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/residential_neighbourhoods/overtspoor",
        modelId = Uuid.parse("612143ff-eedc-4f36-8606-13d4c4d710a7"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/over_t_spoor.png",
        pageComponent = { OverTSpoor() }
    )
val oostdonk =
    DrechtstedenTwinModel(
        projectPath = "/oostdonk",
        label = LocalizedText(nl = "Energy Twin Oostdonk"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/residential_neighbourhoods/oostdonk",
        modelId = Uuid.parse("3b4289ea-d2b8-4887-95bf-bf293fc34263"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/oostdonk.png",
        pageComponent = { Oostdonk() }
    )
val kerkbuurt =
    DrechtstedenTwinModel(
        projectPath = "/kerkbuurt",
        label = LocalizedText(nl = "Energy Twin Kerkbuurt"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/residential_neighbourhoods/kerkbuurt",
        modelId = Uuid.parse("a8d6e6ae-8a4c-4685-9195-33b9cd986c48"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/kerkbuurt.png",
        pageComponent = { Kerkbuurt() }
    )
val landVanValk =
    PublicDrechtstedenTwinModel(
        projectPath = "/landVanValk",
        label = LocalizedText(nl = "Energy Twin Land Van Valk"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        modelId = Uuid.parse("5fbcc4b5-f1b1-4b9c-9b4f-9f10629ebec9"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/landVanValk.png",
        pageComponent = { LandVanValk() }
    )

val centrumHardinxveldGiessendam =
    DrechtstedenTwinModel(
        projectPath = "/centrumHardinxveldGiessendam",
        label = LocalizedText(nl = "Energy Twin Centrum Hardinxveld-Giessendam"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/residential_neighbourhoods/centrumHardinxveldGiessendam",
        modelId = Uuid.parse("268571f0-fb0b-4936-bf75-6d13c285d092"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/centrum_hardinxveld_giessendam.png",
        pageComponent = { CentrumHardinxveldGiessendam() }
    )
val schildersbuurtZwijndrecht =
    DrechtstedenTwinModel(
        projectPath = "/schildersbuurtZwijndrecht",
        label = LocalizedText(nl = "Energy Twin Schildersbuurt Zwijndrecht"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/residential_neighbourhoods/schildersbuurtZwijndrecht",
        modelId = Uuid.parse("d037ad34-4b73-484e-8981-33bde8281130"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/schildersbuurt_zwijndrecht.png",
        pageComponent = { SchildersbuurtZwijndrecht() }
    )
val kruiswielHendrikIdoAmbacht =
    DrechtstedenTwinModel(
        projectPath = "/kruiswielHendrikIdoAmbacht",
        label = LocalizedText(nl = "Energy Twin Kruiswiel Hendrik-Ido-Ambacht"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/residential_neighbourhoods/kruiswielHendrikIdoAmbacht",
        modelId = Uuid.parse("37907489-9a92-4888-8591-ea80dbe6225e"),
        imageUrl = "/lux/images/drechtsteden/residential_neighbourhoods/kruiswiel_hendrik_ido_ambacht.png",
        pageComponent = { KruiswielHendrikIdoAmbacht() }
    )

val drechtstedenNeighbourhoodsModels = listOf(
    overTSpoor,
    oostdonk,
    kerkbuurt,
    landVanValk,
    centrumHardinxveldGiessendam,
    schildersbuurtZwijndrecht,
    kruiswielHendrikIdoAmbacht,
)