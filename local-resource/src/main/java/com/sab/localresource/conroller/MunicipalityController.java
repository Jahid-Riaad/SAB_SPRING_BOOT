package com.sab.localresource.conroller;


import com.sab.localresource.request.MunicipalityRequest;
import com.sab.localresource.service.MunicipalityService;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.payload.response.Response;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin
@RestController
@RequestMapping("resource")
public class MunicipalityController {

    @Autowired
    MunicipalityService municipalityService;
    @Autowired
    ResponseBuilder<Response> responseBuilder;


    @PostMapping("municipality")
    public ResponseEntity<CustomResponse<Response>> addMunicipality(@RequestBody MunicipalityRequest request) throws GlobalException {
        Response vo = municipalityService.addMunicipality(request);
        CustomResponse<Response> response = new CustomResponse<>();
        response.setResponse(Collections.singletonList(vo));
        response.setErrors(Collections.emptyList());
        return ResponseEntity.ok().body(responseBuilder.buildResponse(response));
    }
}
