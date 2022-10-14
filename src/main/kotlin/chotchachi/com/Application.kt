package chotchachi.com

import chotchachi.com.di.appModule
import chotchachi.com.jobs.JobFactory
import chotchachi.com.jobs.JobSchedulerManager
import chotchachi.com.jobs.RandomQuoteJob
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.module.Module
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.quartz.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false, koinModules: List<Module> = listOf(appModule)) {
    install(Koin) {
        modules(koinModules)
    }

    routing {
        get("/") {
            call.respond("quang handsome")
        }

        get("/test") {
            call.respond("test")
        }
    }

    val jobSchedulerManager by inject<JobSchedulerManager>()
    val jobFactory by inject<JobFactory>()
    jobSchedulerManager.startScheduler()
    jobSchedulerManager.scheduler.setJobFactory(jobFactory)

    watch(jobSchedulerManager)
}

fun watch(jobSchedulerManager: JobSchedulerManager) {
    val jobId = "chuck-watch-job-for-random-quote"
    val triggerId = "chuck-watch-trigger-for-random-quote"

    // If a job exists, delete it!
    val jobScheduler = jobSchedulerManager.scheduler
    val jobKey = JobKey.jobKey(jobId, RandomQuoteJob.WATCH_JOB_GROUP)
    jobScheduler.deleteJob(jobKey)

    val job: JobDetail = JobBuilder.newJob(RandomQuoteJob::class.java)
        .withIdentity(jobId, RandomQuoteJob.WATCH_JOB_GROUP)
        .usingJobData(RandomQuoteJob.JOB_MAP_NAME_ID_KEY, "random-quote")
        .build()

    val trigger: Trigger = TriggerBuilder.newTrigger()
        .withIdentity(triggerId, RandomQuoteJob.WATCH_JOB_GROUP)
        .withSchedule(
            SimpleScheduleBuilder.simpleSchedule()
                // every minute
                .withIntervalInMinutes(1)
                .repeatForever()
        )
        .build()

    // Tell quartz to schedule the job using our trigger
    jobSchedulerManager.scheduler.scheduleJob(job, trigger)
}