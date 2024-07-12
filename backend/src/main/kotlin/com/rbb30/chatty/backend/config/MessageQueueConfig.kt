package com.rbb30.chatty.backend.config

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    @Bean
    fun queue(): Queue {
        return Queue("messageQueue", true)
    }
}
