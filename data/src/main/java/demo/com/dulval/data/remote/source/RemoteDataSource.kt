package demo.com.dulval.data.remote.source

import demo.com.dulval.domain.entities.AndroidJob
import io.reactivex.Single

interface RemoteDataSource {
    fun getJobs(): Single<List<AndroidJob>>
}