package com.sab.complaint.controller;


import com.sab.complaint.model.Complaint;
import com.sab.complaint.service.ComplaintService;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("create")
    public ResponseEntity<CustomResponse> createComplaint(@RequestBody Complaint complaint){
        CommonResponse commonResponse = complaintService.createComplaint(complaint);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
}
