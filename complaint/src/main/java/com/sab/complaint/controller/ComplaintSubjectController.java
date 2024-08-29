package com.sab.complaint.controller;

import com.sab.complaint.request.ComplaintSubjectRequest;
import com.sab.complaint.model.ComplaintSubject;
import com.sab.complaint.service.ComplaintSubjectService;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class ComplaintSubjectController {
    @Autowired
    ComplaintSubjectService complaintSubjectService;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("complaint-subject/{id}")
    public ResponseEntity<ComplaintSubject> getComplaintSubjectById(@PathVariable("id") String id) {
        ComplaintSubject complaintSubject = complaintSubjectService.getComplaintSubjectById(id);
        return ResponseEntity.ok().body(complaintSubject);
    }

    @PostMapping("complaint-subject")
    public ResponseEntity<CustomResponse> addComplaintSubject(@RequestBody ComplaintSubjectRequest complaintSubjectRequest) {
        CommonResponse commonResponse = complaintSubjectService.addComplaintSubject(complaintSubjectRequest);
        CustomResponse customResponse= new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

}
