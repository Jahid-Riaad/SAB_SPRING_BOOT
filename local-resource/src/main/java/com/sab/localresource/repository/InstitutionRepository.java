package com.sab.localresource.repository;

import com.sab.localresource.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
}
