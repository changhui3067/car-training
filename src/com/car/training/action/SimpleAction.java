package com.car.training.action;

import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.struts.BaseAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bill on 11/7/16.
 */
public class SimpleAction extends BaseAction {
    private Object data;

    protected String successJSON() {
        this.data = "success";
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

    protected String errorJSON(String errMsg) {
        this.data = new HashMap<String, String>();
        ((Map) data).put("error", errMsg);
        return JSON;
    }

    public Object getData() {
        return data;
    }

    protected HttpSession getHttpSession() {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getSession();
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Before(priority = 20)
    public String validateUser() {
        if(!needLogin()){
            return null;
        }
        LoginVO loginVO = getLoginVO();
        if (loginVO != null) {
            return null;
        } else {
            return redirectToIndex();
        }
    }

    public LoginVO getLoginVO(){
        return (LoginVO) getHttpSession().getAttribute("loginVO");
    }

    protected boolean needLogin(){
        return false;
    }
}
