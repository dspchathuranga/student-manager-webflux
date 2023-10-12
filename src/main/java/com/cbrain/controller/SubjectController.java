package com.cbrain.controller;

import com.cbrain.controller.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @GetMapping("/{subjectId}")
    Mono<SubjectDto> getSubject(@PathVariable("subjectId") Integer subjectId) {
        return Mono.just(new SubjectDto(subjectId,"Mathematics"));
    }

    @PostMapping
    Mono<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        return Mono.just(subjectDto);
    }

    @PutMapping("/{subjectId}")
    Mono<SubjectDto> updateSubject(@PathVariable("subjectId") Integer subjectId, @RequestBody SubjectDto subjectDto) {
        return Mono.just(subjectDto);
    }

    @DeleteMapping("/{subjectId}")
    Mono<Void> deleteSubject(@PathVariable("subjectId") Integer subjectId) {
        return Mono.empty();
    }
}
