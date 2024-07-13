package com.sab.sabglobal.model;

import java.io.Serializable;

public class CustomError implements Serializable {

    private String code;
    private String message;
    private String type;

    public CustomError() {
    }

    public CustomError(String code, String message, String type) {
        super();
        this.code = code;
        this.message = message;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public CustomError setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CustomError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getType() {
        return type;
    }

    public CustomError setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", message=" + message + ", type=" + type + "]";
    }
}
