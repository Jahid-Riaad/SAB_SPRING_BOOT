package com.sab.sabglobal.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodes{
    INSTANCE;

    private static Map<String, String> errorMap = new HashMap<>();

    // Add error codes from ErrorCodeOne
    static {
        addErrorCodes(HttpErrorCodes.class);
        // Add more enums as needed
    }

    private static void addErrorCodes(Class<? extends Enum<?>> enumClass) {
        Enum<?>[] enums = enumClass.getEnumConstants();
        for (Enum<?> e : enums) {
            if (e instanceof ErrorCode) {
                ErrorCode errorCode = (ErrorCode) e;
                errorMap.put(errorCode.getCode(), errorCode.getDescription());
            }
        }
    }

    public static String getDescriptionByCode(String code) {
        String description = errorMap.get(code);
        return (description != null) ? description : "Error code not found";
    }

    public interface ErrorCode {
        String getCode();
        String getDescription();
    }
}
