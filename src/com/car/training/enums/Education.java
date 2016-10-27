package com.car.training.enums;

import org.ironrhino.core.model.Displayable;

public enum Education implements Displayable {

    //初中，高中，大学，研究生，博士，博士后
    POSTDOCTOR, DOCTOR, MASTER, COLLEGE, HIGHSCHOOL, JUNIORHIGHSCHOOL;

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
