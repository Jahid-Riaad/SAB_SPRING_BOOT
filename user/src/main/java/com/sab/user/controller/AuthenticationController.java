package com.sab.user.controller;

import com.sab.security.util.JwtTokenProvider;
import com.sab.user.dto.AuthenticationRequest;
import com.sab.user.service.SabUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenUtil;

    @Autowired
    private SabUserDetailsService userDetailsService;

    @PostMapping("/login")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (authentication.isAuthenticated()) {
            return jwtTokenUtil.generateToken(userDetails);
        } else {
            throw new Exception("Incorrect username or password");
        }
    }
}



