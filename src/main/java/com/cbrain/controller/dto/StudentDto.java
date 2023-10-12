package com.cbrain.controller.dto;

import java.util.List;

public record StudentDto(Integer student_id, String student_first_name,
                         String student_last_name, Integer student_age,
                        List<SubjectDto> subjectDtos) {
}
