package com.cbrain.repository;

import com.cbrain.repository.entity.StudentEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface StudentRepository extends R2dbcRepository<StudentEntity, Integer> {
}
