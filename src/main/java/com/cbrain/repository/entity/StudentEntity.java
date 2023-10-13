package com.cbrain.repository.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Table("student")
public class StudentEntity {
    @Id
    @Column("student_id")
    private Integer studentId;

    @Column("student_first_name")
    private String studentFirstName;

    @Column("student_last_name")
    private String studentLastName;

    @Column("student_age")
    private Integer studentAge;

    @Column("create_date")
    private LocalDateTime createDate;

    @Column("active_status")
    private String activeStatus;
}
