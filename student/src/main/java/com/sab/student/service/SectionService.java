package com.sab.student.service;


import com.sab.student.model.Section;
import com.sab.student.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;
    public Section getSectionById(String id) {
        return sectionRepository.findById(id).orElse(null);
    }
}
