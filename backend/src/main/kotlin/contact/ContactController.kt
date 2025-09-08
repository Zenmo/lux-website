package com.zenmo.backend.contact

import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.OK

/**
 * Returns user info from the session
 */
class ContactController(
    private val mailService: MailService,
) {
    fun handler(request: Request): Response {
        val contactRequest = try {
            ContactRequest.fromForm(request)
        } catch (e: Exception) {
            return Response(BAD_REQUEST).body("Invalid form data: ${e.message}")
        }

        mailService.sendMail(contactRequest)

        return Response(OK).body(contactRequest.toString())
    }
}

