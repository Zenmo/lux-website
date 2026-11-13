package energy.lux.prerender

import java.io.File

/**
 * Decides which JavaScript chunks may be served while pre-rendering:
 * only chunks with `accessPolicy = AccessPolicy.Public()`.
 *
 * The backend decides this by running the module (JsAccessPolicyEvaluator in the backend project).
 * Here we look for the compiled Public policy in the file text instead, which is simpler.
 * It fails closed: if the compiled output ever changes, chunks are treated as protected,
 * so pages fail to render instead of leaking protected content.
 */
class PublicChunks {
    private val publicPolicy = Regex("""accessPolicy\$\d* = new \(Public\(\)\)\(\)""")
    private val isPublicByFile = mutableMapOf<File, Boolean>()

    fun isPublic(chunk: File): Boolean =
        isPublicByFile.getOrPut(chunk) { chunk.isFile && publicPolicy.containsMatchIn(chunk.readText()) }
}
