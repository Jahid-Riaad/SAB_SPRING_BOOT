package com.sab.student.service;

import com.sab.sabglobal.model.CommonResponse;
import com.sab.student.model.Municipality;
import com.sab.student.repository.MunicipalityRepository;
import com.sab.student.request.MunicipalityAddRequest;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.util.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public CommonResponse addMunicipality(MunicipalityAddRequest municipalityAddRequest) {

        Municipality municipality = new Municipality(municipalityAddRequest);
        CommonResponse commonResponse = new CommonResponse();
        municipalityRepository.save(municipality);
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Municipality Saved.");
        return commonResponse;
    }

    @Transactional
    public CommonResponse updateMunicipality(Municipality municipality) {
        CommonResponse commonResponse = new CommonResponse();
        municipalityRepository.save(municipality);
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Municipality Updated.");
        return commonResponse;
    }

    public CommonResponse deleteMunicipality(Municipality municipality) throws GlobalException {
        CommonResponse commonResponse = new CommonResponse();
        try {
            municipalityRepository.delete(municipality);
            commonResponse.setResponseCode("0000000");
            commonResponse.setResponseMessage("Municipality Deleted.");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return commonResponse;
    }

    public Municipality getMunicipalityById(String id) {
        return municipalityRepository.findById(id).orElse(null);
    }
}
