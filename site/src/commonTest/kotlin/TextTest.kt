package energy.lux.frontend

import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi
import org.jetbrains.compose.web.testutils.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Temporary test to check that we can render HTML when testing.
 *
 * https://github.com/JetBrains/compose-multiplatform/tree/master/tutorials/HTML/Using_Test_Utils
 */
@OptIn(ComposeWebExperimentalTestsApi::class)
class TextTest {
    @Test
    fun textComponentRendersCorrectContent() = runTest {
        composition {
            Text("Hello Compose HTML")
        }

        assertEquals("Hello Compose HTML", root.innerHTML)
    }
}
