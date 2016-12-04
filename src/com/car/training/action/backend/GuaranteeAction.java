package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.LoginUser;
import com.car.training.bean.PersonInfo;
import com.car.training.enums.UserType;
import com.car.training.service.GuaranteeService;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AutoConfig
public class GuaranteeAction extends SimpleAction {
    private int companyId;

    @Autowired
    private GuaranteeService guaranteeService;

    @Autowired
    private LoginVO loginVO;

    private List<PersonInfo> personList;

    public String guarantee() {
        loginVO = (LoginVO) getHttpSession().getAttribute("loginVO");
        if (loginVO == null){
            return "请登录";
        }
        if (guaranteeService.guarantee(loginVO.getId(), companyId)) {
            personList = guaranteeService.findPeronByCompanyId(companyId);
            return "guaranteePersonListResult";
        } else {
            return "error";
        }
    }

    public String unGuarantee() {
        loginVO = (LoginVO) getHttpSession().getAttribute("loginVO");
        if (loginVO == null){
            return "请登录";
        }
        if (guaranteeService.unGuarantee(loginVO.getId(), companyId)) {
            personList = guaranteeService.findPeronByCompanyId(companyId);
            return "guaranteePersonListResult";
        } else {
            return "error";
        }
    }

    @Before
    public String checkPermission() {
        LoginVO loginVO = getLoginVO();
        if (loginVO == null) {
            return errorJSON("请登录");
        }
        if (loginVO.getUserType() == UserType.COMPANY || loginVO.getUserType() == UserType.STORE) {
            return errorJSON("没有权限");
        }
        return null;
    }

    @Override
    protected boolean needLogin() {
        return true;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public List<PersonInfo> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonInfo> personList) {
        this.personList = personList;
    }
}