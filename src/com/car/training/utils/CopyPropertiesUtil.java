package com.car.training.utils;

import com.car.training.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.util.BeanUtils;

public class CopyPropertiesUtil {

    /**
     * 复制Company： model -- remote
     *
     * @param s
     * @return
     */
    public static Company copyCompanyPropertiesToRemote(com.car.training.model.Company s) {
        if (s == null) {
            return null;
        }
        Company t = new Company();
        BeanUtils.copyProperties(s, t);
        return t;
    }

    /**
     * 复制Autobots： model -- remote
     *
     * @param s
     * @return
     */
    public static Autobots copyAutobotsPropertiesToRemote(com.car.training.model.Autobots s) {
        if (s == null) {
            return null;
        }
        Autobots t = new Autobots();
        BeanUtils.copyProperties(s, t);
        return t;
    }

    /**
     * 复制AutobotsComment： model -- remote
     *
     * @param s
     * @return
     */
    public static AutobotsComment copyAutobotsCommentPropertiesToRemote(com.car.training.model.AutobotsComment s) {
        if (s == null) {
            return null;
        }
        AutobotsComment t = new AutobotsComment();
        BeanUtils.copyProperties(s, t);
        return t;
    }

    /**
     * 复制Courses： model -- remote
     *
     * @param contracts
     * @return
     */
    public static Courses copyCoursesPropertiesToRemote(com.car.training.model.Courses s) {
        if (s == null) {
            return null;
        }
        Courses t = new Courses();
        BeanUtils.copyProperties(s, t);

        return t;
    }

    /**
     * 复制Jobs： model -- remote
     *
     * @param s
     * @return
     */
    public static Jobs copyJobsPropertiesToRemote(com.car.training.model.Jobs s) {
        if (s == null) {
            return null;
        }
        Jobs t = new Jobs();
        BeanUtils.copyProperties(s, t);
        if (s != null && s.getCompany() != null) {
            Company remotingCompany = new Company();
            BeanUtils.copyProperties(s.getCompany(), remotingCompany);
            int bandmanCount = 0;
            if (StringUtils.isNotBlank(remotingCompany.getBondsman())) {
                bandmanCount = remotingCompany.getBondsman().split(",").length;
                remotingCompany.setBondsmanCount(bandmanCount);
            }
            t.setCompany(remotingCompany);
        }
        if (s != null && s.getRegion() != null) {
            Region remotingRegion = new Region();
            BeanUtils.copyProperties(s.getRegion(), remotingRegion);
            t.setRegion(remotingRegion);
        }
        return t;
    }

    /**
     * 复制DeliveryResume： model -- remote
     *
     * @param s
     * @return
     */
    public static DeliveryResume copyDeliveryResumePropertiesToRemote(com.car.training.model.DeliveryResume s) {
        if (s == null) {
            return null;
        }
        DeliveryResume t = new DeliveryResume();
        BeanUtils.copyProperties(s, t);
        if (s != null && s.getTrainer() != null) {
            Trainer remotingTrainer = new Trainer();
            BeanUtils.copyProperties(s.getTrainer(), remotingTrainer);
            t.setTrainer(remotingTrainer);
        }
        if (s != null && s.getAutobots() != null) {
            Autobots remotingAutobots = new Autobots();
            BeanUtils.copyProperties(s.getAutobots(), remotingAutobots);
            t.setAutobots(remotingAutobots);
        }
        if (s != null && s.getJobs() != null) {
            Jobs remotingJobs = new Jobs();
            BeanUtils.copyProperties(s.getJobs(), remotingJobs);
            if (s != null && s.getJobs() != null && s.getJobs().getCompany() != null) {
                Company remotingCompany = new Company();
                BeanUtils.copyProperties(s.getJobs().getCompany(), remotingCompany);
                remotingJobs.setCompany(remotingCompany);
            }
            if (s != null && s.getJobs() != null && s.getJobs().getRegion() != null) {
                Region remotingRegion = new Region();
                BeanUtils.copyProperties(s.getJobs().getRegion(), remotingRegion);
                remotingJobs.setRegion(remotingRegion);
            }
            t.setJobs(remotingJobs);
        }
        return t;
    }

    /**
     * 复制Topic： model -- remote
     *
     * @param s
     * @return
     */
    public static Topic copyTopicPropertiesToRemote(com.car.training.model.Topic s) {
        if (s == null) {
            return null;
        }
        Topic t = new Topic();
        BeanUtils.copyProperties(s, t);

        return t;
    }

    /**
     * 复制TopicComment： model -- remote
     *
     * @param s
     * @return
     */
    public static TopicComment copyTopicCommentPropertiesToRemote(com.car.training.model.TopicComment s) {
        if (s == null) {
            return null;
        }
        TopicComment t = new TopicComment();
        BeanUtils.copyProperties(s, t);

        return t;
    }

    /**
     * 复制Trainer： model -- remote
     *
     * @param s
     * @return
     */
    public static Trainer copyTrainerPropertiesToRemote(com.car.training.model.Trainer s) {
        if (s == null) {
            return null;
        }
        Trainer t = new Trainer();
        BeanUtils.copyProperties(s, t);
        return t;
    }

    /**
     * 复制Estate： model -- remote
     *
     * @param activity
     * @return
     */
    public static TrainerEssay copyTrainerEssayPropertiesToRemote(com.car.training.model.TrainerEssay s) {
        if (s == null) {
            return null;
        }
        TrainerEssay t = new TrainerEssay();
        BeanUtils.copyProperties(s, t);

        return t;
    }

    /**
     * 复制UserCenter： model -- remote
     *
     * @param s
     * @return
     */
    public static UserCenter copyUserCenterPropertiesToRemote(com.car.training.model.UserCenter s) {
        if (s == null) {
            return null;
        }
        UserCenter t = new UserCenter();
        BeanUtils.copyProperties(s, t);
        return t;
    }
}
