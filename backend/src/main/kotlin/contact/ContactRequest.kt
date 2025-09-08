package com.zenmo.backend.contact

import org.http4k.core.Body
import org.http4k.core.Request
import org.http4k.lens.MultipartFormField
import org.http4k.lens.Validator
import org.http4k.lens.multipartForm

data class ContactRequest(
    val name: String,
    val companyName: String,
    val telephoneNumber: String,
    val emailAddress: String,
    val message: String,
) {
    companion object {
        fun fromForm(request: Request): ContactRequest {
            val field = MultipartFormField.Companion.string()

            val nameField = field.required("name")
            val companyNameField = field.required("companyName")
            val telephoneNumberField = field.required("telephoneNumber")
            val emailAddressField = field.required("emailAddress")
            val messageField = field.required("message")

            val form = Body.Companion.multipartForm(
                Validator.Strict,
                nameField,
                companyNameField,
                telephoneNumberField,
                emailAddressField,
                messageField,
            ).toLens().invoke(request)

            return ContactRequest(
                name = nameField(form),
                companyName = companyNameField(form),
                telephoneNumber = telephoneNumberField(form),
                emailAddress = emailAddressField(form),
                message = messageField(form),
            )
        }
    }

    fun toEmailBody(): String {
        return """
            Onderstaande is verstuurd vanaf https://zenmo.com/contact
            
            Naam: $name
            Bedrijfsnaam: $companyName
            Telefoonnummer: $telephoneNumber
            E-mailadres: $emailAddress
            
            Bericht:
            
        """.trimIndent() + message
    }
}
