package com.sab.student.dto;


import com.sab.student.model.Student;
import lombok.Data;

@Data
public class StudentDTO {
    private String id;
    private String studentName;
    private String classRollNo;
    private String institutionTypeId;
    private String institutionId;
    private String standardId;
    private String sectionId;
    private String examSessionId;
}
