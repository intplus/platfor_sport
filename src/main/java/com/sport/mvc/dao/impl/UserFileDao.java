package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userFileDao")
public class UserFileDao extends FileAbstractDao<User> implements UserDao {
    //getting session factory from the bean
    @Autowired
    SessionFactory sessionFactory;

    public UserFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<User> getAll() {
        //open current session
       org.hibernate.Session session = sessionFactory.getCurrentSession();
        //get the list of users
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public void add(User user) {
        //open session
        org.hibernate.Session session  = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();


    }
}
