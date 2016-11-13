package com.car.training.action.website;

import com.car.training.action.SimpleJsonAction;
import com.car.training.bean.Company;
import com.car.training.dao.BaseDAO;
import com.car.training.service.CompanyService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bill on 11/13/2016.
 */
@AutoConfig
public class CompanyDetailAction extends SimpleJsonAction {

    @Autowired
    CompanyService companyService;

    @Autowired
    BaseDAO baseDAO;

    private Company company;


    private int companyId;

    @Override
    public String execute() throws Exception {
        if(companyId!=0){
            company = companyService.findById(companyId);
        }else{
            return redirectToIndex();
        }
        return SUCCESS;
    }


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
