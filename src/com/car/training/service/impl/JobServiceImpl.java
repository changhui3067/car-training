package com.car.training.service.impl;

import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.JobDAO;
import com.car.training.enums.JobType;
import com.car.training.enums.UserType;
import com.car.training.service.CompanyService;
import com.car.training.service.JobService;
import com.car.training.service.UserService;
import com.car.training.utils.RegionUtils;
import com.car.training.vo.LoginVO;
import org.ironrhino.common.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by freyjachang on 11/13/16.
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    BaseDAO baseDAO;

    @Autowired
    LoginVO loginVO;

    @Autowired
    JobDAO jobDAO;

    @Autowired
    RegionUtils regionUtils;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

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
        String[] businessCategoryArray;
        if (StringUtils.isEmpty(businessCategories)) {
            businessCategoryArray = new String[]{};
        } else {
            businessCategoryArray = businessCategories.split(",");
        }
        Region region = null;
        if (regionId != null) {
            region = regionUtils.getRegionById(regionId);
        }
        Date minPublishTime = null;
        Date maxPublishTime = null;
        if (!StringUtils.isEmpty(publishTime)) {
            String[] publishTimes = publishTime.split(",");
            if (publishTimes.length >= 2) {
                if (!StringUtils.isEmpty(publishTimes[0])) {
                    try {
                        int minDay = Integer.valueOf(publishTimes[0]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.DATE, 0 - minDay);
                        maxPublishTime = calendar.getTime();
                    } catch (Exception ignored) {
                    }

                    try {
                        int maxDay = Integer.valueOf(publishTimes[1]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.DATE, 0 - maxDay);
                        minPublishTime = calendar.getTime();

                    } catch (Exception ignored) {
                    }
                }
            }
        }
        Integer minWorkExperienceRequirement = null;
        Integer maxWorkExperienceRequirement = null;
        if (!StringUtils.isEmpty(workExperienceRequirement)) {
            String[] reqs = workExperienceRequirement.split(",");
            if (reqs.length >= 2) {
                try {
                    minWorkExperienceRequirement = Integer.valueOf(reqs[0]);
                } catch (Exception ignored) {

                }
                try {
                    maxWorkExperienceRequirement = Integer.valueOf(reqs[0]);
                } catch (Exception ignored) {

                }
            }
        }
        return jobDAO.find(jobType, Arrays.asList(businessCategoryArray), region, minPublishTime, maxPublishTime, minWorkExperienceRequirement, maxWorkExperienceRequirement, keyword);
    }


    @Override
    @Transactional
    public void save(Job job) {


        baseDAO.save(job);
    }
}
