package com.sab.complaint.feignClient;

import com.sab.complaint.dto.*;
import com.sab.sabglobal.response.ApiBooleanResponse;
import com.sab.student.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "student")
public interface StudentHubClient {

    @GetMapping("student-hub/municipality/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable("id") String id);

    @GetMapping("student-hub/institution-type/{id}")
    public ResponseEntity<InstitutionType> getInstitutionTypeById(@PathVariable("id") String id);

    @GetMapping("student-hub/institution/{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable("id") String id);

    @GetMapping("student-hub/standard/{id}")
    public ResponseEntity<Standard> getStandardById(@PathVariable("id") String id);

    @GetMapping("student-hub/section/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable("id") String id);

    @GetMapping("student-hub/student/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") String id);

    @PostMapping("student-hub/check-student")
    public List<StudentDTO> checkStudentExistence(@RequestBody StudentDTO student);
}
