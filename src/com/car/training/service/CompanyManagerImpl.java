package com.car.training.service;

import com.car.training.exceptions.NotFoundException;
import com.car.training.model.Company;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManagerImpl;
import org.ironrhino.core.util.ApplicationContextUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CompanyManagerImpl extends BaseManagerImpl<Company> implements CompanyManager {

    @Override
    @Transactional
    public void save(Company obj) {
        if (StringUtils.isNotBlank(obj.getPassword())) {
            obj.setLegiblePassword(obj.getPassword());
        }
        super.save(obj);
    }

    @Override
    @Transactional
    public void update(Company obj) {
        super.update(obj);
    }

    @Override
    @Transactional
    public void delete(String id) {
        if (StringUtils.isBlank(id))
            throw new NotFoundException("要删除的对象不存在");
        super.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Company findById(String id) {
        if (StringUtils.isBlank(id))
            return null;
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("enabled", true));
        dc.add(Restrictions.eq("id", id));
        return findByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public Company findByUsernamePassword(String username, String password) {
        PasswordEncoder encoder = ApplicationContextUtils.getBean(PasswordEncoder.class);
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password))
            return null;
        DetachedCriteria dc = detachedCriteria();
//			dc.add(Restrictions.eq("enabled", true));
        dc.add(Restrictions.eq("username", username));
        dc.add(Restrictions.eq("password", encoder.encode(password)));
        return findByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public Company findByUsername(String username) {
        if (StringUtils.isBlank(username))
            return null;
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("enabled", true));
        dc.add(Restrictions.eq("username", username));
        return findByCriteria(dc);
    }

    @Override
    @Transactional
    public void changePassword(final String username, final String currentPassword, final String newPassword) {

        Company user = findOne(username);
        if (user == null) {
            throw new NotFoundException("职员[" + username + "]不存在");
        }
        if (!user.isPasswordValid(currentPassword)) {
            throw new IllegalArgumentException("密码错误");
        }
        user.setLegiblePassword(newPassword);
        super.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public ResultPage<Company> findPageByCompany(Company autobotsComment, Integer pageSize, Integer pageNo) {
        ResultPage<Company> resultPage = new ResultPage<Company>();
        if (autobotsComment == null)
            return null;
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("enabled", true));
        dc.addOrder(Order.desc("createDate"));
        resultPage.setCriteria(dc);

        pageSize = ((pageSize == null || pageSize <= 0) ? ResultPage.DEFAULT_PAGE_SIZE : pageSize);
        pageNo = ((pageNo == null || pageNo <= 0) ? 1 : pageNo);
        resultPage.setPageSize(pageSize);
        resultPage.setPageNo(pageNo);
        return findByResultPage(resultPage);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findListByCompany(Company autobotsComment) {
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("enabled", true));
        dc.addOrder(Order.desc("createDate"));
        return findListByCriteria(dc);
    }

    @Override
    public boolean accepts(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
