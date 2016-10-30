package com.car.training.action.backend;

import com.car.training.domain.Trainer;
import com.car.training.domain.TrainerEssay;
import com.car.training.domain.UserCenter;
import com.car.training.service.TrainerEssayService;
import com.car.training.service.TrainerService;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AutoConfig
public class PublishArticleAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerEssayService trainerEssayService;
    @Autowired
    private TrainerService trainerService;
    /**
     * 培训师文章
     */
    private TrainerEssay trainerEssay;
    private Trainer trainer;
    private Object data;

    private String title;
    private String content;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        if (uc != null) {
            trainer = trainerService.findByUserCenter(uc.getId());
        }
        return SUCCESS;
    }

    /**
     * 文章新增&編輯
     */
    @JsonConfig(root = "data")
    public String save() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        Trainer trainer = null;
        if (uc != null) {
            trainer = trainerService.findByUserCenter(uc.getId());
        }
        TrainerEssay essay = new TrainerEssay();
        essay.setTitle(title);
        essay.setContent(content);
        essay.setPublishDate(new Date());
        essay.setCreateDate(new Date());
        essay.setEnabled(true);
        essay.setPromoted(true);
        essay.setTrainer(trainer);
        trainerEssayService.save(essay);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        setData(map);
        return JSON;
    }

    public TrainerEssay getTrainerEssay() {
        return trainerEssay;
    }


    public void setTrainerEssay(TrainerEssay trainerEssay) {
        this.trainerEssay = trainerEssay;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
