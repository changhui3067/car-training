package com.car.training.exceptions;

public class UnrecoverableException extends AppException {

    private static final long serialVersionUID = -3319637662346109497L;

    public UnrecoverableException(String message) {
        super(message);
    }

    public UnrecoverableException(String code, String message) {
        super(code, message);
    }

}
