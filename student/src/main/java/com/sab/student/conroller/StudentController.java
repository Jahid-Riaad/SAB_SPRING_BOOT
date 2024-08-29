package com.sab.student.conroller;

import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.student.dto.StudentDTO;
import com.sab.student.model.Student;
import com.sab.student.request.StudentAddRequest;
import com.sab.student.service.StudentService;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.payload.response.Response;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("resource")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("student/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") String id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(studentService.convertToDTO(student));
    }

    @PostMapping ("check-student")
    public List<StudentDTO> checkStudentExistence(@RequestBody StudentDTO studentDTO) throws GlobalException {
        System.out.println("Inside checkStudentExistence");
        return studentService.existsStudent(studentDTO);
    }

    @PostMapping("student")
    public ResponseEntity<CustomResponse<Response>> addStudent(@RequestBody StudentAddRequest studentAddRequest) {
        CommonResponse commonResponse = studentService.addStudent(studentAddRequest);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

    @PutMapping("student")
    public ResponseEntity<CustomResponse<Response>> updateStudent(@RequestBody Student student) {
        CommonResponse commonResponse = studentService.updateStudent(student);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

    @DeleteMapping("student")
    public ResponseEntity<CustomResponse<Response>> deleteStudent(@RequestBody Student student) {
        CommonResponse commonResponse = studentService.deleteStudent(student);
        CustomResponse<Response> customResponse = new CustomResponse<>();
        customResponse.setResponse(Collections.singletonList(commonResponse));
        return ResponseEntity.ok().body(responseBuilder.buildResponse(customResponse));
    }

}
