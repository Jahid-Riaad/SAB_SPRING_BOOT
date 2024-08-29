package com.sab.student.conroller;

import com.sab.sabglobal.util.ResponseBuilder;
import com.sab.student.model.Section;
import com.sab.student.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionController {

    @Autowired
    SectionService sectionService;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("section/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable String id){
        Section section=sectionService.getSectionById(id);
        return ResponseEntity.ok().body(section);
    }

}
