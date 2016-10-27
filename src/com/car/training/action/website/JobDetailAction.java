package com.car.training.action.website;

import com.car.training.domain.Company;
import com.car.training.domain.DeliveryResume;
import com.car.training.domain.Jobs;
import com.car.training.domain.UserCenter;
import com.car.training.service.CompanyService;
import com.car.training.service.DeliveryResumeService;
import com.car.training.service.JobsService;
import com.car.training.service.UserCenterService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@AutoConfig
public class JobDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private JobsService jobsService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserCenterService userCenterService;
    @Autowired
    private DeliveryResumeService deliveryResumeService;

    private Jobs jobs;

    private String jid;

    private String cid;

    private Object data;

    /**
     * 其他职位
     */
    private List<Jobs> jobsOtherList;
    private List<UserCenter> bondsmanList;

    @Override
    public String execute() throws Exception {
        Jobs t = new Jobs();
        if (jobs != null && StringUtils.isNotBlank(jobs.getId())) {
            t.setId(jobs.getId());
        }
        jobs = jobsService.findById(t.getId());
        if (jobs != null && jobs.getCompany() != null && StringUtils.isNotBlank(jobs.getCompany().getBondsman())) {
            bondsmanList = new ArrayList<UserCenter>();
            for (String strId : jobs.getCompany().getBondsman().split(",")) {
                if (StringUtils.isNotBlank(strId)) {
                    UserCenter uc = userCenterService.findById(strId);
                    if (uc != null) {
                        bondsmanList.add(uc);
                    }
                }
            }
        }
        jobsOtherList = jobsService.findListByJobs(jobs);

        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String apply() {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        Map<String, Object> map = new HashMap<String, Object>();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        if (uc == null) {
            map.put("code", 400);
            map.put("msg", "您还没有登陆，不能申请！");
        } else {
            Jobs jobs = new Jobs();
            if (jobs != null && StringUtils.isNotBlank(jid)) {
                jobs = jobsService.findById(jid);

                DeliveryResume dr = new DeliveryResume();

                dr.setAutobots(uc.getAutobot());
                dr.setTrainer(uc.getTrainer());
                dr.setCreateDate(new Date());
                dr.setJobs(jobs);
                dr.setEnabled(true);
                deliveryResumeService.save(dr);
                map.put("code", 200);
                map.put("msg", "注册成功！");
            }
        }
        setData(map);
        return JSON;
    }

    @JsonConfig(root = "data")
    public String bondsman() {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        Map<String, Object> map = new HashMap<String, Object>();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        Company company = companyService.findById(cid);
        if (company != null) {
            String bonds = company.getBondsman();
            if (StringUtils.isNotBlank(bonds)) {
                if (bonds.contains(uc.getId())) {
                    map.put("code", 400);
                    map.put("msg", "您已经是该公司的担保人！");
                    setData(map);
                    return JSON;
                } else {
                    company.setBondsman(bonds.concat(",").concat(uc.getId()));
                }
            } else {
                company.setBondsman(uc.getId());
            }
            company.setBondsmanCount(company.getBondsmanCount() + 1);
            companyService.update(company);
            map.put("code", 200);
            map.put("msg", "担保成功！");
        }
        setData(map);
        return JSON;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<Jobs> getJobsOtherList() {
        return jobsOtherList;
    }

    public void setJobsOtherList(List<Jobs> jobsOtherList) {
        this.jobsOtherList = jobsOtherList;
    }

    public List<UserCenter> getBondsmanList() {
        return bondsmanList;
    }

    public void setBondsmanList(List<UserCenter> bondsmanList) {
        this.bondsmanList = bondsmanList;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
