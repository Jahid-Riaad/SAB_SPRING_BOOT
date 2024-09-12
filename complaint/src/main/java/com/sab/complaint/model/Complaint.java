package com.sab.complaint.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Complaint {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Recipient recipient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private ComplaintSubject complaintSubject;

    private String municipalityId;
    private String institutionTypeId;
    private String institutionId;
    private String studentId;
    private String standardId;
    private String sectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private ComplainantRelationship complainantRelationship;
    private String complainantRelationshipOtherName;
    private String complainantName;
    private String complainantMobileNo;
    private String complainantEmail;
    private String complaintDetails;
    @OneToMany(mappedBy = "complaint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachments;
    @PrePersist
    public void prePersist(){
        if (this.id == null){
            this.id = UUID.randomUUID().toString();
        }
    }

}
