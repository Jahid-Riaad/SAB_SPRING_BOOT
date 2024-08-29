package com.sab.complaint.controller;

import com.sab.complaint.model.Recipient;
import com.sab.complaint.request.RecipientRequest;
import com.sab.complaint.service.RecipientService;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class RecipientController {

    @Autowired
    RecipientService recipientService;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("recipient/{id}")
    public Recipient getRecipientById(@PathVariable String id){
        return recipientService.getRecipientById(id);
    }

    @PostMapping("recipient")
    public ResponseEntity<CustomResponse> addRecipient(@RequestBody RecipientRequest recipientRequest){
        CommonResponse commonResponse= recipientService.addRecipient(recipientRequest);
        CustomResponse customResponse= new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(customResponse);
    }
}
