package com.car.training.action.backend;

import com.car.training.domain.Autobots;
import com.car.training.domain.UserCenter;
import com.car.training.enums.MarryStatus;
import com.car.training.enums.PersonalType;
import com.car.training.service.AutobotsService;
import com.car.training.utils.FileUploaderUtil;
import com.car.training.utils.RegionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@AutoConfig
public class AutobotCompleteResumeAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;
    @Value("${upload.filepath:/car/training/upload/}")
    public static String CARTRAINING_UPLOAD_FILEPATH = "/car/training/upload/";
    @Autowired
    private AutobotsService autobotsService;
    @Autowired
    private FileUploaderUtil fileUploaderUtil;
    @Autowired
    private RegionUtils regionUtils;
    /**
     * 汽车人
     */
    private Autobots autobot;

    private String uheadLogo = "";
    private String upersonalType = "";
    private String aid = "";
    private String uid = "";
    private String uname = "";
    private String ubirthday = "";
    private String uemail = "";
    private String uregionId = "";
    private String umarryStatus = "";
    private String currentWorkStatus = "";
    private String autoBrand = "";
    private String umobile = "";
    private String autoYears = "";
    private String authHistroy = "";
    private String workingHistroy = "";
    private String workPhotoURL1 = "";
    private String workPhotoURL2 = "";
    private String businessCategory = "";

    private List<Region> provinces;

    private List<Region> cities;

    private Object data;

    private Long parentId;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = (UserCenter) request.getSession().getAttribute("userDetails");
        if (uc != null) {
            autobot = autobotsService.findByUserCenter(uc.getId());
        }
        provinces = regionUtils.getSubCities(-1);
        userRegion = regionUtils.getRegionById(autobot.getUserCenter().getRegion().getId());
        cities = regionUtils.getSubCities(userRegion.getParent().getId());
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String save() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = (UserCenter) request.getSession().getAttribute("userDetails");
        if (uc != null) {
            autobot = autobotsService.findByUserCenter(uc.getId());
        }
        if (autobot != null) {
            autobot.setId(aid);
            autobot.setAuthHistroy(authHistroy);
            autobot.setAutoBrand(autoBrand);
            autobot.setAutoYears(new Integer(autoYears));
            if (StringUtils.isNotBlank(businessCategory)) {
                Set<String> setStr = new HashSet<String>();
                String[] arr = businessCategory.split(",");
                if (arr.length > 0) {
                    Collections.addAll(setStr, arr);
                    autobot.setBusinessCategory(setStr);
                }
            }
            autobot.setCurrentWorkStatus(currentWorkStatus);
            if (StringUtils.isNotBlank(uheadLogo) && !uheadLogo.startsWith("http")) {
                String headLogo = fileUploaderUtil.uploadFile(CARTRAINING_UPLOAD_FILEPATH, uheadLogo);
                uc.setHeadLogo(headLogo);
            }
            if (StringUtils.isNotBlank(workPhotoURL1) && !workPhotoURL1.startsWith("http")) {
                String fileURL1 = fileUploaderUtil.uploadFile(CARTRAINING_UPLOAD_FILEPATH, workPhotoURL1);
                autobot.setWorkPhotoURL1(fileURL1);
            }
            if (StringUtils.isNotBlank(workPhotoURL2) && !workPhotoURL2.startsWith("http")) {
                String fileURL2 = fileUploaderUtil.uploadFile(CARTRAINING_UPLOAD_FILEPATH, workPhotoURL2);
                autobot.setWorkPhotoURL2(fileURL2);
            }
            autobot.setWorkingHistroy(workingHistroy);

            uc.setActiveDate(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            uc.setBirthday(sdf.parse(ubirthday));
            uc.setEmail(uemail);
            uc.setEnabled(true);
            uc.setId(uid);
            uc.setMarryStatus(Enum.valueOf(MarryStatus.class, umarryStatus));
            uc.setName(uname);
            uc.setPersonalType(Enum.valueOf(PersonalType.class, upersonalType));
            if (StringUtils.isNotBlank(uregionId)) {
                Region region = new Region();
                region.setId(Long.valueOf(uregionId));
                uc.setRegion(region);
            }
            uc.setMobile(umobile);
            autobot.setUserCenter(uc);
            autobotsService.update(autobot);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        setData(map);
        return JSON;
    }


    public Autobots getAutobot() {
        return autobot;
    }


    public void setAutobot(Autobots autobot) {
        this.autobot = autobot;
    }

    public String getUpersonalType() {
        return upersonalType;
    }

    public void setUpersonalType(String upersonalType) {
        this.upersonalType = upersonalType;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(String ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUregionId() {
        return uregionId;
    }

    public void setUregionId(String uregionId) {
        this.uregionId = uregionId;
    }

    public String getUmarryStatus() {
        return umarryStatus;
    }

    public void setUmarryStatus(String umarryStatus) {
        this.umarryStatus = umarryStatus;
    }

    public String getCurrentWorkStatus() {
        return currentWorkStatus;
    }

    public void setCurrentWorkStatus(String currentWorkStatus) {
        this.currentWorkStatus = currentWorkStatus;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public String getUmobile() {
        return umobile;
    }

    public void setUmobile(String umobile) {
        this.umobile = umobile;
    }

    public String getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(String autoYears) {
        this.autoYears = autoYears;
    }

    public String getAuthHistroy() {
        return authHistroy;
    }

    public void setAuthHistroy(String authHistroy) {
        this.authHistroy = authHistroy;
    }

    public String getWorkingHistroy() {
        return workingHistroy;
    }

    public void setWorkingHistroy(String workingHistroy) {
        this.workingHistroy = workingHistroy;
    }


    public String getUheadLogo() {
        return uheadLogo;
    }

    public void setUheadLogo(String uheadLogo) {
        this.uheadLogo = uheadLogo;
    }

    public String getWorkPhotoURL1() {
        return workPhotoURL1;
    }

    public void setWorkPhotoURL1(String workPhotoURL1) {
        this.workPhotoURL1 = workPhotoURL1;
    }

    public String getWorkPhotoURL2() {
        return workPhotoURL2;
    }

    public void setWorkPhotoURL2(String workPhotoURL2) {
        this.workPhotoURL2 = workPhotoURL2;
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
