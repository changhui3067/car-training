package com.car.training.action.backend;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.event.EventPublisher;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.spring.security.DefaultLogoutSuccessHandler;
import org.ironrhino.core.spring.security.DefaultUsernamePasswordAuthenticationFilter;
import org.ironrhino.core.struts.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.car.training.domain.Company;
import com.car.training.domain.UserCenter;
import com.car.training.enums.CompanyType;
import com.car.training.enums.PersonalType;
import com.car.training.enums.UserType;
import com.car.training.exceptions.NotFoundException;
import com.car.training.service.CompanyService;
import com.car.training.service.UserCenterService;
import com.car.training.sms.SmsManager;
import com.car.training.sms.SmsTemplate;

@AutoConfig
@Order(0)
public class RegisterAction extends BaseAction {

	private static final long serialVersionUID = 7654848347188004593L;

	protected static Logger log = LoggerFactory.getLogger(RegisterAction.class);
	
	protected UserType userType;
	
	protected PersonalType personalType;
	
	protected CompanyType companyType;

	protected String password;
	
	protected String comfirmPassword;

	protected String username;

	private String vercode;

	private Object data;

	private String captcha;

	@Autowired
	private SmsManager smsManager;
	@Autowired
	protected transient UserCenterService usercenterService;
	@Autowired
	protected transient CompanyService companyService;
	@Autowired
	protected transient DefaultUsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

	@Autowired
	protected transient DefaultLogoutSuccessHandler defaultLogoutSuccessHandler;

	@Autowired
	protected transient EventPublisher eventPublisher;

	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	

	public String getComfirmPassword() {
		return comfirmPassword;
	}

	public void setComfirmPassword(String comfirmPassword) {
		this.comfirmPassword = comfirmPassword;
	}

	public PersonalType getPersonalType() {
		return personalType;
	}

	public void setPersonalType(PersonalType personalType) {
		this.personalType = personalType;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	@JsonConfig(root = "data")
	public String register() {
		Map<String, Object> map = new HashMap<String, Object>();

		if (StringUtils.isBlank(username)) {
			throw new NotFoundException("1001","用户名不能为空");
		}
		if (StringUtils.isBlank(password)) {
			throw new NotFoundException("1002","密码不能为空");
		}
		if (StringUtils.isBlank(vercode)) {
			throw new NotFoundException("1003","验证码不能为空");
		}
		if (userType==null) {
			throw new NotFoundException("1004","请选择用户类型");
		}
		
		if (userType.equals(UserType.PERSONAL)) {
			UserCenter usercenter = usercenterService.findByUsername(username);
			if (usercenter == null) {
				if (smsManager.checkCode(username, vercode)) {
					usercenter = new UserCenter();
					usercenter.setUsername(username);
					usercenter.setPassword(password);
					usercenter.setActiveDate(new Date());
					usercenter.setMobile(username);
					usercenter.setPersonalType(personalType);
					Region region = new Region();
					region.setId(new Long(0L));
					usercenter.setRegion(region);
					usercenterService.save(usercenter);
					map.put("code", 200);
					map.put("msg", "注册成功！");
				} else {
					map.put("code", 402);
					map.put("msg", "手机验证码错误！");
				}
			} else {
				map.put("code", 405);
				map.put("msg", "用户名已存在！");
			}
		}else if(userType.equals(UserType.COMPANY)){
			Company 	company = companyService.findByUsername(username);
			if (company == null) {
				if (smsManager.checkCode(username, vercode)) {
					company = new Company();
					company.setUsername(username);
					company.setPassword(password);
					company.setCompanyType(companyType);
					companyService.save(company);
					map.put("code", 200);
					map.put("msg", "注册成功！");
				} else {
					map.put("code", 402);
					map.put("msg", "手机验证码错误！");
				}
			} else {
				map.put("code", 405);
				map.put("msg", "用户名已存在！");
			}
		}
		setData(map);
		return JSON;
	}

	/** 用户登出 */
	@JsonConfig(root = "data")
	public String logout() {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("loginState", "N");
		map.put("code", 200);
		map.put("msg", "退出成功");
		setData(map);
		return JSON;
	}

	@Override
	public String execute() {
//		if (StringUtils.isBlank(targetUrl))
//			if (userType.equals(UserType.COMPANY)) {
//				targetUrl = "/website/backend/companyJobManger";
//			} else if (userType.equals(UserType.COMPANY)) {
//				targetUrl = "/website/backend/companyJobManger";
//			}
		return SUCCESS;
	}

	@JsonConfig(root = "data")
	public String sendmsg() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (username == null) {
			throw new NotFoundException("1001", "手机账号不能为空");
		}
		if (userType.equals(UserType.PERSONAL)) {
			UserCenter usercenter = usercenterService.findByUsername(username);
			if (usercenter == null) {
				try {
					smsManager.send(username, SmsTemplate.REGISTER);
					map.put("code", 200);
					map.put("msg", "手机验证码发送成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				map.put("code", 400);
				map.put("msg", "手机账号已注册！");
			}
		}else if(userType.equals(UserType.COMPANY)){
			Company company = companyService.findByUsername(username);
			if (company == null) {
				try {
					smsManager.send(username, SmsTemplate.REGISTER);
					map.put("code", 200);
					map.put("msg", "手机验证码发送成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else{
			map.put("code", 400);
			map.put("msg", "手机账号已注册！");
			}
		}
		setData(map);
		return JSON;
	}
}
