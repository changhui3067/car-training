package com.car.training.enums;

import org.ironrhino.core.model.Displayable;

public enum PositionType implements Displayable {
    //销售,   售后,   客服, 市场,  管理,  内训, 生产研发, 行政
    SELL, AFTERSELL, CUSTOMERSERVICE, MARKET, MANAGEMENT, INTERTRAINING, PRODUCTION, OFFICER;

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
