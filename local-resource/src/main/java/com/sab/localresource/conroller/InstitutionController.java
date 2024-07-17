package com.sab.localresource.conroller;
import com.sab.localresource.request.InstitutionRequest;
import com.sab.localresource.response.CommonResponse;
import com.sab.localresource.service.InstitutionService;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("resource")
public class InstitutionController {


    @Autowired
    InstitutionService institutionService;

    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("institution")
    public ResponseEntity<CustomResponse> addInstitution(@RequestBody @Valid InstitutionRequest institutionRequest) throws GlobalException {
        CommonResponse commonResponse= institutionService.saveInstitution(institutionRequest);
        CustomResponse customResponse=new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
}
