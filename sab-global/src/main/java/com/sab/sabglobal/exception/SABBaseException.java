package com.sab.sabglobal.exception;



import com.sab.sabglobal.model.CustomError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SABBaseException extends Exception {

    List<CustomError> errors;

    private static final long serialVersionUID = 1L;

    public SABBaseException() {
        super();
        errors = new ArrayList<>();
    }

    public SABBaseException(List<CustomError> errors) {
        super(errors.stream().map(CustomError::getMessage).collect(Collectors.toList()).toString());
        this.errors = errors;
    }


    public SABBaseException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SABBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SABBaseException(String message) {
        super(message);
    }

    public SABBaseException(Throwable cause) {
        super(cause);
    }

    public List<CustomError> getErrors() {
        return errors;
    }

    public void setErrors(List<CustomError> errors) {
        this.errors = errors;
    }
}