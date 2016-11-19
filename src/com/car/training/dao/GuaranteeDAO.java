package com.car.training.dao;

public interface GuaranteeDAO {
    boolean isGuarantee(int uid,int companyId);

    boolean guarantee(int uid ,int companyId);

    boolean unGuarantee(int uid , int companyId);

    int guaranteeNumber(int companyId);
}
