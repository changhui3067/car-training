package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.annotation.FieldTransformer;
import com.car.training.annotation.Transformer;
import com.car.training.annotation.UIField;
import com.car.training.bean.*;
import com.car.training.service.AutobotService;
import com.car.training.service.CompanyService;
import com.car.training.service.SimpleService;
import com.car.training.service.TrainerService;
import com.car.training.utils.BeanOperation;
import com.car.training.utils.FileUploaderUtil;
import com.car.training.utils.RegionUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

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
                companyService.updatePhotoUrl(company.getId(), url);
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
                companyService.updateLogoUrl(company.getId(), url);
                return keyValue("url", url);
            default:
                return errorJSON("用户类型错误");
        }
    }


    private String saveAutobot() {
        setField(autobot,autobotFields);
        setPersonInfo(autobot.getPersonInfo());
        autobotService.save(autobot);
        return successJSON();
    }

    private String saveTrainer() {
        setField(trainer,trainerFields);
        setPersonInfo(trainer.getPersonInfo());
        simpleService.save(trainer);
        return successJSON();
    }

    private void setPersonInfo(PersonInfo personInfo) {
        Region region = regionUtils.getRegionById(regionId);
        setField(personInfo,personFields);
        personInfo.setRegion(region);
    }
    
    private void setField(Object object , ArrayList<FieldTransformer> fields ){
        HttpServletRequest request = ServletActionContext.getRequest();
        for (FieldTransformer ft : fields) {
            String param = request.getParameter(ft.getFieldName());
            Object value;
            if(ft.getTransformer() !=null){
               value = ft.getTransformer().transform(param);
            } else {
                value = param;
            }
            if(value !=null){
                beanOperation.setField(object, ft.getFieldName(), value );
            }
        }
    }

    private String saveCompany() {
        Region region = regionUtils.getRegionById(regionId);
        setField(company,companyFields);
        company.setRegion(region);
        simpleService.save(company);
        return successJSON();
    }


    public String validateUser() {
        if (!getLoginVO().isLoggedIn()) {
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

    private String imgData;
    private int regionId = -1;

    private static ArrayList<FieldTransformer> personFields = parseBean(PersonInfo.class);
    private static ArrayList<FieldTransformer> trainerFields = parseBean(Trainer.class);
    private static ArrayList<FieldTransformer> autobotFields = parseBean(Autobot.class);
    private static ArrayList<FieldTransformer> companyFields = parseBean(Company.class);

    private static ArrayList<FieldTransformer> parseBean(Class clazz) {
        if (clazz == null) {
            return null;
        }
        ArrayList<FieldTransformer> fieldTransformers = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Annotation annotation = field.getDeclaredAnnotation(UIField.class);
            if (annotation != null) {
                UIField uiField = (UIField) annotation;
                FieldTransformer fieldTransformer = new FieldTransformer();
                Transformer transformer = null;
                try {
                    transformer = uiField.transformer().newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    if (field.getType() == Integer.class || field.getType() ==int.class) {
                        transformer = new Transformer.IntegerTransformer();
                    }
                }
                fieldTransformer.setFieldName(field.getName());
                fieldTransformer.setTransformer(transformer);
                fieldTransformers.add(fieldTransformer);
            }
        }
        return fieldTransformers;
    }


    public void setImgData(String imgData) {
        this.imgData = imgData;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
