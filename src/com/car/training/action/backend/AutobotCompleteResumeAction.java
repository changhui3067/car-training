package com.car.training.action.backend;

import com.car.training.bean.Autobot;
import com.car.training.bean.LoginUser;
import com.car.training.enums.UserType;
import com.car.training.service.AutobotService;
import com.car.training.utils.FileUploaderUtil;
import com.car.training.utils.RegionUtils;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AutoConfig
public class AutobotCompleteResumeAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;
    @Value("${upload.filepath:/car/training/upload/}")
    public static String CARTRAINING_UPLOAD_FILEPATH = "/car/training/upload/";
    @Autowired
    private AutobotService autobotService;
    @Autowired
    private FileUploaderUtil fileUploaderUtil;
    @Autowired
    private RegionUtils regionUtils;
    /**
     * 汽车人
     */
    private Autobot autobot;

    private String avatarUrl = "";
    private String regionId = "";

    private String name = "";
    private String birthday = "";
    private String email = "";
    private String marriageStatus = "";
    private String mobile = "";

    private String autoYears = "";

    private String workingStatus = "";
    private String autoBrand = "";
    private String certRecords = "";
    private String workingHistory = "";
    private String businessCategory = "";

    private List<Region> provinces;

    private List<Region> cities;

    private Object data;

    private Region userRegion;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Region> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Region> provinces) {
        this.provinces = provinces;
    }

    public List<Region> getCities() {
        return cities;
    }

    public void setCities(List<Region> cities) {
        this.cities = cities;
    }

    @Override
    public String execute() throws Exception {
        provinces = regionUtils.getSubCities(-1);
        userRegion = regionUtils.getRegionById(autobot.getPersonInfo().getRegionId());
        cities = regionUtils.getSubCities(userRegion.getParent().getId());
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String save() throws Exception {
        if (autobot != null) {
            autobot.setAutoYears(new Integer(autoYears));

            if (StringUtils.isNotBlank(avatarUrl) && !avatarUrl.startsWith("http")) {
                String headLogo = fileUploaderUtil.uploadFile(CARTRAINING_UPLOAD_FILEPATH, avatarUrl);
                autobot.getPersonInfo().setAvatarUrl(headLogo);
            }
            autobot.getPersonInfo().setRegionId(Integer.valueOf(regionId));

            String[] autoProps = new String[]{
                    "certRecords",
                    "autoBrand",
                    "businessCategory",
                    "workingHistory",
                    "workingStatus"
            };

            String[] personProps = new String[]{
                    "birthday",
                    "email",
                    "marriageStatus",
                    "name",
                    "mobile",
            };
            setValue(this,autobot.getPersonInfo(),personProps);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        setData(map);
        return JSON;
    }

    private void setValue(Object from, Object to, String[] props) {
        setValue(from,to,props,props);
    }

    private void setValue(Object from, Object to, String[] fromProps , String[] toProps) {
        if(fromProps.length !=toProps.length){
            return;
        }
        for ( int i = 0 ; i < fromProps.length ; i ++ ) {
            try {
                String fromProp = fromProps[i];
                String toProp = toProps[i];
                Field fromField = from.getClass().getDeclaredField(fromProp);
                Field toField = to.getClass().getDeclaredField(toProp);
                fromField.setAccessible(true);
                toField.setAccessible(true);
                toField.set(to, fromField.get(this));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Before(priority = 20)
    public String validateUser() {
        HttpServletRequest request = ServletActionContext.getRequest();
        LoginVO loginVO = (LoginVO) request.getSession().getAttribute("loginVO");
        if (loginVO != null && loginVO.getUserType().equals(UserType.AUTOBOT)) {
            autobot = autobotService.findByUId(loginVO.getId());
            return null;
        } else {
            targetUrl = "/website/index";
            return REDIRECT;
        }
    }

    public Autobot getAutobot() {
        return autobot;
    }


    public void setAutobot(Autobot autobot) {
        this.autobot = autobot;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public AutobotService getAutobotService() {
        return autobotService;
    }

    public void setAutobotService(AutobotService autobotService) {
        this.autobotService = autobotService;
    }

    public FileUploaderUtil getFileUploaderUtil() {
        return fileUploaderUtil;
    }

    public void setFileUploaderUtil(FileUploaderUtil fileUploaderUtil) {
        this.fileUploaderUtil = fileUploaderUtil;
    }

    public RegionUtils getRegionUtils() {
        return regionUtils;
    }

    public void setRegionUtils(RegionUtils regionUtils) {
        this.regionUtils = regionUtils;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public String getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(String autoYears) {
        this.autoYears = autoYears;
    }

    public String getCertRecords() {
        return certRecords;
    }

    public void setCertRecords(String certRecords) {
        this.certRecords = certRecords;
    }

    public String getWorkingHistory() {
        return workingHistory;
    }

    public void setWorkingHistory(String workingHistory) {
        this.workingHistory = workingHistory;
    }



    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Region getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(Region userRegion) {
        this.userRegion = userRegion;
    }
}
