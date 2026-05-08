package energy.lux.frontend.core.services.localization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.Router

@Composable
fun rememberLanguageChangeHandler(
    router: Router = rememberPageContext().router
): LanguageChangeHandler = remember(router) {
    DefaultLanguageChangeHandler(router)
}