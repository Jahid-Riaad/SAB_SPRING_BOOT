package com.sab.student.repository;

import com.sab.student.model.InstitutionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionTypeRepository extends JpaRepository<InstitutionType, String> {
}
