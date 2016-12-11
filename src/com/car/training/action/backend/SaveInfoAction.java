package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.*;
import com.car.training.enums.ReactTime;
import com.car.training.service.AutobotService;
import com.car.training.service.CompanyService;
import com.car.training.service.SimpleService;
import com.car.training.service.TrainerService;
import com.car.training.utils.BeanOperation;
import com.car.training.utils.FileUploaderUtil;
import com.car.training.utils.RegionUtils;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by bill on 11/20/16.
 */
@AutoConfig
public class SaveInfoAction extends SimpleAction {

    @Autowired
    private BeanOperation beanOperation;

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

    @Autowired
    private SimpleService simpleService;

    @Override
    @JsonConfig(root = "data")
    public String execute() throws Exception {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(getLoginVO().getId());
        switch (getLoginVO().getUserType()) {
            case AUTOBOT:
                return saveAutobot();
            case TRAINER:
                return saveTrainer();
            case COMPANY:
            case STORE:
                return saveCompany();
            default:
                return errorJSON("用户类型错误");
        }
    }

    @JsonConfig(root = "data")
    public String setAvatar() {
        PersonInfo personInfo;
        switch (getLoginVO().getUserType()) {
            case AUTOBOT:
                personInfo = autobot.getPersonInfo();
                break;
            case TRAINER:
                personInfo = trainer.getPersonInfo();
                break;
            default:
                return errorJSON("用户类型错误");
        }
        String url = fileUploaderUtil.uploadImg(imgData);
        personInfo.setAvatarUrl(url);
        simpleService.save(personInfo);
        return keyValue("url", url);
    }

    @JsonConfig(root = "data")
    public String setPhoto() {
        switch (getLoginVO().getUserType()) {
            case COMPANY:
            case STORE:
                company = companyService.findByUId(getLoginVO().getId());
                String url = fileUploaderUtil.uploadImg(imgData);
                companyService.updatePhotoUrl(company.getId(),url);
                return keyValue("url", url);
            default:
                return errorJSON("用户类型错误");
        }
    }
    
    @JsonConfig(root = "data")
    public String setLogo() {
        switch (getLoginVO().getUserType()) {
            case COMPANY:
            case STORE:
                company = companyService.findByUId(getLoginVO().getId());
                String url = fileUploaderUtil.uploadImg(imgData);
                companyService.updateLogoUrl(company.getId(),url);
                return keyValue("url", url);
            default:
                return errorJSON("用户类型错误");
        }
    }
    
    
    private String saveAutobot() {
        beanOperation.setValue(this, autobot, autobotProps);
        autobot.setBusinessCategory(getCategories(businessCategory));
        setPersonInfo(autobot.getPersonInfo());
        autobotService.save(autobot);
        return successJSON();
    }

    private String saveTrainer() {
        beanOperation.setValue(this, trainer, trainerProps);
        trainer.setBusinessCategory(getCategories(businessCategory));
        trainer.setExecutionCategory(getCategories(executionCategory));
        setPersonInfo(trainer.getPersonInfo());
        simpleService.save(trainer);
        return successJSON();
    }

    private void setPersonInfo(PersonInfo personInfo) {
        region = regionUtils.getRegionById(regionId);
        beanOperation.setValue(this, personInfo, personProps);
        try {
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            personInfo.setBirthday(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String saveCompany() {
        logoUrl = fileUploaderUtil.uploadImg(logoUrl);
        photoUrl = fileUploaderUtil.uploadImg(photoUrl);
        region = regionUtils.getRegionById(regionId);
        company.setBusinessCategory(getCategories(businessCategory));
        beanOperation.setValue(this, company, companyProps);
        simpleService.save(company);
        return successJSON();
    }

    
    
    public String validateUser(){
        if(!getLoginVO().isLoggedIn()){
            return errorJSON("not logged in"); 
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setId(getLoginVO().getId());
        switch (getLoginVO().getUserType()) {
            case AUTOBOT:
                autobot = autobotService.findByLoginUser(loginUser);
                break;
            case TRAINER:
                trainer = trainerService.findByLoginUser(loginUser);
                break;
            case COMPANY:
            case STORE:
                company = companyService.findByLoginUser(loginUser);
                break;
            default:
                return errorJSON("用户类型错误");
        }
        return null;
    }

    @Override
    protected boolean needLogin() {
        return true;
    }

    private Autobot autobot;
    private Trainer trainer;
    private Company company;

    //personInfo fields
    private String imgData;
    private int regionId = -1;
    private Region region;
    private String name;
    private String birthday;
    private String email;
    private String marriageStatus;
    private String mobile;
    private String gender;

    //autobotProps
    private String workingStatus;
    private int autoYears;
//    private String autoBrand;
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
    private String autoBrand;
    private String businessRange;
    private String logoUrl;
    private String scale;
    private String introduction;
    private ReactTime reactTime;
    private String welfare;
    //  "businessCategory",
    private String photoUrl;
    private String telephone;
    private String contactName;

    private HashSet<String> getCategories(String categoryString) {
        HashSet<String> categories = new HashSet<>();
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
//            "avatarUrl",
            "region",
            "name",
//            "birthday",
            "email",
            "marriageStatus",
            "mobile",
            "gender"
    };

    private final static String[] companyProps = new String[]{
            "name",
            "address",
            "region",
            "logoUrl",
            "scale",
            "autoBrand",
            "introduction",
            "businessRange",
            "reactTime",
            "welfare",
            "email",
            "contactName",
            "telephone",
//            "businessCategory",
            "photoUrl",
    };

    public void setImgData(String imgData) {
        this.imgData = imgData;
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

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setBusinessRange(String businessRange) {
        this.businessRange = businessRange;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
