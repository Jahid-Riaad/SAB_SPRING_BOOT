package com.sab.localresource.conroller;
import com.sab.localresource.model.Institution;
import com.sab.localresource.request.InstitutionAddRequest;
import com.sab.localresource.response.CommonResponse;
import com.sab.localresource.service.InstitutionService;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("resource")
public class InstitutionController {


    @Autowired
    InstitutionService institutionService;

    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("institution")
    public ResponseEntity<CustomResponse> addInstitution(@RequestBody @Valid InstitutionAddRequest institutionAddRequest) throws GlobalException {
        CommonResponse commonResponse= institutionService.saveInstitution(institutionAddRequest);
        CustomResponse customResponse=new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @PutMapping("institution")
    public ResponseEntity<CustomResponse> updateInstitution(@RequestBody @Valid Institution institution) throws GlobalException {
        CommonResponse commonResponse= institutionService.updateInstitution(institution);
        CustomResponse customResponse=new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @DeleteMapping("institution")
    public ResponseEntity<CustomResponse> deleteInstitution(@RequestBody @Valid Institution institution) throws GlobalException {
        CommonResponse commonResponse= institutionService.deleteInstitution(institution);
        CustomResponse customResponse=new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }


}
