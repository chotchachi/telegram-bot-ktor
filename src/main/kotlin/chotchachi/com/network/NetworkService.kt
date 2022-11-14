package chotchachi.com.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class NetworkService(
    private val client: HttpClient
) {

    suspend fun sendMessage(botToken: String, chatId: String, text: String) {
        client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = NetworkConstants.TELEGRAM_API
                path("bot$botToken/sendMessage")
                parameters.run {
                    append("chat_id", chatId)
                    append("text", text)
                    append("parse_mode", "Markdown")
                }
            }
        }
    }
}