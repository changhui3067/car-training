package com.car.training.action.website;

import com.car.training.bean.Autobot;
import com.car.training.bean.Trainer;
import com.car.training.service.PromotionService;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AutoConfig
public class IndexAction extends BaseAction {

    private static final long serialVersionUID = 2048090665437672391L;

    @Autowired
    PromotionService promotionService;

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
//     */
    private List<Autobot> autobotList;
//    /**
//     * 首页2个培训需求列表
//     */
//    private List<Job> jobsTrainerList;
//    /**
//     * 首页2个汽车人才需求列表
//     */
//    private List<Job> jobsAutobotsList;
//    /**
//     * 首页培训师原创文章列表
//     */
//    private List<TrainerEssay> trainerEssayList;
//    /**
//     * 首页培训学热点专题列表
//     */
//    private List<Topic> topicList;
//    /**
//     * 首页2个公开课列表
//     */
//    private List<Courses> coursesList;
//
//    @Autowired
//    PromotionService promotionService;

    @Override
    public String execute(){
        //首页推荐培训师大图1个
        List<Trainer> topTrainers = promotionService.getTopTrainer(9);

        if (topTrainers.size() > 0) {
            trainer = topTrainers.get(0);
        }

        if (topTrainers.size() > 1) {
            trainerList = topTrainers.subList(1,topTrainers.size());
        }



        //首页推荐培训师最上顶8位置
        if (topTrainers.size() > 1) {
            trainerList = topTrainers.subList(1, topTrainers.size() - 1);
        }
        //首页推荐汽车人5个位置
        autobotList = promotionService.getTopAutobot(5);
//        //首页培训师需求2个位置
//        jobsTrainerList = jobsService.findListByIndexType(CompanyType.COMPANY, 2);
//        //首页汽车人才需求2个位置
//        jobsAutobotsList = jobsService.findListByIndexType(CompanyType.STORE, 2);
//        //首页培训师原创文章列表6个位置
//        trainerEssayList = trainerEssayService.findByIndexPromoted(true, 6);
//        //首页热点专题列表6个位置
//        topicList = topicService.findListByIndexTopic(6);
//        //首页推荐公开课列表2个位置
//        coursesList = coursesService.findByIndexPromoted(true, 2);

        return SUCCESS;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }

    public List<Autobot> getAutobotList() {
        return autobotList;
    }

    public void setAutobotList(List<Autobot> autobotList) {
        this.autobotList = autobotList;
    }
}
