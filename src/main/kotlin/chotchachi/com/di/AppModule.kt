package chotchachi.com.di

import chotchachi.com.jobs.JobFactory
import chotchachi.com.jobs.JobSchedulerManager
import chotchachi.com.network.NetworkService
import chotchachi.com.repository.QuoteRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::QuoteRepository)
    singleOf(::JobSchedulerManager)
    singleOf(::JobFactory)
    singleOf(::provideKtorClient)
    singleOf(::NetworkService)
}

private fun provideKtorClient() = HttpClient(CIO)