package com.sab.complaint.dto;

import lombok.Data;

@Data
public class Institution {
    private String id;
    private String name;
    private String institutionTypeName;
    private String municipalityName;
    private String address;
}
