package com.sab.student.service;

import com.sab.student.model.Standard;
import com.sab.student.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardService {

    @Autowired
    StandardRepository standardRepository;

    public Standard getStandardById(String id) {
        return standardRepository.findById(id).orElse(null);
    }
}
