package com.taidang.themoviedb.repository.mapper

import com.taidang.themoviedb.domain.model.Crew
import com.taidang.themoviedb.repository.response.CrewEntity

/**
 * Created by thuyhien on 5/11/18.
 */
class CrewMapper: IMapper<CrewEntity, Crew> {
    override fun transform(entity: CrewEntity): Crew = Crew(
            entity.id,
            entity.name,
            entity.department,
            entity.job,
            entity.profile_path,
            entity.gender
    )
}