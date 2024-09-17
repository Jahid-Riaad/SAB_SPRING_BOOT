package com.sab.user.service;


import com.sab.sabglobal.exception.ExceptionManager;
import com.sab.sabglobal.exception.GlobalException;
import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.util.GlobalConstant;
import com.sab.user.dto.UserRegistrationRequest;
import com.sab.user.entity.Authority;
import com.sab.user.entity.UserProfile;
import com.sab.user.repository.AuthorityRepository;
import com.sab.user.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserProfile registerUser(UserRegistrationRequest request) throws GlobalException {
        // Check if the user already exists
        if (userProfileRepository.findById(request.getUsername()).isPresent()) {
            ExceptionManager.throwGlobalException(  GlobalConstant.UNIQUE_CONSTRAINT_ERROR_CODE, GlobalConstant.UNIQUE_CONSTRAINT_ERROR_TYPE,
                    GlobalConstant.UNIQUE_CONSTRAINT_ERROR_MESSAGE);
        }

        // Retrieve Authority
        Authority authority = authorityRepository.findById(request.getAuthorityId())
                .orElseThrow(() -> new RuntimeException("Invalid authority"));
        
        // Create new UserProfile entity
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(request.getUsername());
        userProfile.setPassword(passwordEncoder.encode(request.getPassword()));
        userProfile.setAuthority(authority);
        userProfile.setEnabled(request.getEnabled());

        // Save the new user in the database
        return userProfileRepository.save(userProfile);
    }
}
