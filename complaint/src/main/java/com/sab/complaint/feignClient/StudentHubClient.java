package com.sab.complaint.feignClient;

import com.sab.complaint.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentHubClient {

    @GetMapping("municipality/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable("id") String id);

    @GetMapping("institution-type/{id}")
    public ResponseEntity<InstitutionType> getInstitutionTypeById(@PathVariable("id") String id);

    @GetMapping("institution/{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable("id") String id);

    @GetMapping("standard/{id}")
    public ResponseEntity<Standard> getStandardById(@PathVariable("id") String id);

    @GetMapping("section/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable("id") String id);

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id);

    @PostMapping("check-student")
    public List<Student> checkStudentExistence(@RequestBody Student student);
}
