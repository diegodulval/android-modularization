package demo.com.dulval.data.di

import demo.com.dulval.data.AndroidJobsRepositoryImpl
import demo.com.dulval.domain.repository.AndroidJobsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<AndroidJobsRepository> {
        AndroidJobsRepositoryImpl(
            jobsCacheDataSource = get(),
            remoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)