package com.sab.security.service;

import com.sab.security.entity.UserPrincipal;
import com.sab.security.entity.UserProfile;
import com.sab.security.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SabUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserProfile userProfile = null;

            userProfile = userRepository.findById(username)
                    .orElseThrow(() -> new BadCredentialsException("Bad Credentials"));
        // Force initialization of lazy-loaded Authorities
        Hibernate.initialize(userProfile.getAuthorities());

        return new UserPrincipal(userProfile);
    }
}
