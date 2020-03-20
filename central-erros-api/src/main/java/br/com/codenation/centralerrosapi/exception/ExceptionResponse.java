package br.com.codenation.centralerrosapi.exception;

import java.util.List;

public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;
    private List<String> errors;

    ExceptionResponse() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    String getErrorMessage() {
        return errorMessage;
    }

    void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
