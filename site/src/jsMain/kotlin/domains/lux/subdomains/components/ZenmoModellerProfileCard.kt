package energy.lux.frontend.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.ZenmoTeam

@Composable
fun ZenmoModellerProfileCard(
    modeller: ZenmoTeam,
    cardArrangementDirection: ProfileCardArrangementDirection = ProfileCardArrangementDirection.HORIZONTAL,
) = ProfileContactCard(
    name = modeller.memberName,
    imageUrl = modeller.image,
    email = modeller.email,
    cardArrangementDirection = cardArrangementDirection,
)