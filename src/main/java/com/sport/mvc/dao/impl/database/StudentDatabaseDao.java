package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value = "studentDatabaseDao")
public class StudentDatabaseDao extends HibernateAbstractDao<Student> implements StudentDao {

    public StudentDatabaseDao() {
    }
//    public List<Student> getStudentByOnlyUnknownStudent() {
//        List<Student> method = getSession().createQuery("from Student s WHERE s.phone !='' AND s.surname LIKE '' AND s.name LIKE '' AND s.email LIKE ''").list();
//        return  method;
//    }
}
