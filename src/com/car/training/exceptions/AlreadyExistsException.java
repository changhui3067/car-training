package com.car.training.exceptions;

public class AlreadyExistsException extends UnrecoverableException {

    private static final long serialVersionUID = -706274831282950780L;

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String code, String message) {
        super(code, message);
    }

}
