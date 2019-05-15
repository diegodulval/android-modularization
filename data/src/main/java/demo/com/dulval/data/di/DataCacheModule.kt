package demo.com.dulval.data.di

import demo.com.dulval.data.local.database.JobsDataBase
import demo.com.dulval.data.local.source.JobsCacheDataSource
import demo.com.dulval.data.local.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val cacheDataModule = module {
    single { JobsDataBase.createDataBase(androidContext()) }
    factory<JobsCacheDataSource> { JobsCacheSourceImpl(jobsDao = get()) }
}