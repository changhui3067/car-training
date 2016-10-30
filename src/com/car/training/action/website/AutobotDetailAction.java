package com.car.training.action.website;

import com.car.training.domain.Autobots;
import com.car.training.domain.Trainer;
import com.car.training.service.AutobotsService;
import com.car.training.service.TrainerService;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@AutoConfig
public class AutobotDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private AutobotsService autobotsService;

    private Autobots autobots;

    private List<Trainer> listTrainer;

    /**
     * 朋友圈汽车人列表
     */
    private List<Autobots> autobotsList;

    @Override
    public String execute() throws Exception {
        Autobots t = new Autobots();
        if (autobots != null && StringUtils.isNotBlank(autobots.getId())) {
            t.setId(autobots.getId());
        }
        autobots = autobotsService.findById(t.getId());
        if (autobots != null && StringUtils.isNotBlank(autobots.getAttentionTrainer())) {
            for (String strId : autobots.getAttentionTrainer().split(",")) {
                if (StringUtils.isNotBlank(strId)) {
                    Trainer trainer = trainerService.findById(strId);
                    if (trainer != null) {
                        listTrainer.add(trainer);
                    }
                }
            }
            autobots.setAttentionTrainerList(listTrainer);
        }
        //朋友圈
        autobotsList = autobotsService.findByIndexPromoted(true, 6);
        return SUCCESS;
    }

    public Autobots getAutobots() {
        return autobots;
    }

    public void setAutobots(Autobots autobots) {
        this.autobots = autobots;
    }

    public List<Trainer> getListTrainer() {
        return listTrainer;
    }

    public void setListTrainer(List<Trainer> listTrainer) {
        this.listTrainer = listTrainer;
    }

    public List<Autobots> getAutobotsList() {
        return autobotsList;
    }

    public void setAutobotsList(List<Autobots> autobotsList) {
        this.autobotsList = autobotsList;
    }

}
