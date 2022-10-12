package chotchachi.com.di

import chotchachi.com.jobs.JobFactory
import chotchachi.com.jobs.JobSchedulerManager
import chotchachi.com.repository.QuoteRepository
import org.koin.dsl.module
import org.koin.dsl.single

val appModule = module {
    single<QuoteRepository>()
    single<JobSchedulerManager>()
    single<JobFactory>()
}