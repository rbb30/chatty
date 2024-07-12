package com.rbb30.chatty.backend.websocket

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class WebSocketController @Autowired constructor(
    private val rabbitTemplate: RabbitTemplate
) {

    @MessageMapping("/sendMessage")
    fun sendMessage(message: String) {
        println("here $message")
        rabbitTemplate.convertAndSend("messageQueue", message)
    }
}
