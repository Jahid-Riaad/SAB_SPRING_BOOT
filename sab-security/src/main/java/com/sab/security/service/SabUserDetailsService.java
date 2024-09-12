package com.sab.security.service;


import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.util.GlobalConstant;
import com.sab.security.entity.UserPrincipal;
import com.sab.security.entity.UserProfile;
import com.sab.security.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SabUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userRepository.findUserByUsername(username);

        if (userProfile == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // Force initialization of lazy-loaded Authorities
        Hibernate.initialize(userProfile.getAuthorities());

        return new UserPrincipal(userProfile);
    }
}
