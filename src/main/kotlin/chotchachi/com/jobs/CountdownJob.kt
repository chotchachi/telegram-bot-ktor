package chotchachi.com.jobs

import chotchachi.com.network.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.quartz.Job
import org.quartz.JobExecutionContext

class CountdownJob : Job, KoinComponent {

    private val service by inject<NetworkService>()

    override fun execute(context: JobExecutionContext?) {
        val now = Clock.System.now()
        val timeZone = TimeZone.of("UTC+7")

        val noelDaysDiff = now.daysUntil(NOEL, timeZone)
        val newYearDatsDiff = now.daysUntil(NEW_YEAR, timeZone)
        val tetDaysDiff = now.daysUntil(TET_HOLIDAY, timeZone)

        CoroutineScope(Dispatchers.IO).launch {
            service.sendMessage(
                botToken = "5606196893:AAGGNhIbdoBzGTnQKD_FtHnwiAwDOP2EnmM",
                chatId = "-839298164",
                text = """
*Countdown*
-------------------
Còn $noelDaysDiff ngày nữa là Noel.
Còn $newYearDatsDiff ngày nữa là Tết Dương.
Còn $tetDaysDiff ngày nữa là Tết Âm.
                """.trimIndent()
            )
        }
    }

    companion object {
        private val NOEL = Instant.parse("2022-12-25T00:00:00Z")
        private val NEW_YEAR = Instant.parse("2023-01-01T00:00:00Z")
        private val TET_HOLIDAY = Instant.parse("2023-01-22T00:00:00Z")
    }
}