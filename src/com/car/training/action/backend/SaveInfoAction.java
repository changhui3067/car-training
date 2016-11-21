package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.*;
import com.car.training.enums.ReactTime;
import com.car.training.service.AutobotService;
import com.car.training.service.CommentService;
import com.car.training.service.CompanyService;
import com.car.training.service.TrainerService;
import com.car.training.utils.BeanOperation;
import com.car.training.utils.FileUploaderUtil;
import com.car.training.utils.RegionUtils;
import com.car.training.vo.LoginVO;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bill on 11/20/16.
 */
public class SaveInfoAction extends SimpleAction {

    @Autowired
    private LoginVO loginVO;

    @Autowired
    BeanOperation beanOperation;

    @Autowired
    private AutobotService autobotService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FileUploaderUtil fileUploaderUtil;

    @Autowired
    private RegionUtils regionUtils;


    @Override
    @JsonConfig(root = "data")
    public String execute() throws Exception {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(loginVO.getId());
        switch (loginVO.getUserType()) {
            case AUTOBOT:
                autobot = autobotService.findByLoginUser(loginUser);
                return saveAutobot();
            case TRAINER:
                trainer = trainerService.findByLoginUser(loginUser);
                return saveTrainer();
            case COMPANY:
            case STORE:
                company = companyService.findByLoginUser(loginUser);
                return saveCompany();
            default:
                return errorJSON("wrong user type");
        }
    }

    private String saveAutobot() {
        beanOperation.setValue(this, autobot, autobotProps);
        autobot.setBusinessCategory(getCategories(businessCategory));
        savePersonInfo(autobot.getPersonInfo());
        autobotService.save(autobot);
        return successJSON();
    }

    private String saveTrainer() {
        beanOperation.setValue(this, trainer, trainerProps);
        trainer.setBusinessCategory(getCategories(businessCategory));
        trainer.setExecutionCategory(getCategories(executionCategory));
        savePersonInfo(trainer.getPersonInfo());

        return successJSON();
    }

    private void savePersonInfo(PersonInfo personInfo) {
        avatarUrl = fileUploaderUtil.uploadImg(avatarUrl);
        region = regionUtils.getRegionById(regionId);
        beanOperation.setValue(this, personInfo, personProps);
        personInfo.setBirthday(new Date());
    }

    private String saveCompany() {
        logoUrl = fileUploaderUtil.uploadImg(logoUrl);
        photoUrl =  fileUploaderUtil.uploadImg(photoUrl);
        region = regionUtils.getRegionById(regionId);
        company.setBusinessCategory(getCategories(businessCategory));
        beanOperation.setValue(this, company, companyProps);
        return successJSON();
    }


    private Autobot autobot;
    private Trainer trainer;
    private Company company;

    //personInfo fields
    private String avatarUrl;
    private int regionId = -1;
    private Region region;
    private String name;
    private String birthday;
    private String email;
    private String marriageStatus;
    private String mobile;

    //autobotProps
    private String workingStatus;
    private int autoYears;
    private String autoBrand;
    private String certRecords;
    private String workingHistory;
    private String currentPosition;
    private String trainingHistory;
    private String education;

    private String businessCategory;


    //trainerProps
//    private String currentPosition;
//    private String education;
    private String executionCategory;
//    private String businessCategory;
//    private int autoYears;
//    private String introduction;
    private String mainCourse;
    private String videoUrl1;
    private String videoUrl2;

//companyProps
//  "name",
    private String address;
//  "region",
    private String logoUrl;
    private String scale;
    private String introduction;
    private ReactTime reactTime;
    private Welfare welfare;
//  "businessCategory",
    private String photoUrl;

    private Set<String> getCategories(String categoryString) {
        Set<String> categories = new HashSet<>();
        if (!StringUtils.isEmpty(categoryString)) {
            Collections.addAll(categories, categoryString.split(","));
        }
        return categories;
    }


    //CompanyProps

    private final static String[] autobotProps = new String[]{
            "workingStatus",
            "autoYears",
            "autoBrand",
//            "businessCategory",
            "certRecords",
            "workingHistory",
            "currentPosition",
            "trainingHistory",
            "education"
    };

    private final static String[] trainerProps = new String[]{
            "currentPosition",
            "education",
//            "businessCategory",
//            "executionCategory",
            "autoYears",
            "introduction",
            "mainCourse",
            "videoUrl1",
            "videoUrl2",
    };

    private final static String[] personProps = new String[]{
            "avatarUrl",
            "region",
            "name",
//            "birthday",
            "email",
            "marriageStatus",
            "mobile",
    };

    private final static String[] companyProps = new String[]{
            "name",
            "address",
            "region",
            "logoUrl",
            "scale",
            "introduction",
            "reactTime",
//            "welfare",
//            "businessCategory",
            "photoUrl",
    };

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public void setAutoYears(int autoYears) {
        this.autoYears = autoYears;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public void setCertRecords(String certRecords) {
        this.certRecords = certRecords;
    }

    public void setWorkingHistory(String workingHistory) {
        this.workingHistory = workingHistory;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setTrainingHistory(String trainingHistory) {
        this.trainingHistory = trainingHistory;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public void setExecutionCategory(String executionCategory) {
        this.executionCategory = executionCategory;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setVideoUrl1(String videoUrl1) {
        this.videoUrl1 = videoUrl1;
    }

    public void setVideoUrl2(String videoUrl2) {
        this.videoUrl2 = videoUrl2;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setReactTime(String reactTime) {
        this.reactTime = ReactTime.valueOf(reactTime);
    }

    public void setWelfare(Welfare welfare) {
        this.welfare = welfare;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
