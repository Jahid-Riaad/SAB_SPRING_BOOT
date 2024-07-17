package com.sab.localresource.service;

import com.sab.localresource.model.Institution;
import com.sab.localresource.repository.InstitutionRepository;
import com.sab.localresource.request.InstitutionRequest;
import com.sab.localresource.response.CommonResponse;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public CommonResponse saveInstitution(InstitutionRequest institutionRequest) throws GlobalException {
        try {
            Institution institution = new Institution(institutionRequest);
            institutionRepository.save(institution);
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE,
                    GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return new CommonResponse("0000000", "Institution Saved");
    }
}
