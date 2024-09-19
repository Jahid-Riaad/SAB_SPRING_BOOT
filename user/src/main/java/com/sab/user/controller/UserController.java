package com.sab.user.controller;

import com.sab.security.util.CustomUserDetails;
import com.sab.security.util.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping("/user/{username}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable("username") String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UserDTO userDTO = new UserDTO(
                userDetails.getUsername(),
                userDetails.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.ok(userDTO);
    }
}
