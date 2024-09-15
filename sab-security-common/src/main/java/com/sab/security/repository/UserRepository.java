package com.sab.security.repository;

import com.sab.security.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserProfile, String> {
}
