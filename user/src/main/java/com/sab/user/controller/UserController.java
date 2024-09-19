package com.sab.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/user/{username}")
    public ResponseEntity<UserDetails> getUserDetails(
            @PathVariable("username") String username,
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authorization) {

        if (authorization == null || !authorization.equals("Bearer " + apiKey)) {
            return ResponseEntity.status(403).build(); // Forbidden
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails != null) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
