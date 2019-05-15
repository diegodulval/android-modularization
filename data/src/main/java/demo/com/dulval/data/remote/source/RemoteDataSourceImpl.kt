package demo.com.dulval.data.remote.source

import demo.com.dulval.data.remote.api.ServerApi
import demo.com.dulval.data.remote.mapper.AndroidJobMapper
import demo.com.dulval.domain.entities.AndroidJob
import io.reactivex.Single

class RemoteDataSourceImpl(private val serverApi: ServerApi) :
    RemoteDataSource {
    override fun getJobs(): Single<List<AndroidJob>> {
        return serverApi.fetchJobs()
            .map { AndroidJobMapper.map(it) }
    }

}