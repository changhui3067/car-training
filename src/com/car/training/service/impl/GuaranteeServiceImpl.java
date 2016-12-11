package com.car.training.service.impl;

import com.car.training.bean.Company;
import com.car.training.bean.Guarantee;
import com.car.training.bean.PersonInfo;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.GuaranteeDAO;
import com.car.training.service.GuaranteeService;
import com.car.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    @Autowired
    BaseDAO baseDAO;

    @Autowired
    GuaranteeDAO guaranteeDAO;

    @Autowired
    UserService userService;


    @Override
    public boolean guarantee(int uid, int companyId) {
        PersonInfo personInfo = userService.getPersonInfo(uid);
        return guaranteeDAO.guarantee(personInfo,companyId);
    }

    @Override
    public boolean unGuarantee(int uid, int companyId) {
        PersonInfo personInfo = userService.getPersonInfo(uid);
        return guaranteeDAO.unGuarantee(personInfo,companyId);
    }

    @Override
    public boolean isGuarantee(int uid, int companyId) {
        PersonInfo personInfo = userService.getPersonInfo(uid);
        return guaranteeDAO.isGuarantee(personInfo,companyId);
    }

    @Override
    public int guaranteeNumber(int companyId) {
        return guaranteeDAO.guaranteeNumber(companyId);
    }

    @Override
    public List findPeronByCompanyId(int companyId) {
        HashMap<String, Object> map = new HashMap<>();
        Guarantee guarantee = new Guarantee();
        guarantee.setId(companyId);
        map.put("companyId", companyId);
        return baseDAO.find(Guarantee.class, map);
    }
}
