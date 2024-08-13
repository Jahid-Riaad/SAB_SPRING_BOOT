package com.sab.student.service;

import com.sab.student.model.Institution;
import com.sab.student.repository.InstitutionRepository;
import com.sab.student.request.InstitutionAddRequest;
import com.sab.student.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public CommonResponse saveInstitution(InstitutionAddRequest institutionAddRequest) {
        institutionRepository.save(new Institution(institutionAddRequest));
        return new CommonResponse("0000000", "Institution Saved");
    }

    @Transactional
    public CommonResponse updateInstitution(Institution institution) {
        institutionRepository.save(institution);
        return new CommonResponse("0000000", "Institution Updated");
    }

    @Transactional
    public CommonResponse deleteInstitution(Institution institution) {
        institutionRepository.delete(institution);
        return new CommonResponse("0000000", "Institution Deleted!");
    }

}
