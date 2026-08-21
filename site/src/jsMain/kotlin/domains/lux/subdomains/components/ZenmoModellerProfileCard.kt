package energy.lux.frontend.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.ZenmoTeamMember

@Composable
fun ZenmoModellerProfileCard(
    modeller: ZenmoTeamMember,
    cardArrangementDirection: ProfileCardArrangementDirection = ProfileCardArrangementDirection.HORIZONTAL,
) = ProfileContactCard(
    name = modeller.memberName,
    imageUrl = modeller.imageSrc,
    email = modeller.email,
    cardArrangementDirection = cardArrangementDirection,
)