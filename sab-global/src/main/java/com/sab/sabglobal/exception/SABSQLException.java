package com.sab.sabglobal.exception;

import com.sab.sabglobal.model.CustomError;

import java.util.List;

public class SABSQLException extends SABBaseException {

    private static final long serialVersionUID = 1L;

    public SABSQLException() {
        super();
    }

    public SABSQLException(List<CustomError> error) {
        super(error);
    }

    public SABSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SABSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public SABSQLException(String message) {
        super(message);
    }

    public SABSQLException(Throwable cause) {
        super(cause);
    }

}
