package com.car.training.exceptions;

public class UndeletableException extends AppException {

    private static final long serialVersionUID = -3319637662346109497L;

    public UndeletableException(String message) {
        super(message);
    }

    public UndeletableException(String code, String message) {
        super(code, message);
    }

}
