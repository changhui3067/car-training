package com.car.training.exceptions;

public class NotFoundException extends UnrecoverableException {

    private static final long serialVersionUID = -2052107673689192044L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String code, String message) {
        super(code, message);
    }

}
