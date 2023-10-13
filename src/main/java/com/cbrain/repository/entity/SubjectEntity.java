package com.cbrain.repository.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@Table("subject")
public class SubjectEntity {

    @Id
    @Column("subject_id")
    private Integer subjectId;

    @Column("subject_name")
    private String subjectName;

    @Column("create_date")
    private LocalDateTime createDate;

    @Column("active_status")
    private String activeStatus;

}
