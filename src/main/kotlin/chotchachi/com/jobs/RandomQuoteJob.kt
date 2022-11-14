package chotchachi.com.jobs

import chotchachi.com.network.NetworkConstants
import chotchachi.com.repository.QuoteRepository
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.quartz.Job
import org.quartz.JobExecutionContext

class RandomQuoteJob(
    private val quoteRepository: QuoteRepository
) : Job, KoinComponent {

    private val client by inject<HttpClient>()

    override fun execute(context: JobExecutionContext?) {
        val quote = quoteRepository.getRandomQuote()

        CoroutineScope(Dispatchers.IO).launch {
            sendMessage(
                botToken = "5777957378:AAECBA3cgjIfJ9Z5KFudoUcBffROfn9-MjY",
                chatId = "-841908420",
                text = "hehe"
            )
        }
    }

    private suspend fun sendMessage(botToken: String, chatId: String, text: String) {
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

    companion object {
        const val JOB_MAP_NAME_ID_KEY = "name"
        const val WATCH_JOB_GROUP = "WatchJob"
    }
}