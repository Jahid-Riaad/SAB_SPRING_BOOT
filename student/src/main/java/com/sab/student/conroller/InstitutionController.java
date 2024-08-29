package com.sab.student.conroller;

import com.sab.sabglobal.model.CommonResponse;
import com.sab.student.dto.InstitutionDTO;
import com.sab.student.model.Institution;
import com.sab.student.request.InstitutionAddRequest;
import com.sab.student.service.InstitutionService;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("resource")
public class InstitutionController {

    @Autowired
    InstitutionService institutionService;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("institution/{id}")
    public ResponseEntity<InstitutionDTO> getInstitutionById(@PathVariable("id") String id) {
        Institution institutions = institutionService.getInstitutionById(id);
        return ResponseEntity.ok().body(new InstitutionDTO().convertToDTO(institutions));
    }

    @GetMapping("institutions")
    public ResponseEntity<List<InstitutionDTO>> getInstitution() {
        List<Institution> institutions = institutionService.getAllInstitutions();
        return ResponseEntity.ok().body(new InstitutionDTO().convertToDTOList(institutions));
    }

    @PostMapping("institution")
    public ResponseEntity<CustomResponse> addInstitution(@RequestBody @Valid InstitutionAddRequest institutionAddRequest) throws GlobalException {
        CommonResponse commonResponse = institutionService.saveInstitution(institutionAddRequest);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

    @PutMapping("institution")
    public ResponseEntity<CustomResponse> updateInstitution(@RequestBody @Valid Institution institution) throws GlobalException {
        CommonResponse commonResponse = institutionService.updateInstitution(institution);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

    @DeleteMapping("institution")
    public ResponseEntity<CustomResponse> deleteInstitution(@RequestBody @Valid Institution institution) throws GlobalException {
        CommonResponse commonResponse = institutionService.deleteInstitution(institution);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }


}
