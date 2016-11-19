package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
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

@AutoConfig
public class GuaranteeAction extends SimpleAction {
	private int companyId;

	@Autowired
	private GuaranteeService guaranteeService;

	private HttpSession session;

	private LoginVO loginVO;

	@JsonConfig(root="data")
	public String guarantee() {
		if (guaranteeService.guarantee(loginVO.getId(),companyId)) {
            return successJSON();
        } else {
            return errorJSON("");
        }
	}

	@JsonConfig(root="data")
	public String unGuarantee() {
		if (guaranteeService.unGuarantee(loginVO.getId(),companyId)) {
            return successJSON();
        } else {
            return errorJSON("");
        }
	}

	@Before
	public String beforeAction() {
		HttpServletRequest request = ServletActionContext.getRequest();
        session = request.getSession();
        loginVO = (LoginVO) session.getAttribute("loginVO");
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

}