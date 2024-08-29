package com.sab.sabglobal.util;


import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.model.CustomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;



@Component
public class ResponseBuilder<T> {
    private static final Logger logger = LoggerFactory.getLogger(ResponseBuilder.class);
    public CustomResponse<T> buildResponse(CustomResponse<T> response) {
        logger.info("Inside buildResponse method and Setting the response.");
        response.setErrors(Collections.emptyList());
        response.setTimeStamp(LocalDateTime.now().toString());
        response.setSuccess(true);

        return response;
    }

    public CustomResponse<T> buildResponse(List<CustomError> errors) {
        logger.info("(Error) Inside buildResponse method and Setting the error.");
        CustomResponse<T> response = null;

        try {
            response = new CustomResponse<>();
            response.setErrors(errors);
            response.setResponse(Collections.emptyList());
            response.setTimeStamp(LocalDateTime.now().toString());
            response.setSuccess(false);
            return response;
        } finally {
            response = null;
        }
    }

    public CustomResponse<T> buildResponse(List<T> payload, List<CustomError> errors, boolean success) {

        CustomResponse<T> response = new CustomResponse<>();
        response.setErrors(errors);
        response.setResponse(payload);
        response.setTimeStamp(LocalDateTime.now().toString());
        response.setSuccess(success);

        return response;

    }
}