package com.car.training.service;

import com.car.training.domain.UserCenter;
import org.ironrhino.core.remoting.Remoting;
import org.ironrhino.core.spring.security.ConcreteUserDetailsService;
import org.springframework.core.annotation.Order;

@Order(12)
@Remoting
public interface UserCenterService extends ConcreteUserDetailsService {

    /**
     * UC185新增员工信息
     */
    void save(UserCenter uc);

    /**
     * UC181更新员工信息
     */
    void update(UserCenter uc);

    /**
     * 删除员工信息
     */
    void delete(String employeeId);

    /**
     * 恢复员工信息
     */
    void recover(String employeeId);

    /**
     * 修改密码
     */
    void changePassword(String username, String currentPassword, String newPassword);

    /**
     * 获取员工信息
     **/
    UserCenter findById(String id);

    /**
     * 获取员工信息
     **/
    UserCenter findByUsername(String username);

    /**
     * UC188获取员工信息
     **/
    UserCenter findByMobile(String mobile);

    /**
     * UC110重置密码
     */
    void resetPassword(String username, String verifycode, String newPassword);

    /**
     * UC110忘记密码
     */
    void forgetPassword(String username, String verifycode, String newPassword);

    UserCenter findByUsernamePassword(String username, String password);

}
