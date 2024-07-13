package com.sab.sabglobal.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyUserResponse implements Serializable {
    private String message;
    private String statusCode;
    private Boolean isValidUser;
}
