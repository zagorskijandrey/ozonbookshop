//Created by andrey on 16.06.2015.
package com.zagorskij.ozonbookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//This class serve as base class for database related operations.
public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void add(Object entity){
        getSession().saveOrUpdate(entity);
    }
}
