package com.sab.complaint.repository;

import com.sab.complaint.model.ComplaintSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintSubjectRepository extends JpaRepository<ComplaintSubject, String> {
}
