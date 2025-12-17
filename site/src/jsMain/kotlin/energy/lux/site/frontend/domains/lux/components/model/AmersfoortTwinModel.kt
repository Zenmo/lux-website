package energy.lux.site.frontend.domains.lux.components.model

import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.anyLogicPublicApiKey
import kotlin.uuid.Uuid

sealed class AmersfoortTwinModel(
    title: String,
    entryPoint: String,
    image: String,
    // the models should be public for now because they do not have data yet -Peter@zenmo.com
    isPrivate: Boolean = false,
    val modelId: Uuid,
    val modelApiKey: Uuid = anyLogicPublicApiKey
) : TwinModel(
    title, entryPoint, image, isPrivate
) {

    data object AmersfoortOne : AmersfoortTwinModel(
        "Hoge Hoven",
        "hogeHoven",
        "/lux/images/amersfoort/hogeHoven.png",
        modelId = Uuid.parse("88c97843-1272-4557-beec-09412ef2c32b"),
    )

    data object AmersfoortTwo : AmersfoortTwinModel(
        "Vermeerkwartier",
        "vermeerkwartier",
        "/lux/images/amersfoort/vermeerkwartier.png",
        modelId = Uuid.parse("c103efd9-a9dc-4aef-8f25-71e3bbf6aa3a"),
    )

    data object AmersfoortThree : AmersfoortTwinModel(
        "Schuilenburg",
        "schuilenburg",
        "/lux/images/amersfoort/schuilenburg.png",
        modelId = Uuid.parse("8c20b4a1-b085-4500-a003-386ee557239d"),
    )

    companion object {
        val amersfoortTwinModels = listOf(
            AmersfoortOne,
            AmersfoortTwo,
            AmersfoortThree
        )
    }
}