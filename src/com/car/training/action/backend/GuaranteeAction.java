package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.PersonInfo;
import com.car.training.enums.UserType;
import com.car.training.service.GuaranteeService;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
		if (guaranteeService.guarantee(loginVO.getId(),companyId)) {
			personList = guaranteeService.findPeronByCompanyId(companyId);
            return "guaranteePersonListResult";
        } else {
            return "error";
        }
	}

	public String unGuarantee() {
		if (guaranteeService.unGuarantee(loginVO.getId(),companyId)) {
			personList = guaranteeService.findPeronByCompanyId(companyId);
            return "guaranteePersonListResult";
        } else {
            return "error";
        }
	}

	@Before
	public String beforeAction() {
        loginVO = (LoginVO) getHttpSession().getAttribute("loginVO");
        if (loginVO == null){
            return errorJSON("User not logged in");
        }
        return null;
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