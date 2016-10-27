package com.car.training.action.website;

import com.car.training.domain.*;
import com.car.training.enums.CompanyType;
import com.car.training.enums.UserType;
import com.car.training.exceptions.NotFoundException;
import com.car.training.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.event.EventPublisher;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.spring.security.DefaultLogoutSuccessHandler;
import org.ironrhino.core.spring.security.DefaultUsernamePasswordAuthenticationFilter;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AutoConfig
public class IndexAction extends BaseAction {

    private static final long serialVersionUID = 2048090665437672391L;
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
    /**
     * 用户类型
     */
    protected UserType userType;
    protected String password;
    protected String username;
    @Autowired
    private JobsService jobsService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private AutobotsService autobotsService;
    @Autowired
    private TrainerEssayService trainerEssayService;
    @Autowired
    private transient CaptchManager captchManager;
    /**
     * 首页推荐培训师大图
     */
    private Trainer trainer;
    /**
     * 首页推荐8个培训师列表
     */
    private List<Trainer> trainerList;
    /**
     * 首页推荐5个汽车人列表
     */
    private List<Autobots> autobotsList;
    /**
     * 首页2个培训需求列表
     */
    private List<Jobs> jobsTrainerList;
    /**
     * 首页2个汽车人才需求列表
     */
    private List<Jobs> jobsAutobotsList;
    /**
     * 首页培训师原创文章列表
     */
    private List<TrainerEssay> trainerEssayList;
    /**
     * 首页培训学热点专题列表
     */
    private List<Topic> topicList;
    /**
     * 首页2个公开课列表
     */
    private List<Courses> coursesList;
    private String vercode;

    private String loginState = "N";

    private String captcha;

    private Object data;

    @Override
    public String execute() throws Exception {
        //首页推荐培训师大图1个
        trainer = trainerService.findByIndexPromoted(true);
        //首页推荐培训师最上顶8位置
        trainerList = trainerService.findByIndexPromoted(true, 8);
        //首页推荐汽车人5个位置
        autobotsList = autobotsService.findByIndexPromoted(true, 5);
        //首页培训师需求2个位置
        jobsTrainerList = jobsService.findListByIndexType(CompanyType.COMPANY, 2);
        //首页汽车人才需求2个位置
        jobsAutobotsList = jobsService.findListByIndexType(CompanyType.STORE, 2);
        //首页培训师原创文章列表6个位置
        trainerEssayList = trainerEssayService.findByIndexPromoted(true, 6);
        //首页热点专题列表6个位置
        topicList = topicService.findListByIndexTopic(6);
        //首页推荐公开课列表2个位置
        coursesList = coursesService.findByIndexPromoted(true, 2);

        return SUCCESS;
    }

    /**
     * 用户登陆
     *
     * @author season
     */
    @JsonConfig(root = "data")
    public String login() {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter usercenter = null;
        Company company = null;
        if (StringUtils.isBlank(username)) {
            throw new NotFoundException("1001", "用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            throw new NotFoundException("1002", "密码不能为空");
        }

        if (userType == null) {
            throw new NotFoundException("1004", "请选择用户类型");
        }
        if (userType.equals(UserType.PERSONAL)) {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                usercenter = usercenterService.findByUsernamePassword(username, password);
                if (usercenter != null) {
                    HttpSession context = request.getSession();
                    Autobots autobots = autobotsService.findByUserCenter(usercenter.getId());
                    if (autobots != null) {
                        usercenter.setAutobot(autobots);
                    }
                    Trainer trainer = trainerService.findByUserCenter(usercenter.getId());
                    if (trainer != null) {
                        usercenter.setTrainer(trainer);
                    }
                    context.setAttribute("userDetails", usercenter);
                    targetUrl = "/website/index";
                    request.getSession().setAttribute("loginState", "Y");
                    request.getSession().setAttribute("loginType", usercenter.getPersonalType().name());
                    map.put("code", 200);
                    map.put("target", targetUrl);
                    map.put("msg", "登陆成功！");
                } else {
                    map.put("code", 400);
                    map.put("msg", "您的账号或密码错误！");
                }
            }
        } else if (userType.equals(UserType.COMPANY)) {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                company = companyService.findByUsernamePassword(username, password);
                if (company != null) {
                    HttpSession context = request.getSession();
                    context.setAttribute("userDetails", company);
                    targetUrl = "/website/index";
                    request.getSession().setAttribute("loginState", "Y");
                    request.getSession().setAttribute("loginType", company.getCompanyType().name());
                    map.put("code", 200);
                    map.put("target", targetUrl);
                    map.put("msg", "登陆成功！");
                } else {
                    map.put("code", 400);
                    map.put("msg", "您的账号或密码错误！");
                }
            }
        }
        setData(map);
        return JSON;
    }


    /**
     * 用户登出
     */
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

    @JsonConfig(root = "data")
    public String sendMsg() {
        Map<String, Object> map = new HashMap<String, Object>();

        String sid = ServletActionContext.getRequest().getSession().getId();

        if (!captchManager.volidateCode(sid, captcha)) {
            map.put("code", 400);
            map.put("msg", "验证码填写错误");
            this.setData(map);
        }

        return JSON;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public List<Autobots> getAutobotsList() {
        return autobotsList;
    }

    public List<Jobs> getJobsTrainerList() {
        return jobsTrainerList;
    }

    public List<Jobs> getJobsAutobotsList() {
        return jobsAutobotsList;
    }

    public List<TrainerEssay> getTrainerEssayList() {
        return trainerEssayList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public String getLoginState() {
        return loginState;
    }

    public void setLoginState(String loginState) {
        this.loginState = loginState;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
