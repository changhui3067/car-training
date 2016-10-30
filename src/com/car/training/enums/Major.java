package com.car.training.enums;

import org.ironrhino.core.model.Displayable;

public enum Major implements Displayable {

    // 汽车服务工程，汽车销售与评估，汽车检测与维修，汽车商务管理等学科
    CARSELL, CARSERVICE, CARMANTAIN, CARMANAGEMENT;

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
