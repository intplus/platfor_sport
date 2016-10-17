package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value = "studentDatabaseDao")
public class StudentDatabaseDao extends HibernateAbstractDao<Student> implements StudentDao {

    public StudentDatabaseDao() {

    }
//
//    @Override
//    public Student getByUsername(String surname) {
//        Criteria criteria =getSession().createCriteria(Student.class);
//        criteria.add(Restrictions.eq("surname", surname));
//        return (Student) criteria.uniqueResult();
//    }
}
