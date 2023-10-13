package com.cbrain.controller;

import com.cbrain.controller.dto.StudentDto;
import com.cbrain.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    Mono<StudentDto> getStudent(@PathVariable("studentId") Integer studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    Mono<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @PutMapping("/{studentId}")
    Mono<StudentDto> updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentId, studentDto);
    }

    @DeleteMapping("/{studentId}")
    Mono<Void> deleteStudent(@PathVariable("studentId") Integer studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/all")
    Flux<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }
}
