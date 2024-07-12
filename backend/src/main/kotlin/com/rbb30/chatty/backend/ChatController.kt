package com.rbb30.chatty.backend

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.util.HtmlUtils
import org.springframework.stereotype.Controller;

//@Controller
//class ChatController {
//    @MessageMapping("/message")
//    @SendTo("/topic/messages")
//    fun send(message: ChatMessage): ChatMessage {
//        return ChatMessage(HtmlUtils.htmlEscape(message.getContent()), message.getTimestamp())
//    }
//}