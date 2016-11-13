package com.car.training.enums;

/**
 * Created by bill on 11/13/16.
 */
public enum ReactTime {
    ONE_DAY("24小时之内"),
    THREE_DAYS("三天之内"),
    ONE_WEEK("一星期之内"),
    ONE_MONTH("一个月之内"),
    NO_GURANTEE("不确定");

    public final String displayString;

    ReactTime(String displayString) {
        this.displayString = displayString;
    }
}