package com.car.training.action.backend;


import com.car.training.utils.RegionUtils;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.service.EntityManager;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by I309994 on 10/25/2016.
 */
public class RegionsAction extends BaseAction {


    private static final long serialVersionUID = 2252498762484207850L;
    @Autowired
    private transient EntityManager<Region> entityManager;



    @Value("${upload.filepath:/car/training/upload/}")
    public static String CARTRAINING_UPLOAD_FILEPATH = "/car/training/upload/";


    private Map<String, Object> data;

    @Autowired
    private RegionUtils regionUtils;

    @JsonConfig(root = "data")
    public String getCities() {
        long parentId = Long.valueOf(getUid());
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("cities", regionUtils.getSubCities(parentId));
        setData(map);
        return JSON;
    }


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
