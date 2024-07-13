package com.sab.sabglobal.exception;

import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.util.GlobalConstant;

import java.util.Collections;

public class TokenNotFoundException extends SABBaseException {


    private static final long serialVersionUID = 1L;

    public TokenNotFoundException(String message) {
        super(Collections.singletonList(new CustomError(GlobalConstant.TOKEN_NOT_FOUND_ERROR_CODE, message,
                GlobalConstant.TOKEN_NOT_FOUND_ERROR_TYPE)));
    }
}
