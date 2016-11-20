package com.car.training.dao;

import com.car.training.bean.PersonInfo;

public interface GuaranteeDAO {
    boolean isGuarantee(PersonInfo uid, int companyId);

    boolean guarantee(PersonInfo uid ,int companyId);

    boolean unGuarantee(PersonInfo uid , int companyId);

    int guaranteeNumber(int companyId);
}
