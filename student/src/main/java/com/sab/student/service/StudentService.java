package com.sab.student.service;

import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CommonResponse;
import com.sab.sabglobal.util.GlobalConstant;
import com.sab.student.dto.StudentDTO;
import com.sab.student.model.Student;
import com.sab.student.repository.StudentRepository;
import com.sab.student.request.StudentAddRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public CommonResponse addStudent(StudentAddRequest studentAddRequest) {
        Student student = new Student(studentAddRequest);
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

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentDTO> existsStudent(StudentDTO studentDTO) throws GlobalException {
        try {
            System.out.println("Inside existsStudent");
            List<Student> students = studentRepository.findStudentsByCriteria(
                    studentDTO.getInstitutionTypeId(),
                    studentDTO.getInstitutionId(),
                    studentDTO.getStandardId(),
                    studentDTO.getSectionId(),
                    studentDTO.getExamSessionId()
            );

            List<StudentDTO> studentDTOs = students.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            System.out.println("Returning StudentDTO List: " + studentDTOs);
            return studentDTOs;
        } catch (Exception e) {
            logger.error("Error Track is:::-------", e);
            ExceptionManager.throwGlobalException(GlobalConstant.SOMETHING_WRONG_ERROR_CODE,
                    GlobalConstant.SOMETHING_WRONG_ERROR_MESSAGE,
                    GlobalConstant.SOMETHING_WRONG_ERROR_TYPE);
            return Collections.emptyList();
        }
    }

    public StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setStudentName(student.getStudentName());
        dto.setClassRollNo(student.getClassRollNo());
        dto.setInstitutionTypeId(student.getInstitutionType().getId());
        dto.setInstitutionId(student.getInstitution().getId());
        dto.setStandardId(student.getStandard().getId());
        dto.setSectionId(student.getSection().getId());
        dto.setExamSessionId(student.getExamSession().getId());
        return dto;
    }
}
