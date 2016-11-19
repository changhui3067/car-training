package com.car.training.service;

public interface GuaranteeService {
    boolean guarantee(int uid, int companyId);
    boolean unGuarantee(int uid, int companyId);
    boolean isGuarantee(int uid,int companyId);
    int guaranteeNumber(int companyId);
}
