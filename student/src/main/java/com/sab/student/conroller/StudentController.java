package com.sab.student.conroller;

import com.sab.student.model.Student;
import com.sab.student.request.StudentAddRequest;
import com.sab.student.response.CommonResponse;
import com.sab.student.service.StudentService;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.payload.response.Response;
import com.sab.sabglobal.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("resource")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ResponseBuilder responseBuilder;

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
