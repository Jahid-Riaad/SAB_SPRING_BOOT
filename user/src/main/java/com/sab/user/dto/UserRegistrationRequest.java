package com.sab.user.dto;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String username;
    private String password;
    private String authorityId; // Include authority ID
    private Boolean enabled;
}