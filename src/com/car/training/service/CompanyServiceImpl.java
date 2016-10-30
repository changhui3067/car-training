package com.car.training.service;

import com.car.training.domain.Company;
import com.car.training.utils.ResultPageBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.aop.Timing;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyManager companyManager;

    /**
     * 新增企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void save(Company company) {
        com.car.training.model.Company target = new com.car.training.model.Company();
        BeanUtils.copyProperties(company, target);
        companyManager.save(target);
    }

    /**
     * 更新企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void update(Company company) {
        com.car.training.model.Company target = companyManager.findById(company.getId());
        BeanUtils.copyProperties(company, target);
        companyManager.update(target);
    }

    /**
     * 删除企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.Company target = new com.car.training.model.Company();
            target = companyManager.get(id);
            companyManager.delete(target);
        }
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Company findById(String id) {
        com.car.training.model.Company source = companyManager.get(id);
        if (source == null) {
            return null;
        }
        Company target = new Company();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Company findByUsername(String username) {
        com.car.training.model.Company source = companyManager.findByUsername(username);
        if (source == null) {
            return null;
        }
        Company target = new Company();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @Override
    @Transactional
    public void changePassword(String username, String currentPassword, String newPassword) {
        companyManager.changePassword(username, currentPassword, newPassword);
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Company findByUsernamePassword(String username, String password) {
        com.car.training.model.Company source = companyManager.findByUsernamePassword(username, password);
        if (source == null) {
            return null;
        }
        Company target = new Company();
        BeanUtils.copyProperties(source, target);
        return target;
    }


    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<Company> findPageByCompany(Company company, Integer pageSize, Integer pageNo) {
        ResultPage<Company> tResultPage = null;
        ResultPage<com.car.training.model.Company> sResultPage = new ResultPage<com.car.training.model.Company>();
        com.car.training.model.Company target = new com.car.training.model.Company();
        BeanUtils.copyProperties(company, target);
        sResultPage = companyManager.findPageByCompany(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<Company>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyCompanyPropertiesToRemote(sResultPage.getResult()));
            }
        }
        return tResultPage;
    }

    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Company> findListByCompany(Company company) {
        List<Company> resultList = null;
        com.car.training.model.Company tCompany = new com.car.training.model.Company();
        BeanUtils.copyProperties(company, tCompany);
        List<com.car.training.model.Company> sourceList = companyManager.findListByCompany(tCompany);
        if (sourceList != null) {
            resultList = new ArrayList<Company>(sourceList.size());
            for (com.car.training.model.Company sourceCompany : sourceList) {
                Company target = new Company();
                BeanUtils.copyProperties(sourceCompany, target);
                if (sourceCompany != null && sourceCompany.getRegion() != null) {
                    Region remotingRegion = new Region();
                    BeanUtils.copyProperties(sourceCompany.getRegion(), remotingRegion);
                    target.setRegion(remotingRegion);
                }
                resultList.add(target);
            }
        }
        return resultList;
    }

}
