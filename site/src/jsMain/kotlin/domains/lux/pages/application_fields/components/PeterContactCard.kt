package energy.lux.frontend.domains.lux.pages.application_fields.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.ZenmoTeamMember

@Composable
fun PeterContactCard() = ApplicationAreaContactPerson(
    contactPerson = ZenmoTeamMember.PETER_HOGEVEEN,
    phoneNumberImageSrc = "/lux/images/peter_phone.png"
)