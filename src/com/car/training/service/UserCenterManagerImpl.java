package com.car.training.service;

import com.car.training.exceptions.NotFoundException;
import com.car.training.model.UserCenter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.core.cache.CheckCache;
import org.ironrhino.core.cache.EvictCache;
import org.ironrhino.core.security.role.UserRoleMapper;
import org.ironrhino.core.service.BaseManagerImpl;
import org.ironrhino.core.util.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class UserCenterManagerImpl extends BaseManagerImpl<UserCenter> implements UserCenterManager {

    public static final String CACHE_NAMESPACE = "uc:usercenter";


    @SuppressWarnings("unused")
    @Autowired(required = false)
    private List<UserRoleMapper> userRoleMappers;

    @Override
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${[uc.id,uc.username]}")
    public void update(final UserCenter uc) {
        super.update(uc);
    }

    @Override
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${[uc.id,uc.username]}")
    public void delete(final UserCenter user) {
        user.setEnabled(false);
        ; // 标志删除
        super.save(user);
    }

    @Override
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${[uc.id,uc.username]}")
    public void save(final UserCenter uc) {
        if (uc.getPassword().length() != 32) {
            uc.setLegiblePassword(uc.getPassword());
        }
        super.save(uc);
    }

    @Override
    @Transactional(readOnly = true)
    @CheckCache(namespace = CACHE_NAMESPACE, key = "${username}", cacheNull = true)
    public UserDetails loadUserByUsername(final String username) {
        UserCenter uc = findByNaturalId(username);
        if (uc == null) {
            return null;
        }
        this.populateAuthorities(uc);
        return uc;
    }

    @Override
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${username}")
    public void changePassword(final String username, final String currentPassword, final String newPassword) {

        UserCenter user = findOne(username);
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
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${username}")
    public void resetPassword(final String username, final String verifycode, final String newPassword) {
    /*
        if (smsManager.checkCode(username, verifycode)) {
			UserCenter uc = (UserCenter) this.loadUserByUsername(username);
			uc.setLegiblePassword(newPassword);
			super.save(uc);
		} else {
			throw new IllegalArgumentException("您输入的验证码[" + verifycode + "]不正确，请重新输入！");
		}*/
    }

    @Override
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${username}")
    public void forgetPassword(final String username, final String verifycode, final String newPassword) {

        UserCenter uc = (UserCenter) this.loadUserByUsername(username);
        if (uc != null) {
            uc.setLegiblePassword(newPassword);
            super.save(uc);
        }
    }

    @SuppressWarnings("unused")
    private void populateAuthorities(final UserCenter user) {
        List<GrantedAuthority> auths = new ArrayList<>();

    }

    /**
     * 根据账号
     **/
    @Override
    @Transactional(readOnly = true)
    public UserCenter findByUsername(String username) {
        return findOne("username", username);
    }

    /**
     * 根据手机号
     **/
    @Override
    @Transactional(readOnly = true)
    public UserCenter findByMobile(String mobile) {
        return findOne("mobile", mobile);
    }


    @Override
    @Transactional
    @EvictCache(namespace = CACHE_NAMESPACE, key = "${[uc.id,uc.username]}")
    public void recover(UserCenter user) {
        if (user != null) {
            user.setEnabled(false);
            super.save(user);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCenter> findList(String companyId, boolean enabled, Integer pageSize, Integer pageNo) {
        return findListByName(companyId, null, enabled, pageSize, pageNo);
    }

    @SuppressWarnings("unused")
    @Override
    @Transactional(readOnly = true)
    public List<UserCenter> findListByName(String companyId, String name, boolean enabled, Integer pageSize,
                                           Integer pageNo) {

        DetachedCriteria dc = detachedCriteria();
        if (!StringUtils.isBlank(name)) {
            dc.add(Restrictions.or(Restrictions.like("mobile", name, MatchMode.ANYWHERE),
                    Restrictions.like("name", name, MatchMode.ANYWHERE)));
        }
        dc.add(Restrictions.eq("enabled", enabled));

        List<UserCenter> emps = null;
        emps = findListByCriteria(dc, pageNo != null ? pageNo : 1, pageSize != null ? pageSize : 10);

        if (emps != null && !StringUtils.isBlank(companyId)) {
            List<UserCenter> emps2 = new ArrayList<>();
            for (UserCenter emp : emps) {

            }
            emps = emps2;
        }

        return emps;
    }

    @Override
    @Transactional(readOnly = true)
    public UserCenter findByUsernamePassword(String username, String password) {
        PasswordEncoder encoder = ApplicationContextUtils.getBean(PasswordEncoder.class);
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("username", username));
        dc.add(Restrictions.eq("password", encoder.encode(password)));
        UserCenter user = findByCriteria(dc);
        if (user == null) {
            return null;
        }
        populateAuthorities(user);
        return user;
    }

    @Override
    public boolean accepts(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public UserCenter register(String username, Object object, Object object2, Object object3) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserCenter findByPassword(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean checkCode(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

}
