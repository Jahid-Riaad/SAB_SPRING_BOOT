package com.sab.localresource.conroller;


import com.sab.localresource.model.Municipality;
import com.sab.localresource.request.MunicipalityAddRequest;
import com.sab.localresource.response.CommonResponse;
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
    public ResponseEntity<CustomResponse<Response>> addMunicipality(@RequestBody MunicipalityAddRequest request) throws GlobalException {
        CommonResponse commonResponse = municipalityService.addMunicipality(request);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @PutMapping("municipality")
    public ResponseEntity<CustomResponse<Response>> updateMunicipality(@RequestBody Municipality municipality ) throws GlobalException {
        CommonResponse commonResponse = municipalityService.updateMunicipality(municipality);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @DeleteMapping ("municipality")
    public ResponseEntity<CustomResponse<Response>> deleteMunicipality(@RequestBody Municipality municipality ) throws GlobalException {
        CommonResponse commonResponse = municipalityService.deleteMunicipality(municipality);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
}
