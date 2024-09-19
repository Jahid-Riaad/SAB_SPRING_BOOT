package com.sab.user.controller;

import com.sab.sabglobal.exception.GlobalException;
import com.sab.user.dto.UserRegistrationRequest;
import com.sab.user.entity.UserProfile;
import com.sab.user.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public UserProfile registerUser(@RequestBody UserRegistrationRequest request) throws GlobalException {
        return userRegistrationService.registerUser(request);
    }
}
