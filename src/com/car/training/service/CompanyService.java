package com.car.training.service;

import com.car.training.bean.Company;
import com.car.training.bean.LoginUser;

/**
 * Created by Bill on 11/13/2016.
 */
public interface CompanyService {
    Company findById(int id);

    Company findByUId(int uid);

    Company findByLoginUser(LoginUser loginUser);

    void updateLogoUrl(int companyId, String logoUrl);

    void updatePhotoUrl(int companyId, String url);
}
