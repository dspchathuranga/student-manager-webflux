package com.cbrain.repository;

import com.cbrain.repository.entity.SubjectEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface SubjectRepository extends R2dbcRepository<SubjectEntity, Integer> {
}
