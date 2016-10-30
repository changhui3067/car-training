package com.car.training.sms;

import org.ironrhino.core.model.Displayable;

public enum SmsTemplate implements Displayable {

    LOGIN, REGISTER, SETPASSWORD, CHANGEPASSWORD, BIND, BACKPASSWORD, RESETPASSWORD, NORMAL;

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDisplayName() {
        return Displayable.super.getDisplayName();
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

}
