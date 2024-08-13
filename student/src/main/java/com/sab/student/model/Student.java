package com.sab.student.model;

import com.sab.student.request.StudentAddRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"institutionType", "institution", "standard", "section", "examSession", "classRollNo"})
})
public class Student {

    @Id
    private String id;
    private String studentName;
    private String classRollNo;
    private String fatherName;
    private String motherName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private InstitutionType institutionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Institution institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Standard standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Section section;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private ExamSession examSession;

    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private ComplainantRelationship complainantRelationship;

    private String guardianOtherRelationName;
    private String guardianName;
    private String guardianContact;
    private String guardianEmail;
    private String emergencyContact;

    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    public Student(StudentAddRequest studentAddRequest) {
        this.studentName = studentAddRequest.getStudentName();
        this.classRollNo = studentAddRequest.getClassRollNo();
        this.fatherName = studentAddRequest.getFatherName();
        this.motherName = studentAddRequest.getMotherName();
        this.institutionType = studentAddRequest.getInstitutionType();
        this.institution = studentAddRequest.getInstitution();
        this.standard = studentAddRequest.getStandard();
        this.section = studentAddRequest.getSection();
        this.examSession = studentAddRequest.getExamSession();
        this.dateOfBirth = studentAddRequest.getDateOfBirth();
        this.complainantRelationship = studentAddRequest.getComplainantRelationship();
        this.guardianOtherRelationName = studentAddRequest.getGuardianOtherRelationName();
        this.guardianName = studentAddRequest.getGuardianName();
        this.guardianContact = studentAddRequest.getGuardianContact();
        this.guardianEmail = studentAddRequest.getGuardianEmail();
        this.emergencyContact = studentAddRequest.getEmergencyContact();
        this.createdAt=  new Date();
    }

    public Student() {

    }

    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }

}
