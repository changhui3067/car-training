package com.car.training.service;

import com.car.training.domain.Company;
import com.car.training.domain.Jobs;
import com.car.training.enums.CompanyType;
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
public class JobsServiceImpl implements JobsService {

    @Autowired
    private JobsManager jobsManager;

    /**
     * 新增企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void save(Jobs jobs) {
        com.car.training.model.Jobs target = new com.car.training.model.Jobs();
        BeanUtils.copyProperties(jobs, target);
        jobsManager.save(target);
    }

    /**
     * 更新企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void update(Jobs jobs) {
        this.save(jobs);
    }

    /**
     * 删除企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.Jobs target = new com.car.training.model.Jobs();
            target = jobsManager.get(id);
            jobsManager.delete(target);
        }
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Jobs findById(String id) {
        com.car.training.model.Jobs source = jobsManager.get(id);
        if (source == null) {
            return null;
        }
        Jobs target = new Jobs();
        BeanUtils.copyProperties(source, target);
        if (source != null && source.getCompany() != null) {
            Company remotingCompany = new Company();
            BeanUtils.copyProperties(source.getCompany(), remotingCompany);
            int bandmanCount = 0;
            if (StringUtils.isNotBlank(remotingCompany.getBondsman())) {
                bandmanCount = remotingCompany.getBondsman().split(",").length;
                remotingCompany.setBondsmanCount(bandmanCount);
            }
            target.setCompany(remotingCompany);
        }
        if (source != null && source.getRegion() != null) {
            Region region = new Region();
            BeanUtils.copyProperties(source.getRegion(), region);
            target.setRegion(region);
        }
        return target;
    }

    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<Jobs> findPageByJobs(Jobs jobs, Integer pageSize, Integer pageNo) {
        ResultPage<Jobs> tResultPage = null;
        ResultPage<com.car.training.model.Jobs> sResultPage = new ResultPage<com.car.training.model.Jobs>();
        com.car.training.model.Jobs target = new com.car.training.model.Jobs();
        BeanUtils.copyProperties(jobs, target);
        sResultPage = jobsManager.findPageByJobs(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<Jobs>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyJobsPropertiesToRemote(sResultPage.getResult()));
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
    public List<Jobs> findListByJobs(Jobs jobs) {
        List<Jobs> resultList = null;
        com.car.training.model.Jobs tJobs = new com.car.training.model.Jobs();
        BeanUtils.copyProperties(jobs, tJobs);
        List<com.car.training.model.Jobs> sourceList = jobsManager.findListByJobs(tJobs);
        if (sourceList != null) {
            resultList = new ArrayList<Jobs>(sourceList.size());
            for (com.car.training.model.Jobs sourceJobs : sourceList) {
                Jobs target = new Jobs();
                BeanUtils.copyProperties(sourceJobs, target);
                if (sourceJobs != null && sourceJobs.getCompany() != null) {
                    Company remotingCompany = new Company();
                    BeanUtils.copyProperties(sourceJobs.getCompany(), remotingCompany);
                    int bandmanCount = 0;
                    if (StringUtils.isNotBlank(remotingCompany.getBondsman())) {
                        bandmanCount = remotingCompany.getBondsman().split(",").length;
                        remotingCompany.setBondsmanCount(bandmanCount);
                    }
                    target.setCompany(remotingCompany);
                }
                if (sourceJobs != null && sourceJobs.getRegion() != null) {
                    Region remotingRegion = new Region();
                    BeanUtils.copyProperties(sourceJobs.getRegion(), remotingRegion);
                    target.setRegion(remotingRegion);
                }
                resultList.add(target);
            }
        }
        return resultList;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Jobs> findListByIndexType(CompanyType type, Integer count) {
        List<Jobs> resultList = null;
        List<com.car.training.model.Jobs> sourceList = jobsManager.findListByIndexType(type, count);
        if (sourceList != null) {
            resultList = new ArrayList<Jobs>(count);

            for (com.car.training.model.Jobs sourceJobs : sourceList) {
                Jobs target = new Jobs();
                BeanUtils.copyProperties(sourceJobs, target);
                if (sourceJobs != null && sourceJobs.getCompany() != null) {
                    Company remotingCompany = new Company();
                    BeanUtils.copyProperties(sourceJobs.getCompany(), remotingCompany);
                    int bandmanCount = 0;
                    if (StringUtils.isNotBlank(remotingCompany.getBondsman())) {
                        bandmanCount = remotingCompany.getBondsman().split(",").length;
                        remotingCompany.setBondsmanCount(bandmanCount);
                    }
                    target.setCompany(remotingCompany);
                }
                if (sourceJobs != null && sourceJobs.getRegion() != null) {
                    Region remotingRegion = new Region();
                    BeanUtils.copyProperties(sourceJobs.getRegion(), remotingRegion);
                    target.setRegion(remotingRegion);
                }
                resultList.add(target);
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        return resultList;
    }

}
