package com.car.training.service;

import com.car.training.domain.UserCenter;
import com.car.training.enums.PersonalType;
import com.car.training.exceptions.NotFoundException;
import com.car.training.model.Autobots;
import com.car.training.model.Trainer;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCenterServiceImpl implements UserCenterService {

    @Autowired
    private UserCenterManager userCenterManager;
    @Autowired
    private AutobotsManager autobotsManager;
    @Autowired
    private TrainerManager trainerManager;

    @Override
    @Transactional
    public void save(UserCenter uc) {
        com.car.training.model.UserCenter target = new com.car.training.model.UserCenter();
        BeanUtils.copyProperties(uc, target);
        userCenterManager.save(target);
        if (target.getPersonalType() == null) {
            throw new NotFoundException("1005", "请选择个人用户类型");
        } else {
            if (target.getPersonalType().equals(PersonalType.AUTOBOT)) {
                Autobots autobot = new Autobots();
                autobot.setUserCenter(target);
                autobotsManager.save(autobot);
            } else if (target.getPersonalType().equals(PersonalType.TRAINER)) {
                Trainer trainer = new Trainer();
                trainer.setUserCenter(target);
                trainerManager.save(trainer);
            }
        }
    }

    @Override
    @Transactional
    public void update(UserCenter uc) {
        com.car.training.model.UserCenter target = userCenterManager.get(uc.getId());
        BeanUtils.copyProperties(uc, target);
        userCenterManager.update(target);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean accepts(final String username) {
        return userCenterManager.accepts(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserCenter findById(String userId) {
        com.car.training.model.UserCenter source = userCenterManager.get(userId);
        UserCenter target = null;
        if (source != null) {
            target = new UserCenter();
            BeanUtils.copyProperties(source, target);
        }
        return target;
    }

    @Override
    @Transactional
    public void changePassword(String username, String currentPassword, String newPassword) {
        userCenterManager.changePassword(username, currentPassword, newPassword);
    }

    @Override
    @Transactional
    public void resetPassword(String username, String verifycode, String newPassword) {
        userCenterManager.resetPassword(username, verifycode, newPassword);
    }

    @Override
    @Transactional(readOnly = true)
    public void forgetPassword(String username, String verifycode, String newPassword) {
        userCenterManager.forgetPassword(username, verifycode, newPassword);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) {
        com.car.training.model.UserCenter source = (com.car.training.model.UserCenter) userCenterManager
                .loadUserByUsername(username);
        UserCenter target = null;
        if (source != null) {
            target = new UserCenter();
            org.springframework.beans.BeanUtils.copyProperties(source, target);
        }
        return (UserDetails) target;
    }

    @Override
    @Transactional(readOnly = true)
    public UserCenter findByUsername(String username) {
        com.car.training.model.UserCenter source = userCenterManager.findByUsername(username);
        UserCenter target = null;
        if (source != null) {
            target = new UserCenter();
            BeanUtils.copyProperties(source, target);
        }
        return target;
    }

    @Override
    @Transactional(readOnly = true)
    public UserCenter findByMobile(String mobile) {
        com.car.training.model.UserCenter source = userCenterManager.findByMobile(mobile);
        UserCenter target = null;
        if (source != null) {
            target = new UserCenter();
            BeanUtils.copyProperties(source, target);
        }
        return target;
    }

    @Override
    @Transactional
    public void delete(String userId) {
        com.car.training.model.UserCenter employee = userCenterManager.get(userId);
        if (employee != null) {
            userCenterManager.delete(employee);
        }
    }

    @Override
    public void recover(String userId) {
        com.car.training.model.UserCenter uc = userCenterManager.get(userId);
        if (uc != null) {
            userCenterManager.recover(uc);
        }
    }

    @SuppressWarnings("unused")
    private List<UserCenter> copyProperties(List<com.car.training.domain.UserCenter> as) {

        if (as == null)
            return null;
        List<UserCenter> bs = new ArrayList<>();
        for (com.car.training.domain.UserCenter source : as) {
            if (source != null) {
                UserCenter target = new UserCenter();
                BeanUtils.copyProperties(source, target);
                bs.add(target);
            }
        }
        return bs;
    }

    @Override
    @Transactional(readOnly = true)
    public UserCenter findByUsernamePassword(String username, String password) {
        UserCenter target = null;
        if (StringUtils.isNotBlank(username)) {
            com.car.training.model.UserCenter source = userCenterManager.findByUsernamePassword(username, password);
            if (source != null) {
                target = new UserCenter();
                BeanUtils.copyProperties(source, target);
            }
        }
        return target;
    }
}
