package com.car.training.service;

import com.car.training.domain.Company;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface CompanyService {

    /**
     * 新增企业/公司信息
     */
    void save(Company company);

    /**
     * 更新企业/公司信息
     */
    void update(Company company);

    /**
     * 删除企业/公司信息
     */
    void delete(String id);

    /**
     * 获取企业/公司信息
     **/
    Company findById(String id);

    /**
     * 获取企业/公司信息
     **/
    Company findByUsername(String username);

    /**
     * 修改密码
     */
    void changePassword(String username, String currentPassword, String newPassword);

    /**
     * 获取企业/公司信息
     **/
    Company findByUsernamePassword(String username, String password);

    /**
     * 获取企业/公司列表
     */
    ResultPage<Company> findPageByCompany(Company company, Integer pageSize, Integer pageNo);

    /**
     * 获取企业/公司列表
     */
    List<Company> findListByCompany(Company company);

}
