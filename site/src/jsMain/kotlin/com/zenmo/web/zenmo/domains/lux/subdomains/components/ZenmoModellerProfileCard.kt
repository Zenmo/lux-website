package com.zenmo.web.zenmo.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

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