package com.cbrain.controller;

import com.cbrain.controller.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/{studentId}")
    Mono<StudentDTO> getStudent(@PathVariable("studentId") Integer studentId) {
        return Mono.just(new StudentDTO(studentId,"DSP","Chathuranga",33));
    }

    @PostMapping
    Mono<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return Mono.just(studentDTO);
    }

    @PutMapping("/{studentId}")
    Mono<StudentDTO> updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody StudentDTO studentDTO) {
        return Mono.just(studentDTO);
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
