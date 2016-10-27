package com.car.training.action.backend;

import com.car.training.domain.DeliveryResume;
import com.car.training.domain.Jobs;
import com.car.training.service.DeliveryResumeService;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AutoConfig
public class DeliveredAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private DeliveryResumeService deliveryResumeService;
    /**
     * 简历投递记录列表
     */
    private List<DeliveryResume> deliveryResumeList;


    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String jid = request.getParameter("jobs.id");
        DeliveryResume deliveryResume = new DeliveryResume();
        Jobs job = new Jobs();
        job.setId(jid);
        deliveryResume.setJobs(job);
        deliveryResumeList = deliveryResumeService.findListByDeliveryResume(deliveryResume);
        return SUCCESS;
    }


    public List<DeliveryResume> getDeliveryResumeList() {
        return deliveryResumeList;
    }


    public void setDeliveryResumeList(List<DeliveryResume> deliveryResumeList) {
        this.deliveryResumeList = deliveryResumeList;
    }


}
