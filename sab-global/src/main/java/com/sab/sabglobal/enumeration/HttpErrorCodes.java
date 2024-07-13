package com.sab.sabglobal.enumeration;

public enum HttpErrorCodes implements ErrorCodes.ErrorCode {
    ERROR_400("400", "Bad Request"),
    ERROR_401("401", "Unauthorized"),
    ERROR_403("403", "Forbidden"),
    ERROR_404("404", "Not Found"),
    ERROR_500("500", "Internal Server Error"),
    ERROR_502("502", "Bad Gateway"),
    ERROR_503("503", "Service Unavailable");

    private final String code;
    private final String description;

    HttpErrorCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
