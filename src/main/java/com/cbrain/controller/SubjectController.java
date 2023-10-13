package com.cbrain.controller;

import com.cbrain.controller.dto.SubjectDto;
import com.cbrain.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/{subjectId}")
    Mono<SubjectDto> getSubject(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.getSubject(subjectId);
    }

    @PostMapping
    Mono<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    @PutMapping("/{subjectId}")
    Mono<SubjectDto> updateSubject(@PathVariable("subjectId") Integer subjectId, @RequestBody SubjectDto subjectDto) {
        return subjectService.updateSubject(subjectId, subjectDto);
    }

    @DeleteMapping("/{subjectId}")
    Mono<Void> deleteSubject(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.deleteSubject(subjectId);
    }

    @GetMapping("/all")
    Flux<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
