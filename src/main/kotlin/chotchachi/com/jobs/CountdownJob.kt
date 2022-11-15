package chotchachi.com.jobs

import chotchachi.com.network.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.quartz.Job
import org.quartz.JobExecutionContext

class CountdownJob : Job, KoinComponent {

    private val service by inject<NetworkService>()

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun execute(context: JobExecutionContext?) {
        val now = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+7")).date

        val noelDaysDiff = now.daysUntil(NOEL)
        val newYearDaysDiff = now.daysUntil(NEW_YEAR)
        val tetDaysDiff = now.daysUntil(TET_HOLIDAY)

        val chatIds = listOf(
            "-839298164",
            "-1001623104529"
        )

        coroutineScope.launch {
            chatIds.forEach { chatId ->
                service.sendMessage(
                    botToken = "5606196893:AAGGNhIbdoBzGTnQKD_FtHnwiAwDOP2EnmM",
                    chatId = chatId,
                    text = """
*Countdown*
-------------------
Còn $noelDaysDiff ngày nữa là Noel.
Còn $newYearDaysDiff ngày nữa là Tết Dương.
Còn $tetDaysDiff ngày nữa là Tết Âm.
                """.trimIndent()
                )
            }
        }
    }

    companion object {
        private val NOEL = LocalDate(2022, 12, 25)
        private val NEW_YEAR = LocalDate(2023, 1, 1)
        private val TET_HOLIDAY = LocalDate(2023, 1, 22)
    }
}