package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository(value = "studentDatabaseDao")
public class StudentDatabaseDao extends HibernateAbstractDao<Student> implements StudentDao {

    public StudentDatabaseDao() {

    }

    @Override
    public Student getByUsername(String username) {
        Criteria criteria =getSession().createCriteria(Student.class);
        criteria.add(Restrictions.eq("username", username));
        return (Student) criteria.uniqueResult();
    }
}
