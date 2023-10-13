package com.cbrain.service.impl;

import com.cbrain.controller.dto.StudentDto;
import com.cbrain.repository.StudentRepository;
import com.cbrain.repository.StudentSubjectRepository;
import com.cbrain.repository.SubjectRepository;
import com.cbrain.repository.entity.StudentSubjectEntity;
import com.cbrain.service.StudentService;
import com.cbrain.utils.ObjectMapperUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;

    private final StudentSubjectRepository studentSubjectRepository;

    @Override
    public Mono<StudentDto> getStudent(Integer studentId) {

        return studentRepository.findById(studentId)
                .flatMap(student -> {
                    // Find the subject IDs associated with the student
                    return studentSubjectRepository.findAllByStudentId(studentId)
                            .map(StudentSubjectEntity::getSubjectId)
                            .collectList()
                            .flatMap(subjectIds -> {
                                // Find the subjects by their IDs
                                return subjectRepository.findAllById(subjectIds)
                                        .collectList()
                                        .map(subjects -> ObjectMapperUtility.mapToStudentDto(student, subjects));
                            });
                });
    }

    @Override
    public Mono<StudentDto> createStudent(StudentDto studentDto) {

        return studentRepository.save(ObjectMapperUtility.mapToStudentEntity(studentDto))
                .flatMap(savedStudent -> {
                    // Save the related subjects separately
                    Flux<StudentSubjectEntity> savedStudentSubjects = Flux.fromIterable(studentDto.studentSubjects())
                            .flatMap(subject -> {
                                return studentSubjectRepository.save(StudentSubjectEntity.builder()
                                        .studentId(savedStudent.getStudentId())
                                        .subjectId(subject.subjectId())
                                        .build());
                            });

                    return savedStudentSubjects
                            .map(StudentSubjectEntity::getSubjectId)
                            .collectList()
                            .flatMap(subjectIds -> {
                                // Find the subjects by their IDs
                                return subjectRepository.findAllById(subjectIds)
                                        .collectList()
                                        .map(subjects -> ObjectMapperUtility.mapToStudentDto(savedStudent, subjects));
                            });
                });

    }

    @Override
    public Mono<StudentDto> updateStudent(Integer studentId, StudentDto studentDto) {
        return Mono.just(studentDto);
    }

    @Override
    public Mono<Void> deleteStudent(Integer studentId) {
        return Mono.empty();
    }

    @Override
    public Flux<StudentDto> getAllStudents() {
        return null;
    }
}
