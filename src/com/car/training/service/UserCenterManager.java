package com.car.training.service;

import com.car.training.model.UserCenter;
import org.ironrhino.core.service.BaseManager;
import org.ironrhino.core.spring.security.ConcreteUserDetailsService;

import java.util.List;

public interface UserCenterManager extends BaseManager<UserCenter>, ConcreteUserDetailsService {

    /**
     * 删除员工
     */
    void delete(UserCenter uc);

    /**
     * 恢复员工
     */
    void recover(UserCenter uc);

    /**
     * 修改密码
     */
    void changePassword(String username, String currentPassword, String newPassword);

    /**
     * 重置密码
     */
    void resetPassword(String username, String verifycode, String newPassword);

    /**
     * 忘记密码
     */
    void forgetPassword(String username, String verifycode, String newPassword);

    UserCenter findByUsername(String username);

    UserCenter findByMobile(String mobile);

    /**
     * 根据启用状态查询列表
     */
    List<UserCenter> findList(String companyId, boolean enabled, Integer pageSize, Integer pageNo);

    /**
     * 根据 名称 |电话 启用状态查询列表
     */
    List<UserCenter> findListByName(String companyId, String name, boolean enabled, Integer pageSize, Integer pageNo);

    UserCenter findByUsernamePassword(String username, String password);

    UserCenter register(String username, Object object, Object object2, Object object3);

    UserCenter findByPassword(String username, String password);

    boolean checkCode(String username, String password);

}
