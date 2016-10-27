package com.car.training.action.backend;

import com.car.training.domain.DeliveryResume;
import com.car.training.service.DeliveryResumeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@AutoConfig
public class ApplyJobHistoryAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private DeliveryResumeService deliveryResumeService;
    /**
     * 简历投递记录列表
     */
    private ResultPage<DeliveryResume> deliveryResumeList;
    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 页号
     */
    private Integer pageNo = 1;
    private String ids;
    private Object data;

    @Override
    public String execute() throws Exception {
        deliveryResumeList = deliveryResumeService.findPageByDeliveryResume(new DeliveryResume(), pageSize, pageNo);
        return SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String did = request.getParameter("dr.id");
        deliveryResumeService.delete(did);
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String delall() throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            String[] arr = ids.split(",");
            for (String s : arr) {
                if (StringUtils.isNotBlank(s)) {
                    deliveryResumeService.delete(s);
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        setData(map);
        return JSON;
    }

    public ResultPage<DeliveryResume> getDeliveryResumeList() {
        return deliveryResumeList;
    }

    public void setDeliveryResumeList(ResultPage<DeliveryResume> deliveryResumeList) {
        this.deliveryResumeList = deliveryResumeList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
