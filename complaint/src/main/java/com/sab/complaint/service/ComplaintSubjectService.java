package com.sab.complaint.service;

import com.sab.complaint.request.ComplaintSubjectRequest;
import com.sab.complaint.model.ComplaintSubject;
import com.sab.complaint.repository.ComplaintSubjectRepository;
import com.sab.sabglobal.model.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplaintSubjectService {

    @Autowired
    ComplaintSubjectRepository complaintSubjectRepository;
    public ComplaintSubject getComplaintSubjectById(String id) {
       return complaintSubjectRepository.findById(id).orElse(null);

    }

    @Transactional
    public CommonResponse addComplaintSubject(ComplaintSubjectRequest complaintSubjectRequest) {
        complaintSubjectRepository.save(new ComplaintSubject().convertToEntity(complaintSubjectRequest));
        return new CommonResponse("0000000", "Complaint Subject Saved");
    }
}
