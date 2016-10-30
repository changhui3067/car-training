package com.car.training.action.backend;

import com.car.training.domain.Trainer;
import com.car.training.domain.UserCenter;
import com.car.training.enums.Education;
import com.car.training.enums.MarryStatus;
import com.car.training.enums.PersonalType;
import com.car.training.service.TrainerService;
import com.car.training.utils.FileUploaderUtil;
import com.car.training.utils.RegionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.fs.FileStorage;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.service.EntityManager;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@AutoConfig
public class TrainerCompleteResumeAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;
    @Value("${upload.filepath:/car/training/upload/}")
    public static String CARTRAINING_UPLOAD_FILEPATH = "/car/training/upload/";
    @Autowired
    public FileStorage fileStorage;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private transient EntityManager<Region> entityManager;
    @Autowired
    private FileUploaderUtil fileUploaderUtil;
    @Autowired
    private RegionUtils regionUtils;

    /**
     * 培训师
     */
    private Trainer trainer;

    private List<Region> provinces;

    private List<Region> cities;

    private Region userRegion;

    private Object data;

    private Long parentId;
    private String uheadLogo = "";
    private String upersonalType = "";
    private String tid = "";
    private String uid = "";
    private String uname = "";
    private String ubirthday = "";
    private String uemail = "";
    private String uregionId = "";
    private String umarryStatus = "";
    private String umobile = "";
    private String autoYears = "";
    private String education = "";
    private String intro = "";
    private String mainCourse = "";
    private String businessCategory = "";
    private String executionCategory = "";
    private String vedioURL1 = "";
    private String vedioURL2 = "";

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
            trainer = trainerService.findByUserCenter(uc.getId());
        }

        userRegion = regionUtils.getRegionById(trainer.getUserCenter().getRegion().getId());
        provinces = regionUtils.getSubCities(-1);
        cities = regionUtils.getSubCities(userRegion.getParent().getId());
        return SUCCESS;
    }


    @JsonConfig(root = "data")
    public String save() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        if (uc != null) {
            trainer = trainerService.findByUserCenter(uc.getId());
        }
        if (trainer != null) {
            trainer.setId(tid);
            trainer.setAutoYears(new Integer(autoYears));
            if (StringUtils.isNotBlank(businessCategory)) {
                Set<String> setStr = new HashSet<String>();
                String[] arr = businessCategory.split(",");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        setStr.add(s);
                    }
                    trainer.setBusinessCategory(setStr);
                }
            }
            if (StringUtils.isNotBlank(executionCategory)) {
                Set<String> setStr = new HashSet<String>();
                String[] arr = executionCategory.split(",");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        setStr.add(s);
                    }
                    trainer.setExecutionCategory(setStr);
                }
            }
            trainer.setEducation(Enum.valueOf(Education.class, education));
            trainer.setMainCourse(mainCourse);
            uc.setActiveDate(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            uc.setBirthday(sdf.parse(ubirthday));
            uc.setEmail(uemail);
            uc.setEnabled(true);
            uc.setIntro(intro);
            uc.setMarryStatus(Enum.valueOf(MarryStatus.class, umarryStatus));
            uc.setMobile(umobile);
            uc.setName(uname);
            uc.setPersonalType(Enum.valueOf(PersonalType.class, upersonalType));
            if (StringUtils.isNotBlank(uregionId)) {
                Region region = new Region();
                region.setId(Long.valueOf(uregionId));
                uc.setRegion(region);
            }
            if (StringUtils.isNotBlank(uheadLogo) && !uheadLogo.startsWith("http")) {
                String headLogo = fileUploaderUtil.uploadFile(CARTRAINING_UPLOAD_FILEPATH, uheadLogo);
                uc.setHeadLogo(headLogo);
            }
            trainer.setVedioURL1(vedioURL1);
            trainer.setVedioURL2(vedioURL2);
            trainer.setUserCenter(uc);
            trainerService.update(trainer);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        data = map;
        return JSON;
    }

    public Trainer getTrainer() {
        return trainer;
    }


    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUheadLogo() {
        return uheadLogo;
    }

    public void setUheadLogo(String uheadLogo) {
        this.uheadLogo = uheadLogo;
    }

    public String getUpersonalType() {
        return upersonalType;
    }

    public void setUpersonalType(String upersonalType) {
        this.upersonalType = upersonalType;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getExecutionCategory() {
        return executionCategory;
    }

    public void setExecutionCategory(String executionCategory) {
        this.executionCategory = executionCategory;
    }

    public String getVedioURL1() {
        return vedioURL1;
    }

    public void setVedioURL1(String vedioURL1) {
        this.vedioURL1 = vedioURL1;
    }

    public String getVedioURL2() {
        return vedioURL2;
    }

    public void setVedioURL2(String vedioURL2) {
        this.vedioURL2 = vedioURL2;
    }

    public Region getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(Region userRegion) {
        this.userRegion = userRegion;
    }
}
