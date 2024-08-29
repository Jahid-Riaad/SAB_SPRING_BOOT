package com.sab.student.repository;

import com.sab.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM Student s " +
            "WHERE s.institutionType.id = :institutionTypeId " +
            "AND s.institution.id = :institutionId " +
            "AND s.standard.id = :standardId " +
            "AND s.section.id = :sectionId " +
            "AND s.examSession.id = :examSessionId")
    List<Student> findStudentsByCriteria(String institutionTypeId, String institutionId, String standardId, String sectionId, String examSessionId);
}
