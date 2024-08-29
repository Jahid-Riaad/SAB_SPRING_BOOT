package com.sab.student.conroller;

import com.sab.sabglobal.util.ResponseBuilder;
import com.sab.student.model.Standard;
import com.sab.student.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardController {
    @Autowired
    StandardService standardService;
    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("standard/{id}")
    public ResponseEntity<Standard> getStandardById(@PathVariable String id){
        Standard standard= standardService.getStandardById(id);
        return  ResponseEntity.ok().body(standard);
    }

}
