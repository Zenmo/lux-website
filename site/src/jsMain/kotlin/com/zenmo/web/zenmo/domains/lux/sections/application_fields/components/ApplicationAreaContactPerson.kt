package com.zenmo.web.zenmo.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileCardArrangementDirection
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@Composable
fun ApplicationAreaContactPerson(
    contactPerson: ZenmoTeam,
) = LuxSectionContainer {
    ProfileContactCard(
        name = contactPerson.memberName,
        imageUrl = contactPerson.image,
        email = contactPerson.email,
        cardArrangementDirection = ProfileCardArrangementDirection.HORIZONTAL,
        captionText = LocalizedText(
            en = "Contact person to know more",
            nl = "Contactpersoon voor meer informatie"
        ),
    )
}