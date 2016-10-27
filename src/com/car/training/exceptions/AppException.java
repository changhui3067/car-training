package com.car.training.exceptions;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 8591406907774799973L;

    protected String code;

    public AppException(String message) {
        super(message);
    }

    public AppException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
