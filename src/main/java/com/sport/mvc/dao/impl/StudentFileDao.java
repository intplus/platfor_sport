package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentFileDao")
public class StudentFileDao extends FileAbstractDao<Student> implements StudentDao {

    //getting session factory from the bean
    @Autowired
    SessionFactory sessionFactory;

    public StudentFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Student> getAll() {
        //open current session
        Session session = sessionFactory.getCurrentSession();
        //get the list of users
        List<Student> students = session.createQuery("from Student").list();
        return students;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public Student getByUsername(String username) {
        return null;
    }

    @Override
    public void add(Student student) {
        //open session
        Session session  = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
        session.flush();


    }
}
