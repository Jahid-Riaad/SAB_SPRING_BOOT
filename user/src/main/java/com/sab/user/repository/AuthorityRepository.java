package com.sab.user.repository;

import com.sab.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
