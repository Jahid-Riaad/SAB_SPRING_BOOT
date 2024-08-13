package com.sab.student.service;

import com.sab.student.model.Student;
import com.sab.student.repository.StudentRepository;
import com.sab.student.request.StudentAddRequest;
import com.sab.student.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public CommonResponse addStudent(StudentAddRequest studentAddRequest) {
        Student student= new Student(studentAddRequest);
        studentRepository.save(student);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Student Saved.");
        return commonResponse;
    }

    @Transactional
    public CommonResponse updateStudent(Student student) {
        studentRepository.save(student);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Student Updated.");
        return commonResponse;
    }

    @Transactional
    public CommonResponse deleteStudent(Student student) {
        studentRepository.save(student);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResponseCode("0000000");
        commonResponse.setResponseMessage("Student Deleted.");
        return commonResponse;
    }

}
