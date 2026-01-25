package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.amersfoort

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.PublicTwinModel
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCard
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.anyLogicPublicApiKey
import kotlin.uuid.Uuid

data class AmersfoortTwinModel(
    override val label: LocalizedText,
    override val url: String = "",
    override val imageUrl: String,
    override val modelId: Uuid,
    override val applicationArea: ApplicationArea = LuxApplicationArea.LUX_RESIDENTIAL_AREA,
    val modelApiKey: Uuid = anyLogicPublicApiKey,
) : PublicTwinModel, TwinModelCard {

    companion object {
        val amersfoortTwinModels = listOf(
            AmersfoortTwinModel(
                label = LocalizedText(en = "Hoge Hoven", nl = "Hoge Hoven"),
                imageUrl = "/lux/images/amersfoort/hogeHoven.png",
                modelId = Uuid.parse("88c97843-1272-4557-beec-09412ef2c32b"),
            ),
            AmersfoortTwinModel(
                label = LocalizedText(en = "Vermeerkwartier", nl = "Vermeerkwartier"),
                imageUrl = "/lux/images/amersfoort/vermeerkwartier.png",
                modelId = Uuid.parse("c103efd9-a9dc-4aef-8f25-71e3bbf6aa3a"),
            ),
            AmersfoortTwinModel(
                label = LocalizedText(en = "Schuilenburg", nl = "Schuilenburg"),
                imageUrl = "/lux/images/amersfoort/schuilenburg.png",
                modelId = Uuid.parse("8c20b4a1-b085-4500-a003-386ee557239d"),
            )
        )
    }
}