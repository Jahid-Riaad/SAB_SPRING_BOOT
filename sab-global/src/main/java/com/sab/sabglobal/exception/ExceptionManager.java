package com.sab.sabglobal.exception;



import com.sab.sabglobal.model.CustomError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public final class ExceptionManager {
    public static void throwGlobalException(String code, String message, String type) throws GlobalException {
        CustomError error = new CustomError( code, message, type);
        throw new GlobalException(Collections.singletonList(error));
    }

    public static void throwSABSQLException(String code, String message, String type) throws SABSQLException {
        CustomError error = new CustomError( code, message, type);
        throw new SABSQLException(Collections.singletonList(error));
    }
    public static void throwSABSQLException(CustomError error) throws SABSQLException {
        throw new SABSQLException(Collections.singletonList(error));
    }

}
