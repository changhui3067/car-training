package com.car.training.service;

import com.car.training.domain.Courses;
import com.car.training.domain.Trainer;
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
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesManager coursesManager;

    /**
     * 新增企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void save(Courses courses) {
        com.car.training.model.Courses target = new com.car.training.model.Courses();
        BeanUtils.copyProperties(courses, target);
        coursesManager.save(target);
    }

    /**
     * 更新企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void update(Courses courses) {
        this.save(courses);
    }

    /**
     * 删除企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.Courses target = new com.car.training.model.Courses();
            target = coursesManager.get(id);
            coursesManager.delete(target);
        }
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Courses findById(String id) {
        com.car.training.model.Courses source = coursesManager.get(id);
        if (source == null) {
            return null;
        }
        Courses target = new Courses();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<Courses> findPageByCourses(Courses courses, Integer pageSize, Integer pageNo) {
        ResultPage<Courses> tResultPage = null;
        ResultPage<com.car.training.model.Courses> sResultPage = new ResultPage<com.car.training.model.Courses>();
        com.car.training.model.Courses target = new com.car.training.model.Courses();
        BeanUtils.copyProperties(courses, target);
        sResultPage = coursesManager.findPageByCourses(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<Courses>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyCoursesPropertiesToRemote(sResultPage.getResult()));
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
    public List<Courses> findListByCourses(Courses courses) {
        List<Courses> resultList = null;
        com.car.training.model.Courses tCourses = new com.car.training.model.Courses();
        BeanUtils.copyProperties(courses, tCourses);
        List<com.car.training.model.Courses> sourceList = coursesManager.findListByCourses(tCourses);
        if (sourceList != null) {
            resultList = new ArrayList<Courses>(sourceList.size());
            for (com.car.training.model.Courses sourceCourses : sourceList) {
                Courses target = new Courses();
                BeanUtils.copyProperties(sourceCourses, target);
                resultList.add(target);
            }
        }
        return resultList;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Courses> findByIndexPromoted(Boolean promote, Integer count) {
        List<Courses> resultList = null;
        List<com.car.training.model.Courses> sourceList = coursesManager.findByIndexPromoted(promote, count);
        if (sourceList != null) {
            resultList = new ArrayList<Courses>(count);

            for (com.car.training.model.Courses sourceCourses : sourceList) {
                Courses target = new Courses();
                BeanUtils.copyProperties(sourceCourses, target);
                if (sourceCourses != null && sourceCourses.getTrainer() != null) {
                    Trainer remotingTrainer = new Trainer();
                    BeanUtils.copyProperties(sourceCourses.getTrainer(), remotingTrainer);
                    target.setTrainer(remotingTrainer);
                }
                if (sourceCourses != null && sourceCourses.getRegion() != null) {
                    Region remotingRegion = new Region();
                    BeanUtils.copyProperties(sourceCourses.getRegion(), remotingRegion);
                    target.setRegion(remotingRegion);
                }
                int willnum = 0;
                if (StringUtils.isNotBlank(target.getAudiences())) {
                    willnum = target.getAudiences().split(",").length;
                    target.setWillnum(willnum);
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
