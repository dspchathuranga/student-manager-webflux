package com.cbrain.utils;

import com.cbrain.controller.dto.StudentDto;
import com.cbrain.controller.dto.SubjectDto;
import com.cbrain.repository.entity.StudentEntity;
import com.cbrain.repository.entity.SubjectEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapperUtility {
    public static StudentDto mapToStudentDto(StudentEntity studentEntity, List<SubjectEntity> subjectEntities) {
        StudentDto studentDto = new StudentDto(
                studentEntity.getStudentId(),
                studentEntity.getStudentFirstName(),
                studentEntity.getStudentLastName(),
                studentEntity.getStudentAge(),
                studentEntity.getActiveStatus(),
                subjectEntities.stream().map(subject -> mapToSubjectDto(subject)).toList()
        );
        return studentDto;
    }

    public static StudentDto mapToStudentDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto(
                studentEntity.getStudentId(),
                studentEntity.getStudentFirstName(),
                studentEntity.getStudentLastName(),
                studentEntity.getStudentAge(),
                studentEntity.getActiveStatus(),
                new ArrayList<>()
        );
        return studentDto;
    }

    public static SubjectDto mapToSubjectDto(SubjectEntity subjectEntities) {
        return new SubjectDto(
                subjectEntities.getSubjectId(),
                subjectEntities.getSubjectName(),
                subjectEntities.getActiveStatus()
        );
    }

    public static SubjectEntity mapToSubjectEntity(SubjectDto subjectDto) {
        return SubjectEntity.builder().subjectId(subjectDto.subjectId())
                .subjectName(subjectDto.subjectName())
                .activeStatus(subjectDto.activeStatus())
                .createDate(LocalDateTime.now())
                .build();
    }

    public static StudentEntity mapToStudentEntity(StudentDto studentDto) {
        return StudentEntity.builder()
                //.studentId(studentDto.studentId())
                .studentFirstName(studentDto.studentFirstName())
                .studentLastName(studentDto.studentLastName())
                .studentAge(studentDto.studentAge())
                .activeStatus(studentDto.activeStatus())
                .createDate(LocalDateTime.now())
                //.studentSubjects(studentDto.studentSubjects().stream().map(subjectDto -> mapToSubjectEntity(subjectDto)).toList())
                .build();
    }
}
