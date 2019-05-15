package demo.com.dulval.data.remote.api

import demo.com.dulval.data.remote.model.JobsPayload
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {

    @GET("/android-jobs")
    fun fetchJobs(): Single<JobsPayload>
}