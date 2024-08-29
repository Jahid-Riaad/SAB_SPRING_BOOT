package com.sab.complaint.repository;

import com.sab.complaint.model.ComplainantRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainantRelationshipRepository extends JpaRepository<ComplainantRelationship, String> {
}
