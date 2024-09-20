package com.sab.user.controller;

import com.sab.sabglobal.exception.GlobalException;
import com.sab.security.util.JwtTokenProvider;
import com.sab.security.util.UserDTO;
import com.sab.user.dto.AuthenticationRequest;
import com.sab.user.dto.UserRegistrationRequest;
import com.sab.user.entity.UserProfile;
import com.sab.user.security.SabUserDetailsService;
import com.sab.user.service.UserRegistrationService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenUtil;
    private final SabUserDetailsService userDetailsService;
    private final UserRegistrationService userRegistrationService;


    @PostMapping("/register")
    public UserProfile registerUser(@RequestBody UserRegistrationRequest request) throws GlobalException {
        return userRegistrationService.registerUser(request);
    }
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
    @PostMapping("/validate-token")
    public ResponseEntity<UserDTO> validateToken(@RequestBody String token) {
        UserDTO userDTO = null;
        try {
            if (jwtTokenUtil.isTokenExpired(token)){
                throw new ExpiredJwtException(null, null, "Token expired");
            }
            if (jwtTokenUtil.validateToken(token)){
                UserDetails userDetails = userDetailsService.loadUserByUsername(jwtTokenUtil.extractUsername(token));
                userDTO = new UserDTO(
                        userDetails.getUsername(),
                        userDetails.getAuthorities()
                                .stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList())
                );
            }
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            throw new ExpiredJwtException(null, null, e.getMessage());
        }
    }


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



