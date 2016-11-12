package com.car.training.action;

import org.ironrhino.core.struts.BaseAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bill on 11/7/16.
 */
public class SimpleJsonAction extends BaseAction {
    private Object data;

    protected String successJSON(){
        this.data="success";
        return JSON;
    }

    @Override
    public String execute() throws Exception {
        return redirectToIndex();
    }

    public String redirectToIndex() {
        setTargetUrl("/website/index");
        return REDIRECT;
    }

    protected String errorJSON(String errMsg){
        this.data = new HashMap<String,String>();
        ((Map) data).put("error",errMsg);
        return JSON;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
