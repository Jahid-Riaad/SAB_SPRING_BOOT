package com.example.demo;

import java.util.Collections;

public class ProductNotFoundException {
    public static void throwException(String message)throws GlobalException {
        throw new GlobalException(message);
    }
}


