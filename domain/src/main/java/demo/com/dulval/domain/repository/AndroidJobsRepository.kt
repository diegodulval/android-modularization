package demo.com.dulval.domain.repository

import demo.com.dulval.domain.entities.AndroidJob
import io.reactivex.Observable
import io.reactivex.Single

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>>
}