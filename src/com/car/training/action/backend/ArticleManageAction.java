package com.car.training.action.backend;

import com.car.training.domain.Trainer;
import com.car.training.domain.TrainerEssay;
import com.car.training.domain.UserCenter;
import com.car.training.service.TrainerEssayService;
import com.car.training.service.TrainerService;
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
public class ArticleManageAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerEssayService trainerEssayService;
    @Autowired
    private TrainerService trainerService;
    /**
     * 文章列表
     */
    private ResultPage<TrainerEssay> trainerEssayList;
    /**
     * 文章
     */
    private TrainerEssay trainerEssay;
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
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        Trainer trainer = null;
        if (uc != null) {
            trainer = trainerService.findByUserCenter(uc.getId());
        }
        TrainerEssay essay = new TrainerEssay();
        essay.setTrainer(trainer);
        trainerEssayList = trainerEssayService.findPageByTrainerEssay(new TrainerEssay(), pageSize, pageNo);
        return SUCCESS;
    }

    /**
     * 文章新增&編輯
     */
    public String essaySave() throws Exception {
        trainerEssayService.save(trainerEssay);
        return SUCCESS;
    }

    /**
     * 文章删除
     */
    public String essayDelete() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String eid = request.getParameter("trainerEssay.id");
        trainerEssayService.delete(eid);
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String delall() throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            String[] arr = ids.split(",");
            for (String s : arr) {
                if (StringUtils.isNotBlank(s)) {
                    trainerEssayService.delete(s);
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        setData(map);
        return JSON;
    }

    public ResultPage<TrainerEssay> getTrainerEssayList() {
        return trainerEssayList;
    }

    public void setTrainerEssayList(ResultPage<TrainerEssay> trainerEssayList) {
        this.trainerEssayList = trainerEssayList;
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

    public TrainerEssay getTrainerEssay() {
        return trainerEssay;
    }

    public void setTrainerEssay(TrainerEssay trainerEssay) {
        this.trainerEssay = trainerEssay;
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
