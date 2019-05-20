package demo.com.dulval.domain.usecases

import demo.com.dulval.domain.entities.AndroidJob
import demo.com.dulval.domain.repository.AndroidJobsRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

class GetJobsUseCases(
    private val repository: AndroidJobsRepository,
    private val scheduler: Scheduler
) {

    fun execute(forceUpdate: Boolean): Single<List<AndroidJob>> {
        return repository.getJobs(forceUpdate)
            .subscribeOn(scheduler)
    }
}