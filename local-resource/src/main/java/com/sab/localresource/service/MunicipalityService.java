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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepository;

    public MunicipalityResponse addMunicipality(MunicipalityRequest municipalityRequest) throws GlobalException {

        CustomResponse<List<MunicipalityResponse>> response = new CustomResponse<>();
        MunicipalityResponse municipalityResponse = new MunicipalityResponse();
        try {
            Municipality municipality = new Municipality(municipalityRequest);
            municipalityRepository.save(municipality);
        } catch (Exception e) {
            ExceptionManager.throwGlobalException(GlobalConstant.ERROR_CODE_BAD_REQUEST, e.getMessage(), GlobalConstant.ERROR_CODE_BAD_REQUEST);
        }
        return municipalityResponse;
    }
}
