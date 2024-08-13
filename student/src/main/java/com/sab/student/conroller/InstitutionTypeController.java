package com.sab.student.conroller;


import com.sab.student.model.InstitutionType;
import com.sab.student.request.InstitutionTypeAddRequest;
import com.sab.student.response.CommonResponse;
import com.sab.student.service.InstitutionTypeService;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.payload.response.Response;
import com.sab.sabglobal.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@CrossOrigin
@RestController
@RequestMapping("resource")
public class InstitutionTypeController {

    @Autowired
    InstitutionTypeService institutionTypeService;
    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("institution-type")
    public ResponseEntity<CustomResponse> addInstitutionType (@RequestBody @Valid InstitutionTypeAddRequest institutionTypeAddRequest) throws GlobalException {
        CommonResponse commonResponse =  institutionTypeService.saveInstitutionType(institutionTypeAddRequest);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @PutMapping ("institution-type")
    public ResponseEntity<CustomResponse> updateInstitutionType (@RequestBody @Valid InstitutionType institutionType) throws GlobalException {
        CommonResponse commonResponse =  institutionTypeService.updateInstitutionType(institutionType);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @DeleteMapping ("institution-type")
    public ResponseEntity<CustomResponse> deleteInstitutionType (@RequestBody @Valid InstitutionType institutionType) throws GlobalException {
        CommonResponse commonResponse =  institutionTypeService.deleteInstitutionType(institutionType);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
}
