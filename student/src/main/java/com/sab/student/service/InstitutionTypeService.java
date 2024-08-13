package com.sab.student.service;

import com.sab.student.model.InstitutionType;
import com.sab.student.repository.InstitutionTypeRepository;
import com.sab.student.request.InstitutionTypeAddRequest;
import com.sab.student.response.CommonResponse;
import com.sab.sabglobal.exception.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstitutionTypeService {
    @Autowired
    InstitutionTypeRepository institutionTypeRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public CommonResponse saveInstitutionType(InstitutionTypeAddRequest institutionTypeAddRequest) {
        InstitutionType institutionType = new InstitutionType(institutionTypeAddRequest);
        institutionTypeRepository.save(institutionType);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Institution Type Saved");
        return commonResponse;
    }

    @Transactional
    public CommonResponse updateInstitutionType(InstitutionType institutionType) {
        institutionTypeRepository.save(institutionType);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Institution Type Updated");
        return commonResponse;
    }

    @Transactional
    public CommonResponse deleteInstitutionType(InstitutionType institutionType){

        institutionTypeRepository.delete(institutionType);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Institution Type Deleted");
        return commonResponse;
    }
}
