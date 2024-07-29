package com.sab.localresource.service;

import com.sab.localresource.model.Municipality;
import com.sab.localresource.repository.MunicipalityRepository;
import com.sab.localresource.request.MunicipalityAddRequest;
import com.sab.localresource.response.CommonResponse;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.util.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public CommonResponse addMunicipality(MunicipalityAddRequest municipalityAddRequest) throws GlobalException {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Municipality municipality = new Municipality(municipalityAddRequest);
            municipalityRepository.save(municipality);
            commonResponse.setResponseCode("0000000");
            commonResponse.setResponseMessage("Municipality Saved.");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return commonResponse;
    }

    public CommonResponse updateMunicipality(Municipality municipality) throws GlobalException {
        CommonResponse commonResponse = new CommonResponse();
        try {
            municipalityRepository.save(municipality);
            commonResponse.setResponseCode("0000000");
            commonResponse.setResponseMessage("Municipality Updated.");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
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
}
