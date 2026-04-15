package energy.lux.frontend.domains.lux.sections.application_fields.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun PeterContactCard() = ApplicationAreaContactPerson(
    contactPerson = ZenmoTeam.PETER_HOGEVEEN,
    phoneNumberImageSrc = "/lux/images/peter_phone.png"
)