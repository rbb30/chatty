package com.rbb30.chatty.backend


class ChatMessage {
    private var content: String? = null
    private var timestamp: String? = null

    constructor()

    constructor(content: String?, timestamp: String?) {
        this.content = content
        this.timestamp = timestamp
    } // getters and setters

    fun getContent(): String {
        return content!!
    }

    fun setContent(content: String?) {
        this.content = content
    }

    fun getTimestamp(): String {
        return timestamp!!
    }

    fun setTimestamp(timestamp: String?) {
        this.timestamp = timestamp
    }

}