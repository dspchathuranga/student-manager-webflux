package com.cbrain.service;

import com.cbrain.controller.dto.StudentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Mono<StudentDto> getStudent(Integer studentId);
    Mono<StudentDto> createStudent(StudentDto studentDto);
    Mono<StudentDto> updateStudent(Integer studentId, StudentDto studentDto);
    Mono<Void> deleteStudent(Integer studentId);
    Flux<StudentDto> getAllStudents();
}
