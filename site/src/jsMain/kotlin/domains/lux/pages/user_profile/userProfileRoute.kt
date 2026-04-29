package energy.lux.frontend.domains.lux.pages.user_profile

import energy.lux.frontend.core.models.StaticRoute


val userProfileRoute = StaticRoute(
    path = "user-profile",
    pageComponent = { UserProfilePage() }
)