package com.sab.localresource.repository;

import com.sab.localresource.model.InstitutionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionTypeRepository extends JpaRepository<InstitutionType, Integer> {
}
