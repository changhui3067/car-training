package com.car.training.action.website;

import com.car.training.bean.Autobot;
import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.Trainer;
import com.car.training.service.GuaranteeService;
import com.car.training.service.LikeService;
import com.car.training.service.PromotionService;
import com.car.training.vo.LoginVO;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@AutoConfig
public class IndexAction extends BaseAction {

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

    private Company company;
    private List<Company> companyList;
    private GuaranteeService guaranteeService;
    private HashMap<Object, Integer> guaranteeNumberMap = new HashMap<>();
    private HashMap<Object, Boolean> isGuaranteeMap = new HashMap<>();


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
        //首页推荐培训师大图1个
        List<Trainer> topTrainers = promotionService.getTopTrainer(9);

        if (topTrainers.size() > 0) {
            trainer = topTrainers.get(0);
        }

        if (topTrainers.size() > 1) {
            trainerList = topTrainers.subList(1, topTrainers.size());
        }


        //首页推荐培训师最上顶8位置
        if (topTrainers.size() > 1) {
            trainerList = topTrainers.subList(1, topTrainers.size() - 1);
        }

        generateLikeMap(topTrainers);

        //首页推荐汽车人5个位置
        autobotList = promotionService.getTopAutobot(5);

        //首页培训师需求2个位置
        trainerJobList = promotionService.getTopTrainerJob(2);
        //首页汽车人才需求2个位置
        autobotJobList = promotionService.getTopAutobotJob(2);
//        //首页培训师原创文章列表6个位置
//        trainerEssayList = trainerEssayService.findByIndexPromoted(true, 6);
//        //首页热点专题列表6个位置
//        topicList = topicService.findListByIndexTopic(6);
//        //首页推荐公开课列表2个位置
//        coursesList = coursesService.findByIndexPromoted(true, 2);
        ArrayList<Company> companyList = new ArrayList<Company>();
        for (Job job : trainerJobList) {
            companyList.add(job.getCompany());
        }
        for (Job job : autobotJobList) {
            companyList.add(job.getCompany());
        }
        generateGuaranteeMap(companyList);

        return SUCCESS;
    }

    private void generateLikeMap(List<Trainer> topTrainers) {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
        if (topTrainers != null) {
            for (Trainer trainer : topTrainers) {
                likeNumberMap.put(trainer, likeService.likeNumber(trainer.getId()));
                if (loginVO != null) {
                    isLikeMap.put(trainer, likeService.isLike(loginVO.getId(), trainer.getId()));
                }
            }
        }
    }

    private void generateGuaranteeMap(List<Company> companyList) {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
        if (companyList != null) {
            for (Company company : companyList) {
                guaranteeNumberMap.put(company, guaranteeService.guaranteeNumber(company.getId()));
                if (loginVO != null) {
                    isGuaranteeMap.put(company, guaranteeService.isGuarantee(loginVO.getId(), company.getId()));
                }
            }
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
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

    public HashMap<Object, Boolean> getIsGuaranteeMap() {
        return isGuaranteeMap;
    }

    public void setIsGuaranteeMap(HashMap<Object, Boolean> isGuaranteeMap) {
        this.isGuaranteeMap = isGuaranteeMap;
    }
}
