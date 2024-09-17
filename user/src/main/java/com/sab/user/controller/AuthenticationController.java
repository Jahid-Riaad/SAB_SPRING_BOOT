package com.sab.user.controller;

import com.sab.security.util.JwtUtil;
import com.sab.user.dto.AuthenticationRequest;
import com.sab.user.service.SabUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private SabUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtTokenUtil.generateToken(authenticationRequest.getUsername());
        } else {
            throw new Exception("Incorrect username or password");
        }
    }
}



