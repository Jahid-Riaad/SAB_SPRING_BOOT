package com.sab.localresource.service;

import com.sab.localresource.model.InstitutionType;
import com.sab.localresource.repository.InstitutionTypeRepository;
import com.sab.localresource.request.InstitutionTypeAddRequest;
import com.sab.localresource.response.CommonResponse;
import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.util.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionTypeService {
    @Autowired
    InstitutionTypeRepository institutionTypeRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public CommonResponse saveInstitutionType(InstitutionTypeAddRequest institutionTypeAddRequest) throws GlobalException {
        CommonResponse commonResponse = new CommonResponse();
        try {
            InstitutionType institutionType = new InstitutionType(institutionTypeAddRequest);
            institutionTypeRepository.save(institutionType);
            commonResponse.setResponseCode("0000000");
            commonResponse.setResponseMessage("Institution Type Saved");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return commonResponse;

    }

    public CommonResponse updateInstitutionType(InstitutionType institutionType) throws GlobalException {
        CommonResponse commonResponse = new CommonResponse();
        try {
            institutionTypeRepository.save(institutionType);
            commonResponse.setResponseCode("0000000");
            commonResponse.setResponseMessage("Institution Type Updated");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return commonResponse;
    }

    public CommonResponse deleteInstitutionType(InstitutionType institutionType) throws GlobalException {
        CommonResponse commonResponse = new CommonResponse();
        try {
            institutionTypeRepository.delete(institutionType);
            commonResponse.setResponseCode("0000000");
            commonResponse.setResponseMessage("Institution Type Deleted");
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e.getMessage());
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE, GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE, GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
        }
        return commonResponse;
    }
}
