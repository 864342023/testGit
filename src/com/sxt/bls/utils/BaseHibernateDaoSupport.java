package com.sxt.bls.utils;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


public class BaseHibernateDaoSupport extends HibernateDaoSupport {
    /**
     * 通过自动装配将在IOC容器中创建的sessionFactory注入此方法的形参
     * 在调用父类的set方法将sessionFactory注入 从而创建hibernateTemplate
     * @param sessionFactory
     */
    @Autowired
    public void setSessionFactory01(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

}
