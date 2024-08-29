package com.sab.complaint.service;

import com.sab.complaint.dto.*;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.SABSQLException;
import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.payload.response.Response;
import com.sab.sabglobal.response.ApiBooleanResponse;
import com.sab.sabglobal.util.GlobalConstant;
import com.sab.complaint.feignClient.StudentHubClient;
import com.sab.complaint.model.ComplainantRelationship;
import com.sab.complaint.model.Complaint;
import com.sab.complaint.repository.ComplainantRelationshipRepository;
import com.sab.complaint.repository.ComplaintRepository;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.student.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplainantRelationshipRepository complainantRelationshipRepository;

    @Autowired
    StudentHubClient studentHubClient;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public CommonResponse createComplaint(Complaint complaint) {

        CommonResponse commonResponse = new CommonResponse();
        try {
            if (validateComplaintDetails(complaint, commonResponse)) {
                complaintRepository.save(complaint);
                commonResponse.setResponseCode("0000000");
                commonResponse.setResponseMessage("Complaint Saved Successfully!");
            }
            return commonResponse;
        } catch (Exception e) {
            commonResponse.setResponseCode("9999999");
            commonResponse.setResponseMessage("An error occurred: " + e.getMessage());
        }
        return commonResponse;
    }

    public boolean validateComplaintDetails(Complaint complaint, CommonResponse commonResponse) throws GlobalException {
        boolean result = false;
        try {
            ResponseEntity<Municipality> municipalityResponse = studentHubClient.getMunicipalityById(complaint.getMunicipalityId());
            if (!municipalityResponse.getStatusCode().is2xxSuccessful() || municipalityResponse.getBody() == null || municipalityResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Municipality Id!");
                result = false;
            }

            ResponseEntity<InstitutionType> institutionTypeResponse = studentHubClient.getInstitutionTypeById(complaint.getInstitutionTypeId());
            if (!institutionTypeResponse.getStatusCode().is2xxSuccessful() || institutionTypeResponse.getBody() == null || institutionTypeResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Institution Type Id!");
                result = false;
            }

            ResponseEntity<Institution> institutionResponse = studentHubClient.getInstitutionById(complaint.getInstitutionId());
            if (!institutionResponse.getStatusCode().is2xxSuccessful() || institutionResponse.getBody() == null || institutionResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Institution Id!");
                result = false;
            }


            ResponseEntity<Standard> standardResponse = studentHubClient.getStandardById(complaint.getStandardId());
            if (!standardResponse.getStatusCode().is2xxSuccessful() || standardResponse.getBody() == null || standardResponse.getBody().getStandardName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Standard Id!");
                result = false;
            }

            ResponseEntity<Section> sectionResponse = studentHubClient.getSectionById(complaint.getSectionId());
            if (!sectionResponse.getStatusCode().is2xxSuccessful() || sectionResponse.getBody() == null || sectionResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Section Id!");
                result = false;
            }

            complainantRelationshipRepository.findById(complaint.getComplainantRelationship().getId())
                    .orElseThrow(() -> new SABSQLException(Collections.singletonList(new CustomError(GlobalConstant.NOT_FOUND_ERROR_CODE,
                            "Invalid Complainant Relationship!",
                            GlobalConstant.NOT_FOUND_ERROR_TYPE))));

            ResponseEntity<StudentDTO> studentResponse = studentHubClient.getStudentById(complaint.getStudentId());
            if (!studentResponse.getStatusCode().is2xxSuccessful() || studentResponse.getBody() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Student Id!");
                return false;
            }

            StudentDTO studentDTO = studentResponse.getBody();
            System.out.println("After setting the StudentDTO: " + studentDTO);

            List<StudentDTO> studentList = studentHubClient.checkStudentExistence(studentDTO);

            if (studentList.isEmpty()) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Student Details!");
            } else if (studentList.size() > 1) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Multiple Students Found for the Student Details!");
            } else {
                result = true;
            }
        } catch (Exception e) {
            logger.error("Error Track is:::-------" + e.getMessage(), e);
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE,
                    GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE,
                    GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return result;
    }
}
