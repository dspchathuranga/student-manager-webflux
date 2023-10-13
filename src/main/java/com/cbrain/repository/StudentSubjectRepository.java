package com.cbrain.repository;

import com.cbrain.repository.entity.StudentSubjectEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface StudentSubjectRepository extends R2dbcRepository<StudentSubjectEntity, Integer> {
    Flux<StudentSubjectEntity> findAllByStudentId(Integer studentId);
}
