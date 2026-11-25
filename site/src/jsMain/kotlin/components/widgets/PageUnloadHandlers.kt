package energy.lux.frontend.components.widgets

import kotlinx.browser.window
import org.w3c.dom.events.Event

/**
 * Call [onUnload] when the user closes the tab, reloads or navigates to another site.
 * Compose disposal does not run in those cases, so embedded models use this to stop their simulation.
 *
 * @return a function that removes the listeners again
 */
fun registerPageUnloadHandlers(onUnload: () -> Unit): () -> Unit {
    val unloadEvents = listOf("beforeunload", "pagehide")
    val handlers = unloadEvents.map { event ->
        val handler: (Event) -> Unit = { onUnload() }
        window.addEventListener(event, handler)
        event to handler
    }

    return {
        handlers.forEach { (event, handler) ->
            window.removeEventListener(event, handler)
        }
    }
}
