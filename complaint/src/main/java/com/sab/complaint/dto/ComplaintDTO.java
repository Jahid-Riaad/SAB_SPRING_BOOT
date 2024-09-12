package com.sab.complaint.dto;

import lombok.Data;

@Data
public class ComplaintDTO {
        private String recipientId;
        private String complaintSubjectId;
        private String municipalityId;
        private String institutionTypeId;
        private String institutionId;
        private String studentId;
        private String standardId;
        private String sectionId;
        private String complainantRelationshipId;
        private String complainantRelationshipOtherName;
        private String complainantName;
        private String complainantMobileNo;
        private String complainantEmail;
        private String complaintDetails;
}
