package com.sab.complaint.controller;


import com.sab.complaint.dto.ComplaintDTO;
import com.sab.complaint.service.ComplaintService;
import com.sab.sabglobal.exception.SABSQLException;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("create")
    public ResponseEntity<CustomResponse> createComplaint(@RequestPart("complaint") ComplaintDTO complaintDTO,
                                                          @RequestPart("files") List<MultipartFile> files) throws IOException {
        CommonResponse commonResponse = complaintService.createComplaintWithAttachments(complaintDTO, files);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

    @GetMapping("/download/{attachmentId}")
    public ResponseEntity<Resource> downloadAttachment(@PathVariable String attachmentId) throws SABSQLException {
        Resource resource = complaintService.downloadAttachment(attachmentId);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}
