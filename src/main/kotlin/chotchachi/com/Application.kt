package chotchachi.com

import chotchachi.com.di.appModule
import chotchachi.com.jobs.JobFactory
import chotchachi.com.jobs.JobSchedulerManager
import io.ktor.server.application.*
import org.koin.core.module.Module
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false, koinModules: List<Module> = listOf(appModule)) {
    install(Koin) {
        modules(koinModules)
    }

    val jobSchedulerManager by inject<JobSchedulerManager>()
    val jobFactory by inject<JobFactory>()
    jobSchedulerManager.startScheduler()
    jobSchedulerManager.scheduler.setJobFactory(jobFactory)
}