package com.car.training.action.website;

import com.car.training.domain.TrainerEssay;
import com.car.training.service.TrainerEssayService;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;


@AutoConfig
public class TrainerEssayDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerEssayService trainerEssayService;

    private TrainerEssay trainerEssay;

    @Override
    public String execute() throws Exception {
        TrainerEssay t = new TrainerEssay();
        if (trainerEssay != null && StringUtils.isNotBlank(trainerEssay.getId())) {
            t.setId(trainerEssay.getId());
        }
        trainerEssay = trainerEssayService.findById(t.getId());

        return SUCCESS;
    }

    public TrainerEssay getTrainerEssay() {
        return trainerEssay;
    }

    public void setTrainerEssay(TrainerEssay trainerEssay) {
        this.trainerEssay = trainerEssay;
    }

}
