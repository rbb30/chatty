package com.rbb30.chatty.backend

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class LoginController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, World!"
    }

    @GetMapping("/hello/{name}")
    fun helloWithName(@PathVariable name: String): String {
        return "Hello, $name!"
    }

    @PostMapping("/hello")
    fun helloPost(@RequestBody message: String): String {
        return "Received message: $message"
    }
}
