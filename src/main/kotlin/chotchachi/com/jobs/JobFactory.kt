package chotchachi.com.jobs

import chotchachi.com.repository.QuoteRepository
import org.quartz.Job
import org.quartz.Scheduler
import org.quartz.spi.TriggerFiredBundle
import org.quartz.spi.JobFactory
import kotlin.reflect.jvm.jvmName

class JobFactory(
    private val quoteRepository: QuoteRepository
): JobFactory {

    override fun newJob(bundle: TriggerFiredBundle?, scheduler: Scheduler?): Job {
        if (bundle != null) {
            val jobClass = bundle.jobDetail.jobClass
            if (jobClass.name == RandomQuoteJob::class.jvmName) {
                return RandomQuoteJob(quoteRepository)
            }
        }
        throw NotImplementedError("Job Factory error")
    }
}