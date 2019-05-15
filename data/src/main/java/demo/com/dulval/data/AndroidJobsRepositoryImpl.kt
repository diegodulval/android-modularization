package demo.com.dulval.data

import demo.com.dulval.data.local.source.JobsCacheDataSource
import demo.com.dulval.data.remote.source.RemoteDataSource
import demo.com.dulval.domain.entities.AndroidJob
import demo.com.dulval.domain.repository.AndroidJobsRepository
import io.reactivex.Single

class AndroidJobsRepositoryImpl(
    private val jobsCacheDataSource: JobsCacheDataSource,
    private val remoteDataSource: RemoteDataSource
): AndroidJobsRepository {

    override fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>> {
        return if (forceUpdate)
            getJobsRemote(forceUpdate)
        else
            jobsCacheDataSource.getJobs()
                .flatMap { listJobs ->
                    when{
                        listJobs.isEmpty() -> getJobsRemote(false)
                        else -> Single.just(listJobs)
                    }
                }
    }

    private fun getJobsRemote(isUpdate: Boolean): Single<List<AndroidJob>> {
        return remoteDataSource.getJobs()
            .flatMap { listJobs ->
                if (isUpdate)
                    jobsCacheDataSource.updateData(listJobs)
                else
                    jobsCacheDataSource.insertData(listJobs)
                Single.just(listJobs)
            }
    }
}