package com.cbrain.service.impl;

import com.cbrain.controller.dto.SubjectDto;
import com.cbrain.service.SubjectService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Override
    public Mono<SubjectDto> getSubject(Integer subjectId) {
        return null;
    }

    @Override
    public Mono<SubjectDto> createSubject(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public Mono<SubjectDto> updateSubject(Integer subjectId, SubjectDto subjectDto) {
        return null;
    }

    @Override
    public Mono<Void> deleteSubject(Integer subjectId) {
        return null;
    }

    @Override
    public Flux<SubjectDto> getAllSubjects() {
        return null;
    }
}
