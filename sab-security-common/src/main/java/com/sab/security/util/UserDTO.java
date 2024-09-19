package com.sab.security.util;

public class UserDTO {
    private String username;
    private List<String> authorities;

    public UserDTO(String username, List<String> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }
}
