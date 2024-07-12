package com.rbb30.chatty.backend

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class MessageListener(private val messagingTemplate: SimpMessagingTemplate) {

    @RabbitListener(queues = ["messageQueue"])
    fun receiveMessage(message: String) {
        println("Received <$message>")

        messagingTemplate.convertAndSend("/topic/messages", message)

        //val sessionId = "your-session-id"
        //messagingTemplate.convertAndSendToUser(sessionId, "/topic/messages", message)
    }
}