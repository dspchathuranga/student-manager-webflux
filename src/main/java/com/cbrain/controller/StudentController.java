package com.cbrain.controller;

import com.cbrain.controller.dto.StudentDto;
import com.cbrain.controller.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/{studentId}")
    Mono<StudentDto> getStudent(@PathVariable("studentId") Integer studentId) {
        List<SubjectDto> subjectDtos = new ArrayList<>();
        subjectDtos.add(new SubjectDto(1,"Mathematics"));
        return Mono.just(new StudentDto(studentId,"DSP",
                "Chathuranga",33, subjectDtos));
    }

    @PostMapping
    Mono<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return Mono.just(studentDto);
    }

    @PutMapping("/{studentId}")
    Mono<StudentDto> updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody StudentDto studentDto) {
        return Mono.just(studentDto);
    }

    @DeleteMapping("/{studentId}")
    Mono<Void> deleteStudent(@PathVariable("studentId") Integer studentId) {
        return Mono.empty();
    }

//    @GetMapping("/all")
//    Flux<StudentDTO> getAllStudents() {
//        return carService.getAllCars();
//    }
}
