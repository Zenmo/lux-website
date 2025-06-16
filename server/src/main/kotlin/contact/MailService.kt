package com.zenmo.server.contact

import com.zenmo.server.Config
import jakarta.mail.Message
import jakarta.mail.Session
import jakarta.mail.internet.*

class MailService(
    private val mailSession: Session,
    private val messageFactory: () -> MimeMessage,
) {
    fun sendMail(contactRequest: ContactRequest) {
        val message = messageFactory()
        if (contactRequest.emailAddress.isNotEmpty()) {
            message.replyTo = arrayOf(InternetAddress(contactRequest.emailAddress))
        }
        message.setText(contactRequest.toEmailBody())

        val smtpTransport = mailSession.getTransport("smtp")
        smtpTransport.connect()
        smtpTransport.sendMessage(message, message.allRecipients)
        smtpTransport.close()
    }

    companion object {
        fun create(config: Config): MailService {
            val session = config.smtpConfig.createSession()

            val messageFactory = {
                createMessage(config, session)
            }

            return MailService(session, messageFactory)
        }

        fun createMessage(config: Config, session: Session): MimeMessage {
            val message = MimeMessage(session)
            message.setFrom(InternetAddress("website@zenmo.com"))
            message.setRecipients(
                Message.RecipientType.TO,
                config.contactMailRecipients.map {
                    InternetAddress(it)
                }.toTypedArray()
            )
            message.subject = "Contactformulier ingevuld op zenmo.com"
            message.sentDate = java.util.Date()
            return message
        }
    }
}
