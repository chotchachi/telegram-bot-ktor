package chotchachi.com.jobs

import chotchachi.com.repository.QuoteRepository
import org.quartz.Job
import org.quartz.JobExecutionContext

class RandomQuoteJob(
    quoteRepository: QuoteRepository
) : Job {
    override fun execute(context: JobExecutionContext?) {

    }

    companion object {
        const val JOB_MAP_NAME_ID_KEY = "name"
        const val WATCH_JOB_GROUP = "WatchJob"
    }
}