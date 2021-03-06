package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Autobot;
import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.Trainer;
import com.car.training.service.CommentService;
import com.car.training.service.GuaranteeService;
import com.car.training.service.LikeService;
import com.car.training.service.PromotionService;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Controller
@AutoConfig
public class IndexAction extends SimpleAction {

    private static final long serialVersionUID = 2048090665437672391L;

    @Autowired
    PromotionService promotionService;

    @Autowired
    private LikeService likeService;


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
     * //
     */
    private List<Autobot> autobotList;

    private HashMap<Object, Integer> likeNumberMap = new HashMap<>();

    private HashMap<Object, Boolean> isLikeMap = new HashMap<>();
    private List<Job> autobotJobList;
    private List<Job> trainerJobList;

    private GuaranteeService guaranteeService;
    private HashMap<Object, Integer> guaranteeNumberMap = new HashMap<>();

    private CommentService commentService;
    private HashMap<Object, Integer> commentNumberMap = new HashMap<>();


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
    public String execute() {
        promotionService.checkUpdate();
        //首页推荐培训师10个
        trainerList = promotionService.getTopTrainer(12);

        //首页推荐汽车人5个位置
        autobotList = promotionService.getTopAutobot(12);

        //首页培训师需求2个位置
        trainerJobList = promotionService.getTopTrainerJob(4);
        //首页汽车人才需求2个位置
        autobotJobList = promotionService.getTopAutobotJob(4);
//        //首页培训师原创文章列表6个位置
//        trainerEssayList = trainerEssayService.findByIndexPromoted(true, 6);
//        //首页热点专题列表6个位置
//        topicList = topicService.findListByIndexTopic(6);
//        //首页推荐公开课列表2个位置
//        coursesList = coursesService.findByIndexPromoted(true, 2);
        generateLikeAndCommentMap();
        generateGuaranteeMap();
        return SUCCESS;
    }

    private void generateLikeAndCommentMap() {
        int uid;
        LoginVO loginVO = getLoginVO();
        if (trainerList != null) {
            for (Trainer trainer : trainerList) {
                uid = trainer.getLoginUser().getId();
                likeNumberMap.put(trainer, likeService.likeNumber(uid));
                commentNumberMap.put(trainer, commentService.commentNumber(uid));
                if (loginVO != null) {
                    isLikeMap.put(trainer, likeService.isLike(loginVO.getId(), uid));
                }
            }
        }
        if (autobotList != null) {
            for (Autobot autobot : autobotList) {
                uid = autobot.getLoginUser().getId();
                likeNumberMap.put(autobot, likeService.likeNumber(uid));
                commentNumberMap.put(autobot, commentService.commentNumber(uid));
                if (loginVO != null) {
                    isLikeMap.put(autobot, likeService.isLike(loginVO.getId(), uid));
                }
            }
        }
    }

    private void generateGuaranteeMap() {
        HashSet<Company> companySet = new HashSet<>();

        for (Job job : trainerJobList) {
            if (job.getCompany() != null) {
                companySet.add(job.getCompany());
            }
        }
        for (Job job : autobotJobList) {
            if (job.getCompany() != null) {
                companySet.add(job.getCompany());
            }
        }

        for (Company company : companySet) {
            guaranteeNumberMap.put(company, guaranteeService.guaranteeNumber(company.getId()));
        }
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

    public HashMap<Object, Integer> getLikeNumberMap() {
        return likeNumberMap;
    }

    public void setLikeNumberMap(HashMap<Object, Integer> likeNumberMap) {
        this.likeNumberMap = likeNumberMap;
    }


    public HashMap<Object, Boolean> getIsLikeMap() {
        return isLikeMap;
    }

    public void setIsLikeMap(HashMap<Object, Boolean> isLikeMap) {
        this.isLikeMap = isLikeMap;
    }

    public List<Job> getAutobotJobList() {
        return autobotJobList;
    }

    public void setAutobotJobList(List<Job> autobotJobList) {
        this.autobotJobList = autobotJobList;
    }

    public List<Job> getTrainerJobList() {
        return trainerJobList;
    }

    public void setTrainerJobList(List<Job> trainerJobList) {
        this.trainerJobList = trainerJobList;
    }

    public GuaranteeService getGuaranteeService() {
        return guaranteeService;
    }

    public void setGuaranteeService(GuaranteeService guaranteeService) {
        this.guaranteeService = guaranteeService;
    }

    public HashMap<Object, Integer> getGuaranteeNumberMap() {
        return guaranteeNumberMap;
    }

    public void setGuaranteeNumberMap(HashMap<Object, Integer> guaranteeNumberMap) {
        this.guaranteeNumberMap = guaranteeNumberMap;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public HashMap<Object, Integer> getCommentNumberMap() {
        return commentNumberMap;
    }

    public void setCommentNumberMap(HashMap<Object, Integer> commentNumberMap) {
        this.commentNumberMap = commentNumberMap;
    }
}
