package com.car.training.action.website;

import com.car.training.bean.Autobot;
import com.car.training.bean.Trainer;
import com.car.training.service.AutobotService;
import com.car.training.service.TrainerService;
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
    private AutobotService autobotService;

    private Autobot autobot;

    private List<Trainer> trainerList;

    private int autobotId;

    /**
     * 朋友圈汽车人列表
     */
    private List<Autobot> autobotsList;

    @Override
    public String execute(){
        autobot = autobotService.findById(autobotId);

        if (autobot == null) {
            setTargetUrl("/website/index");
            return REDIRECT;
        }

//        for (String strId : autobots.getAttentionTrainer().split(",")) {
//            if (StringUtils.isNotBlank(strId)) {
//                Trainer trainer = trainerService.findById(strId);
//                if (trainer != null) {
//                    listTrainer.add(trainer);
//                }
//            }
//        }
//        autobots.setAttentionTrainerList(listTrainer);
//        //朋友圈
//        autobotsList = autobotsService.findByIndexPromoted(true, 6);
        return SUCCESS;
    }

    public Autobot getAutobot() {
        return autobot;
    }

    public void setAutobot(Trainer trainer) {
        this.autobot = autobot;
    }

    public void setAutobotId(int autobotId) {
        this.autobotId = autobotId;
    }

    public int getAutobotId() {
        return autobotId;
    }
}
