package com.car.training.enums;

import org.ironrhino.core.model.Displayable;

public enum Scale implements Displayable {

    // 50人以下,51至100人,101至200人,201至500人,501至1000人,1000人以上
    UNDER50, FROM51TO100, FROM101TO200, FROM201TO500, FROM501TO1000, ABOVE1000;

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
