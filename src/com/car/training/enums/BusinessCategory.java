package com.car.training.enums;

import org.ironrhino.core.model.Displayable;

public enum BusinessCategory implements Displayable {

    //产品,销售,售后,非技术,技术,管理,财务,市场营销,客户关系,人事,生产,领导力,新能源
    PRODUCT, SELL, NOSKILL, SKILL, MANAGEMENT, FINANCE, MARKET, CUSTOMERRELATION, HUMANRESOURCE, PRODUCE, LEADERSHIP, NEWENERGY;

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
