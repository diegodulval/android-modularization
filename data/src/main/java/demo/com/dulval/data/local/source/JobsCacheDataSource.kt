package demo.com.dulval.data.local.source

import demo.com.dulval.domain.entities.AndroidJob
import io.reactivex.Single

interface JobsCacheDataSource {
    fun getJobs(): Single<List<AndroidJob>>

    fun insertData(list: List<AndroidJob>)
    fun updateData(list: List<AndroidJob>)
}