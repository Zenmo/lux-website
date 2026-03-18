package com.zenmo.web.zenmo.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileCardArrangementDirection
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

const val APPLICATION_AREA_CONTACT_PERSON_ID = "application-area-contact-person"

@Composable
fun ApplicationAreaContactPerson(
    contactPerson: ZenmoTeam,
) = LuxSectionContainer(
    modifier = Modifier.id(APPLICATION_AREA_CONTACT_PERSON_ID)
) {
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