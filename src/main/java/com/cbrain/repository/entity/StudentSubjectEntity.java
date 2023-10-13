package com.cbrain.repository.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("student_subject")
public class StudentSubjectEntity {

    @Column("student_id")
    private Integer studentId;

    @Column("subject_id")
    private Integer subjectId;
}
