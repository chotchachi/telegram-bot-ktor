package chotchachi.com.jobs

import chotchachi.com.repository.QuoteRepository
import org.quartz.Job
import org.quartz.JobExecutionContext

class RandomQuoteJob(
    quoteRepository: QuoteRepository
) : Job {
    override fun execute(context: JobExecutionContext?) {

    }
}