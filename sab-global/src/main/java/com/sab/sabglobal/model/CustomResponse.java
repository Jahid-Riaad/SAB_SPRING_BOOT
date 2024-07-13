package com.sab.sabglobal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse<T extends Object> {

    private List<T> response;
    private List<CustomError> errors;
    private boolean isSuccess;
    private String timeStamp;

    public CustomResponse() {
        response = new ArrayList<>();
        errors = new ArrayList<>();
    }

    public CustomResponse(List<T> response, List<CustomError> errors, boolean isSuccess,
                          String timeStamp) {
        super();
        this.response = response;
        this.errors = errors;
        this.isSuccess = isSuccess;
        this.timeStamp = timeStamp;
    }

    /**
     * @return the response
     */
    public List<T> getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(List<T> response) {
        this.response = response;
    }

    /**
     * @return the errors
     */
    public List<CustomError> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(List<CustomError> errors) {
        this.errors = errors;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        final int maxLen = 10;
        return "CustomResponseBody [response="
                + (response != null ? response.subList(0, Math.min(response.size(), maxLen)) : null) + ", errors="
                + (errors != null ? errors.subList(0, Math.min(errors.size(), maxLen)) : null) + ", timeStamp=" + timeStamp + "]";
    }
}
