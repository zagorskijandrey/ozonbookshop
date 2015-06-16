package com.zagorskij.ozonebookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by andrey on 16.06.2015.
 */
public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void add(Object entity){
        getSession().saveOrUpdate(entity);
    }

    public void update(Object entity){
        getSession().update(entity);
    }
}
