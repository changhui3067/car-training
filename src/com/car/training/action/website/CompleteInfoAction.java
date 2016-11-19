package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Autobot;
import com.car.training.bean.Company;
import com.car.training.bean.Trainer;
import com.car.training.service.AutobotService;
import com.car.training.service.CompanyService;
import com.car.training.service.TrainerService;
import com.car.training.utils.RegionUtils;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Bill on 11/19/2016.
 */
@AutoConfig
public class CompleteInfoAction extends SimpleAction {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private AutobotService autobotService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RegionUtils regionUtils;

    private Trainer trainer;

    private Autobot autobot;

    private Company companyInfo;

    private String target;

    private List<Region> provinces;

    private List<Region> cities;

    private Region userRegion;

    private static String[] autoProps = new String[]{
            "certRecords",
            "autoBrand",
            "businessCategory",
            "workingHistory",
            "workingStatus"
    };

    private static String[] personProps = new String[]{
            "birthday",
            "email",
            "marriageStatus",
            "name",
            "mobile",
    };

    @Override
    public String execute() throws Exception {
        provinces = regionUtils.getSubCities(-1);
        Region parent;
        if (userRegion != null && (parent = userRegion.getParent()) != null) {
            cities = regionUtils.getSubCities(parent.getId());
        } else {
            cities = regionUtils.getSubCities(-1);
        }
        return target;
    }

    @Before(priority = 20)
    public String validateUser() {
        HttpSession session = getHttpSession();
        LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
        if (loginVO == null) {
            return redirectToIndex();
        }
        switch (loginVO.getUserType()) {
            case TRAINER:
                trainer = trainerService.findByUId(loginVO.getId());
                userRegion = trainer.getPersonInfo().getRegion();
                target = "trainer";
                break;
            case AUTOBOT:
                autobot = autobotService.findByUId(loginVO.getId());
                userRegion = autobot.getPersonInfo().getRegion();
                target = "autobot";
                break;
            case COMPANY:
                target = "company";
            case STORE:
                companyInfo = companyService.findByUId(loginVO.getId());
                userRegion = companyInfo.getRegion();
                target = "store";
                break;
            default:
                return redirectToIndex();
        }
        return null;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Autobot getAutobot() {
        return autobot;
    }

    public void setAutobot(Autobot autobot) {
        this.autobot = autobot;
    }

    public Company getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Company companyInfo) {
        this.companyInfo = companyInfo;
    }

    private void setValue(Object from, Object to, String[] props) {
        setValue(from, to, props, props);
    }

    private void setValue(Object from, Object to, String[] fromProps, String[] toProps) {
        if (fromProps.length != toProps.length) {
            return;
        }
        for (int i = 0; i < fromProps.length; i++) {
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
}
