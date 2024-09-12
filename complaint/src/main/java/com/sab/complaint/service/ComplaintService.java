package com.sab.complaint.service;

import com.sab.complaint.dto.*;
import com.sab.complaint.model.*;
import com.sab.complaint.model.ComplainantRelationship;
import com.sab.complaint.repository.*;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.SABSQLException;
import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.util.GlobalConstant;
import com.sab.complaint.feignClient.StudentHubClient;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.student.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplainantRelationshipRepository complainantRelationshipRepository;

    @Autowired
    RecipientRepository recipientRepository;

    @Autowired
    ComplaintSubjectRepository complaintSubjectRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    StudentHubClient studentHubClient;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${attachment.upload.dir}")
    String attachmentUploadDir;

    @Transactional
    public CommonResponse createComplaintWithAttachments(ComplaintDTO complaintDTO
            , List<MultipartFile> files) throws IOException {

        CommonResponse commonResponse = new CommonResponse();
        List<Attachment> attachments = new ArrayList<>();

        try {
            Recipient recipient = recipientRepository.findById(complaintDTO.getRecipientId()).
                    orElseThrow(() -> new SABSQLException(Collections.singletonList(new CustomError(GlobalConstant.NOT_FOUND_ERROR_CODE,
                            "Invalid Recipient Id!",
                            GlobalConstant.NOT_FOUND_ERROR_TYPE))));

            ComplaintSubject complaintSubject = complaintSubjectRepository.findById(complaintDTO.getComplaintSubjectId()).
                    orElseThrow(() -> new SABSQLException(Collections.singletonList(new CustomError(GlobalConstant.NOT_FOUND_ERROR_CODE,
                            "Invalid Complaint Subject Id!",
                            GlobalConstant.NOT_FOUND_ERROR_TYPE))));


            ComplainantRelationship complainantRelationship = complainantRelationshipRepository.findById(complaintDTO.getComplainantRelationshipId())
                    .orElseThrow(() -> new SABSQLException(Collections.singletonList(new CustomError(GlobalConstant.NOT_FOUND_ERROR_CODE,
                            "Invalid Complainant Relationship Id!",
                            GlobalConstant.NOT_FOUND_ERROR_TYPE))));

            if (validateComplaintDetails(complaintDTO, commonResponse)) {
                Complaint complaint = convertToEntity(complaintDTO, recipient, complaintSubject, complainantRelationship);
                for (MultipartFile file : files) {
                    String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                    Path filePath = Paths.get(attachmentUploadDir + uniqueFileName);
                   // Save the file
                    Files.write(filePath, file.getBytes());
                    // Save the attachment metadata in the database
                    Attachment attachment = new Attachment();
                    attachment.setFileName(file.getOriginalFilename());
                    attachment.setFileType(file.getContentType());
                    attachment.setFileSize(file.getSize());
                    attachment.setFilePath(filePath.toString());
                    attachment.setComplaint(complaint);

                    attachments.add(attachment);
                }

                complaint.setAttachments(attachments);
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

    public boolean validateComplaintDetails(ComplaintDTO complaintDTO, CommonResponse commonResponse) throws GlobalException {
        boolean result = false;
        try {

            ResponseEntity<Municipality> municipalityResponse = studentHubClient.getMunicipalityById(complaintDTO.getMunicipalityId());
            if (!municipalityResponse.getStatusCode().is2xxSuccessful() || municipalityResponse.getBody() == null || municipalityResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Municipality Id!");
                result = false;
            }

            ResponseEntity<InstitutionType> institutionTypeResponse = studentHubClient.getInstitutionTypeById(complaintDTO.getInstitutionTypeId());
            if (!institutionTypeResponse.getStatusCode().is2xxSuccessful() || institutionTypeResponse.getBody() == null || institutionTypeResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Institution Type Id!");
                result = false;
            }

            ResponseEntity<Institution> institutionResponse = studentHubClient.getInstitutionById(complaintDTO.getInstitutionId());
            if (!institutionResponse.getStatusCode().is2xxSuccessful() || institutionResponse.getBody() == null || institutionResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Institution Id!");
                result = false;
            }

            ResponseEntity<Standard> standardResponse = studentHubClient.getStandardById(complaintDTO.getStandardId());
            if (!standardResponse.getStatusCode().is2xxSuccessful() || standardResponse.getBody() == null || standardResponse.getBody().getStandardName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Standard Id!");
                result = false;
            }

            ResponseEntity<Section> sectionResponse = studentHubClient.getSectionById(complaintDTO.getSectionId());
            if (!sectionResponse.getStatusCode().is2xxSuccessful() || sectionResponse.getBody() == null || sectionResponse.getBody().getName() == null) {
                commonResponse.setResponseCode("0000001");
                commonResponse.setResponseMessage("Invalid Section Id!");
                result = false;
            }

            ResponseEntity<StudentDTO> studentResponse = studentHubClient.getStudentById(complaintDTO.getStudentId());
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

    public Complaint convertToEntity(ComplaintDTO complaintDTO, Recipient recipient, ComplaintSubject complaintSubject, ComplainantRelationship complainantRelationship) {
        Complaint complaint = new Complaint();
        complaint.setRecipient(recipient);
        complaint.setComplaintSubject(complaintSubject);
        complaint.setMunicipalityId(complaintDTO.getMunicipalityId());
        complaint.setInstitutionTypeId(complaintDTO.getInstitutionTypeId());
        complaint.setInstitutionId(complaintDTO.getInstitutionId());
        complaint.setStudentId(complaintDTO.getStudentId());
        complaint.setStandardId(complaintDTO.getStandardId());
        complaint.setSectionId(complaintDTO.getSectionId());
        complaint.setComplainantRelationship(complainantRelationship);
        complaint.setComplainantRelationshipOtherName(complaintDTO.getComplainantRelationshipOtherName());
        complaint.setComplainantName(complaintDTO.getComplainantName());
        complaint.setComplainantMobileNo(complaintDTO.getComplainantMobileNo());
        complaint.setComplainantEmail(complaintDTO.getComplainantEmail());
        complaint.setComplaintDetails(complaintDTO.getComplaintDetails());

        return complaint;
    }

    public Resource downloadAttachment(String attachmentId) throws SABSQLException {
        Attachment attachment = attachmentRepository.findById(attachmentId)
                .orElseThrow(() -> new SABSQLException(Collections.singletonList(new CustomError(GlobalConstant.NOT_FOUND_ERROR_CODE,
                        "Attachment not found!",
                        GlobalConstant.NOT_FOUND_ERROR_TYPE))));

        Path filePath = Paths.get(attachment.getFilePath());

        return new FileSystemResource(filePath);
    }

}
