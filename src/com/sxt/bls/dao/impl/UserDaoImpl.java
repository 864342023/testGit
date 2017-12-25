package com.sxt.bls.dao.impl;

import com.sxt.bls.dao.UserDao;
import com.sxt.bls.pojo.User;
import com.sxt.bls.utils.BaseHibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseHibernateDaoSupport implements UserDao {
    @Override
    public User findUserByName(String uname) {

        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where uname = ?", uname);
        return list == null || list.size() == 0 ? null : list.get(0);
    }
}
