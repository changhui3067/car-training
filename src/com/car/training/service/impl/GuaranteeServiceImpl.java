package com.car.training.service.impl;

import com.car.training.bean.Company;
import com.car.training.dao.GuaranteeDAO;
import com.car.training.service.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    @Autowired
    GuaranteeDAO guaranteeDAO;


    @Override
    public boolean guarantee(int uid, int companyId) {
        return guaranteeDAO.guarantee(uid,companyId);
    }

    @Override
    public boolean unGuarantee(int uid, int companyId) {
        return guaranteeDAO.unGuarantee(uid,companyId);
    }

    @Override
    public boolean isGuarantee(int uid, int companyId) {
        return guaranteeDAO.isGuarantee(uid,companyId);
    }

    @Override
    public int guaranteeNumber(int companyId) {
        return guaranteeDAO.guaranteeNumber(companyId);
    }
}
