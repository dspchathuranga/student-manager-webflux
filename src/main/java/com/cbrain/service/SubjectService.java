package com.cbrain.service;

import com.cbrain.controller.dto.SubjectDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubjectService {
    Mono<SubjectDto> getSubject(Integer subjectId);
    Mono<SubjectDto> createSubject(SubjectDto subjectDto);
    Mono<SubjectDto> updateSubject(Integer subjectId, SubjectDto subjectDto);
    Mono<Void> deleteSubject(Integer subjectId);
    Flux<SubjectDto> getAllSubjects();
}
