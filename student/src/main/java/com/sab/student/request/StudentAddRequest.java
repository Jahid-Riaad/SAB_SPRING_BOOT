package com.sab.student.request;

import com.sab.student.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class StudentAddRequest {
    private String studentName;
    private String classRollNo;
    private String fatherName;
    private String motherName;
    private InstitutionType institutionType;
    private Institution institution;
    private Standard standard;
    private Section section;
    private ExamSession examSession;
    private Date dateOfBirth;
    private ComplainantRelationship complainantRelationship;
    private String guardianOtherRelationName;
    private String guardianName;
    private String guardianContact;
    private String guardianEmail;
    private String emergencyContact;
}
