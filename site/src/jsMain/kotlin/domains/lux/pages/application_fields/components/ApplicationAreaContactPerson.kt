package energy.lux.frontend.domains.lux.pages.application_fields.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.components.ProfileCardArrangementDirection
import energy.lux.frontend.domains.lux.subdomains.components.ProfileContactCard
import energy.lux.frontend.core.models.ZenmoTeamMember

const val APPLICATION_AREA_CONTACT_PERSON_ID = "application-area-contact-person"

@Composable
fun ApplicationAreaContactPerson(
    contactPerson: ZenmoTeamMember,
    phoneNumberImageSrc: String = "",
) = SectionContainer(
    modifier = Modifier.id(APPLICATION_AREA_CONTACT_PERSON_ID)
) {
    ProfileContactCard(
        name = contactPerson.memberName,
        imageUrl = contactPerson.imageSrc,
        phoneNumberImageSrc = phoneNumberImageSrc,
        email = contactPerson.email,
        cardArrangementDirection = ProfileCardArrangementDirection.HORIZONTAL,
        captionText = LocalizedText(
            en = "Contact person to know more",
            nl = "Contactpersoon voor meer informatie"
        ),
    )
}