package com.sab.localresource.service;

import com.sab.localresource.model.Municipality;
import com.sab.localresource.repository.MunicipalityRepository;
import com.sab.localresource.request.MunicipalityRequest;
import com.sab.localresource.response.MunicipalityResponse;
import com.sab.sabglobal.enumeration.ErrorCodes;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public MunicipalityResponse addMunicipality(MunicipalityRequest municipalityRequest) throws GlobalException {
        MunicipalityResponse municipalityResponse = new MunicipalityResponse();
        try {
            Municipality municipality = new Municipality(municipalityRequest);
            municipalityRepository.save(municipality);
            municipalityResponse.setResponseCode("0000000");
            municipalityResponse.setResponseMessage("Municipality Saved.");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return municipalityResponse;
    }
}
