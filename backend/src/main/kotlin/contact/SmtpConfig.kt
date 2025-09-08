package com.zenmo.backend.contact

import com.zenmo.backend.getEnvRequired
import jakarta.mail.Authenticator
import jakarta.mail.PasswordAuthentication
import jakarta.mail.Session
import java.util.Properties

sealed class SmtpConfig {
    abstract fun createSession(): Session

    data class Azure(
        val userName: String,
        val password: String,
    ) : SmtpConfig() {
        override fun createSession(): Session {
            val props = Properties()
            props.put("mail.smtp.auth", true)
            props.put("mail.smtp.starttls.enable", "true")
            props.put("mail.smtp.host", "smtp.azurecomm.net")
            props.put("mail.smtp.port", "587")
            props.put("mail.smtp.ssl.trust", "smtp.azurecomm.net")

            return Session.getInstance(props, object : Authenticator() {
                override fun getPasswordAuthentication() = PasswordAuthentication(
                    userName, password
                )
            })
        }
    }

    /**
     * For use with a local mailcatcher in development.
     * Example command to run mailcatcher:
     *
           docker run --name=mailcatcher --detach \
               --publish=1080:1080 \
               --publish=1025:1025 \
               dockage/mailcatcher:0.9.0
     */
    object Mailcatcher: SmtpConfig() {
        override fun createSession(): Session {
            val props = Properties()
            props.put("mail.smtp.host", "localhost")
            props.put("mail.smtp.port", "1025")

            return Session.getInstance(props)
        }
    }

    companion object {
        fun create(): SmtpConfig {
            return when (getEnvRequired("SMTP_PROVIDER")) {
                "azure" -> Azure(
                    userName = getEnvRequired("AZURE_SMTP_USER_NAME"),
                    password = getEnvRequired("AZURE_SMTP_PASSWORD"),
                )

                "mailcatcher" -> Mailcatcher
                else -> throw IllegalArgumentException("Unknown SMTP provider: ${System.getenv("SMTP_PROVIDER")}")
            }
        }
    }
}
