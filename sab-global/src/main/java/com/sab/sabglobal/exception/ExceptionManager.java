package com.sab.sabglobal.exception;



import com.sab.sabglobal.model.CustomError;
import java.util.Collections;

public final class ExceptionManager {

    public static void throwGlobalException(String code, String message, String type) throws GlobalException {
        CustomError error = new CustomError( code, message, type);
        throw new GlobalException(Collections.singletonList(error));
    }

    public static void throwNGISQLException(String code, String message, String type) throws SABSQLException {
        CustomError error = new CustomError( code, message, type);
        throw new SABSQLException(Collections.singletonList(error));
    }
    public static void throwNGISQLException(CustomError error) throws SABSQLException {
        throw new SABSQLException(Collections.singletonList(error));
    }

}
