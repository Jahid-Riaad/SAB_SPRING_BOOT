package com.sab.student.conroller;


import com.sab.sabglobal.model.CommonResponse;
import com.sab.student.dto.MunicipalityDTO;
import com.sab.student.model.Municipality;
import com.sab.student.request.MunicipalityAddRequest;
import com.sab.student.service.MunicipalityService;
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
//@RequestMapping("resource")
public class MunicipalityController {

    @Autowired
    MunicipalityService municipalityService;
    @Autowired
    ResponseBuilder<Response> responseBuilder;

    @GetMapping("municipality/{id}")
    public ResponseEntity<MunicipalityDTO> getMunicipalityById(@PathVariable("id") String id){
        Municipality municipality = municipalityService.getMunicipalityById(id);
        return ResponseEntity.ok().body(new MunicipalityDTO().convertToDTO(municipality));
    }

    @PostMapping("municipality")
    public ResponseEntity<CustomResponse<Response>> addMunicipality(@RequestBody MunicipalityAddRequest request) throws GlobalException {
        CommonResponse commonResponse = municipalityService.addMunicipality(request);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }
    @PutMapping("municipality")
    public ResponseEntity<CustomResponse<Response>> updateMunicipality(@RequestBody Municipality municipality ){
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
