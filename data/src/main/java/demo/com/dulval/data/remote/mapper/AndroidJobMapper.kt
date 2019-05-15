package demo.com.dulval.data.remote.mapper

import demo.com.dulval.data.remote.model.AndroidJobPayload
import demo.com.dulval.data.remote.model.JobsPayload
import demo.com.dulval.domain.entities.AndroidJob


object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { map(it) }

    private fun map(payload: AndroidJobPayload) = AndroidJob(
        title = payload.title,
        experienceTimeRequired = payload.requiredExperienceYears,
        native = payload.native,
        country = payload.country
    )
}