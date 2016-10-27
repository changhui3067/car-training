package com.car.training.enums;

import org.ironrhino.core.model.Displayable;

public enum Languages implements Displayable {

    //普通话英语日语德语
    MANDARIN, ENGLISH, JAPANESE, GERMAN;

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
