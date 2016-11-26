package com.car.training.service.impl;

import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.JobDAO;
import com.car.training.enums.JobType;
import com.car.training.service.CompanyService;
import com.car.training.service.JobService;
import com.car.training.service.UserService;
import com.car.training.utils.RegionUtils;
import com.car.training.vo.JobFilter;
import com.car.training.vo.LoginVO;
import org.ironrhino.common.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by freyjachang on 11/13/16.
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private BaseDAO baseDAO;

    @Autowired
    private LoginVO loginVO;

    @Autowired
    private JobDAO jobDAO;

    @Autowired
    private RegionUtils regionUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Override
    @Transactional
    public Job findById(int id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        return (Job) baseDAO.findOne(Job.class, map);
    }

    @Override
    @Transactional
    public List<Job> findAll(JobType jobType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", jobType);
        return baseDAO.find(Job.class, map);
    }

    @Override
    @Transactional
    public List<Job> findJobsByTargetCompany() {
        String username = loginVO.getUsername();
        LoginUser loginUser = userService.getUser(username);

        Company company = companyService.findByLoginUser(loginUser);
        HashMap<String, Object> map = new HashMap<>();
        map.put("company", company);
        return baseDAO.find(Job.class, map);
    }

    @Override
    @Transactional
    public List<Job> findJobsByTargetCompany(int targetCid) {
        HashMap<String, Object> map = new HashMap<>();
        Company company = companyService.findById(targetCid);
        map.put("company", company);
        return baseDAO.find(Job.class, map);
    }

    @Override
    @Transactional
    public List<Job> find(JobType jobType, String businessCategories, Integer regionId, String publishTime,
                          String workExperienceRequirement, String keyword) {
        return find(jobType, businessCategories, regionId, publishTime, workExperienceRequirement, keyword, 1);
    }

    @Override
    @Transactional
    public int rowCount(JobType jobType, String businessCategories, Integer regionId, String publishTime,
                        String workExperienceRequirement, String keyword) {
        Region region = null;
        if (regionId != null) {
            region = regionUtils.getRegionById(regionId);
        }
        JobFilter jobFilter = JobFilter.from(jobType, businessCategories, region, publishTime, workExperienceRequirement, keyword);
        return jobDAO.rowCount(jobFilter);
    }

    @Override
    @Transactional
    public List<Job> find(JobType jobType, String businessCategories, Integer regionId, String publishTime,
                          String workExperienceRequirement, String keyword, int pageNo) {
        Region region = null;
        if (regionId != null) {
            region = regionUtils.getRegionById(regionId);
        }
        JobFilter jobFilter = JobFilter.from(jobType, businessCategories, region, publishTime, workExperienceRequirement, keyword);
        return jobDAO.find(jobFilter, pageNo);
    }


    @Override
    @Transactional
    public void save(Job job) {
        job.setCreateDate(new Date());
        baseDAO.save(job);
    }
}
